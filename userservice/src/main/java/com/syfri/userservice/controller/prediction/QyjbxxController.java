package com.syfri.userservice.controller.prediction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import com.syfri.userservice.utils.Base64ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.service.prediction.QyjbxxService;
import com.syfri.baseapi.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("qyjbxx")
public class QyjbxxController  extends BaseController<QyjbxxVO>{

	@Autowired
	private QyjbxxService qyjbxxService;

	@Override
	public QyjbxxService getBaseService() {
		return this.qyjbxxService;
	}

	/**
	 * @Description: 根据企业id获取企业信息
	 * @Author: rliu
	 * @Date: 2018/10/9 10:35
	 */
	@ApiOperation(value="根据企业id获取企业信息",notes="vo")
	@RequestMapping("/doFindJbxxById/{qyid}")
	public @ResponseBody ResultVO doFindJbxxById(@PathVariable String qyid){
		ResultVO resultVO = ResultVO.build();
		try{
			QyjbxxVO result = qyjbxxService.doFindById(qyid);
			//将二进制转为Base64格式字符串
			String photo64 = Base64ImageUtil.byteArr2String(result.getYyzz());
			result.setYyzzBase64(photo64);
			resultVO.setResult(result);
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

    /**
     * @Description: 根据用户信息、公司名称获取企业基本信息
     * @Author: li.xue
	 * @Date: 2018/10/9 11:05
	 */
    @ApiOperation(value="根据企业查询企业信息",notes="列表")
    @ApiImplicitParam(name="vo",value="企业对象")
    @PostMapping("/doFindZsxxByQyjbxx")
    public @ResponseBody ResultVO doFindZsxxByQyjbxx(@RequestBody QyjbxxVO qyjbxxVO){
        ResultVO resultVO = ResultVO.build();
        try{
			PageHelper.startPage(qyjbxxVO.getPageNum(),qyjbxxVO.getPageSize());
			List<QyjbxxVO> list = qyjbxxService.doFindZsxxByQyjbxx(qyjbxxVO);
			PageInfo<QyjbxxVO> pageInfo = new PageInfo<>(list);
            resultVO.setResult(pageInfo);
        }catch(Exception e){
            logger.error("{}",e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

	/**
	 * @Description: 根据企业id更新基本信息
	 * @Author: rliu
	 * @Date: 2018/10/9 10:35
	 */
	@ApiOperation(value="",notes="修改")
	@ApiImplicitParam(name="vo",value="企业对象")
//	@RequiresPermissions("prediction/exhprediction_approve:approve")
	@PostMapping("/updateByVO")
	public @ResponseBody ResultVO updateByVO(@RequestBody QyjbxxVO qyjbxxVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(qyjbxxService.doUpdateByVO(qyjbxxVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	//add by yushch 20181010
	@ApiOperation(value="根据VO保存",notes="保存")
	@PostMapping("/doInsertByVo")
	public @ResponseBody ResultVO save(@RequestBody QyjbxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(qyjbxxService.doInsertJbxxByVO(vo));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}

		return 	resultVO;
	}
	@ApiOperation(value = "根据id更新基本信息", notes = "修改")
	@PostMapping("/doUpdateByVO")
	public @ResponseBody ResultVO doUpdateByVO(@RequestBody QyjbxxVO vo) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(qyjbxxService.doUpdateByVO(vo));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	@ApiOperation(value = "根据id更新基本信息", notes = "删除")
	@PostMapping("/doDeleteJbxx")
	public @ResponseBody ResultVO doDeleteJbxx(@RequestBody List<QyjbxxVO> voList) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(qyjbxxService.doDeleteJbxx(voList));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
	//上传图片并加水印 by yushch
	@RequestMapping(value = "/upload")
	@ResponseBody
	public Map<String, Object> uploadAttachment(HttpServletRequest request, QyjbxxVO vo)
			throws UnsupportedEncodingException {

		Map<String, Object> result = new HashMap<String, Object>();
		try {
			byte[] buffer = null;
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iterator = multipartRequest.getFileNames();

			while (iterator.hasNext()) {
				MultipartFile multipartFile = multipartRequest.getFile(iterator.next());
				if ("".equals(multipartFile.getOriginalFilename())) throw new RuntimeException("文件为空");
				InputStream fis = null;
				try {
					fis = multipartFile.getInputStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//加水印
				Image image = ImageIO.read(fis);
				BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = bi.createGraphics();
				g2.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
				//颜色
				Color color=new Color(105,105,105);
				g2.setColor(color);
				//字体大小为图片宽的1/12
				g2.setFont(new Font("宋体", Font.BOLD, image.getWidth(null)/12));
				//透明度
				float alpha = 0.5f;
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
						alpha));
				//int degree = -60;
				//g2.rotate(Math.toRadians(degree));//设置水印旋转
				String text = "仅供十八届消防展审核";
				g2.drawString(text, 0,image.getHeight(null)/2);
				g2.dispose();
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ImageIO.write( bi, "jpg", bos );
				bos.flush();
				fis.close();
				bos.close();
				buffer = bos.toByteArray();
				vo.setYyzz(buffer);
				qyjbxxService.doUpdateByVO(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}

	//add by yushch 20181014
	@ApiOperation(value="根据userid获取企业信息",notes="vo")
	@PostMapping("/doFindByUserid")
	public @ResponseBody ResultVO doFindByUserid(@RequestBody QyjbxxVO vo){
		ResultVO resultVO = ResultVO.build();
		try{
			QyjbxxVO result = qyjbxxService.doFindByVO(vo);
			if(result != null){
				//将二进制转为Base64格式字符串
				String photo64 = Base64ImageUtil.byteArr2String(result.getYyzz());
				result.setYyzzBase64(photo64);
			}
			resultVO.setResult(result);
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	//查询当前邮箱是否被注册（用户表、基本信息表）
    //add by yushch 20181018
    @ApiOperation(value="根据邮箱查询用户数量",notes="查询")
    @ApiImplicitParam(name="mail",value="邮箱")
    @GetMapping("/getMailNum/{mail}")
    public @ResponseBody ResultVO getMailNum(@PathVariable String mail){
        ResultVO resultVO = ResultVO.build();
        try{
            resultVO.setResult(qyjbxxService.doSearchCountByMail(mail.replace("_",".")));
        }catch(Exception e){
            logger.error("{}",e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }
}
