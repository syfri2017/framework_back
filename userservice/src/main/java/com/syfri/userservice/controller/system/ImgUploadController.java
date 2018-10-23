package com.syfri.userservice.controller.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.userservice.dao.system.ImgUploadDAO;
import com.syfri.userservice.model.system.CodelistVO;
import com.syfri.userservice.service.system.CodelistService;
import com.syfri.userservice.utils.Base64ImageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.syfri.userservice.model.system.ImgUploadVO;
import com.syfri.userservice.service.system.ImgUploadService;
import com.syfri.baseapi.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("imgupload")
public class ImgUploadController extends BaseController<ImgUploadVO>{

	@Autowired
	protected Environment environment;

	@Autowired
	private ImgUploadService imgUploadService;

	@Autowired
	private CodelistService codelistService;

	@Autowired
	private ImgUploadDAO imgUploadDAO;

	@Override
	public ImgUploadService getBaseService() {
		return this.imgUploadService;
	}


	@ModelAttribute
	public void Model(Model model){
		if (environment.containsProperty("server.context-path")) {
			model.addAttribute("contextPath", environment.getProperty("server.context-path"));
		}else{
			model.addAttribute("contextPath", "/");
		}
	}

	@GetMapping("")
	public String getImgUpload(Model model, @RequestParam(value="index") String index){
		model.addAttribute("index", index);
		return "system/imgUpload";
	}

	/**
	 * @Description: 获取所有的图片类型
	 * @Param: []
	 * @Return: com.syfri.baseapi.model.ResultVO
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/21 9:29
	 */
	@ApiOperation(value="获取所有的图片类型",notes="查询")
	@GetMapping("/getAll")
	public @ResponseBody ResultVO findAll(){
		ResultVO resultVO = ResultVO.build();
		try{
			CodelistVO codelistVO = new CodelistVO();
			resultVO.setResult(codelistService.doSearchListByVO(codelistVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * @Description: 获取已存的图片类型
	 * @Param: []
	 * @Return: com.syfri.baseapi.model.ResultVO
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/21 9:29
	 */
	@ApiOperation(value="获取已存的图片类型",notes="查询")
	@GetMapping("/getSaved")
	public @ResponseBody ResultVO findSaved(){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(imgUploadService.doSearchSavedListByVO());
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
	/**
	 * @Description: 根据条件获取图片信息
	 * @Param: [imgUploadVO]
	 * @Return: com.syfri.baseapi.model.ResultVO
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/21 9:29
	 */
	@ApiOperation(value="根据条件获取图片信息",notes="列表信息")
	@ApiImplicitParam(name="imgUploadVO",value="图片对象")
	@PostMapping("/findByVO")
	public @ResponseBody ResultVO findByVO(@RequestBody ImgUploadVO imgUploadVO){
		ResultVO resultVO = ResultVO.build();
		try{
			PageHelper.startPage(imgUploadVO.getPageNum(),imgUploadVO.getPageSize());
			List<ImgUploadVO> list = imgUploadService.doSearchListByVO(imgUploadVO);
			PageInfo<ImgUploadVO> pageInfo = new PageInfo<>(list);
			resultVO.setResult(pageInfo);
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * @Description: 根据图片名查询图片数量
	 * @Param: [picName]
	 * @Return: com.syfri.baseapi.model.ResultVO
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/4/27 9:53
	 */
	@ApiOperation(value="根据图片名查询图片数量",notes="查询")
	@ApiImplicitParam(name="picName",value="图片名")
	@GetMapping("/getNum/{picName}")
	public @ResponseBody ResultVO getNum(@PathVariable String picName){
		ResultVO resultVO = ResultVO.build();
		try{
			ImgUploadVO imgUploadVO = new ImgUploadVO();
			imgUploadVO.setPicName(picName);
			if(imgUploadService.doSearchListByPicName(imgUploadVO).size() == 0){
				resultVO.setResult(0);
			}else{
				resultVO.setResult(1);
			}
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * @Description: 新增图片信息
	 * @Param: [imgUploadVO]
	 * @Return: com.syfri.baseapi.model.ResultVO
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/21 9:34
	 */
	@ApiOperation(value="新增图片信息",notes="新增")
	@ApiImplicitParam(name="vo",value="图片对象")
	@RequiresPermissions("system/imgupload:add")
	@PostMapping("/detail/insertByVO")
	public @ResponseBody ResultVO insertByVO(@RequestBody ImgUploadVO imgUploadVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(imgUploadService.doInsertImgByVO(imgUploadVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
	/**
	 * @Description: 附件上传
	 * @Param: [request]
	 * @Return: java.util.Map<java.lang.String,java.lang.Object>
	 * @throws UnsupportedEncodingException
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/4/20 16:44
	 */
	@ApiOperation(value="附件上传",notes="列表信息")
	@ApiImplicitParam(name="vo",value="图片对象")
	@RequestMapping("/insertImage")
	@ResponseBody
	public
	Map<String, Object> uploadAttachment(HttpServletRequest request, ImgUploadVO UploadVO,String picName,String picType)
			throws UnsupportedEncodingException {

		System.out.print(picName);
		System.out.print(picType);
		Map<String, Object> result = new HashMap<String, Object>();
		int res = 0;
		try {
			byte[] buffer = null;
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iterator = multipartRequest.getFileNames();

			while (iterator.hasNext()) {
				MultipartFile multipartFile = multipartRequest.getFile(iterator.next());

				// 获取文件名
				String fileName = multipartFile.getOriginalFilename();

				if ("".equals(multipartFile.getOriginalFilename())) throw new RuntimeException("文件为空");
				InputStream fis = null;
				try {
					fis = multipartFile.getInputStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b = new byte[1024];
				int n;
				while ((n = fis.read(b)) != -1)
				{
					bos.write(b, 0, n);
				}
				fis.close();
				bos.close();
				buffer = bos.toByteArray();

				ImgUploadVO imgUploadVO=new ImgUploadVO();
				imgUploadVO.setImgFile(buffer);
				imgUploadVO.setPicName(UploadVO.getPicName());
				imgUploadVO.setPicType(UploadVO.getPicType());

				imgUploadDAO.doInsertImg(imgUploadVO);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @Description: 删除图片
	 * @Param: [id]
	 * @Return: com.syfri.baseapi.model.ResultVO
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/21 9:35
	 */
	@ApiOperation(value="根据主键删除图片",notes="删除")
	@ApiImplicitParam(name="id",value="图片主键")
	@RequiresPermissions("system/imgupload:delete")
	@PostMapping("/detail/deleteByIds")
	public @ResponseBody ResultVO deleteDetailByIds(@RequestBody String id){
		JSONObject jsonObject = JSON.parseObject(id);
		JSONArray ids = jsonObject.getJSONArray("ids");
		ResultVO resultVO = ResultVO.build();
		try{
			for(int i=0;i<ids.size();i++){
				String pkid = (String)ids.get(i);
				imgUploadService.doDeleteById(pkid);
			}
			resultVO.setMsg("删除成功");
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * @Description: 根据id获取图片信息
	 * @Param: [pkid]
	 * @Return: com.syfri.baseapi.model.ResultVO
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/21 9:35
	 */
	@ApiOperation(value="根据id获取图片信息",notes="列表信息")
	@GetMapping("/doFindById/{pkid}")
	public @ResponseBody ResultVO getDetail(@PathVariable String pkid){
		ResultVO resultVO = ResultVO.build();
		try{
			ImgUploadVO result = imgUploadService.doFindById(pkid);
			//将二进制转为Base64格式字符串
			String photo64 = Base64ImageUtil.byteArr2String(result.getPicBlob());
			result.setPhoto64(photo64);
			resultVO.setResult(result);
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * @Description: 修改图片信息
	 * @Param: [imgUploadVO]
	 * @Return: com.syfri.baseapi.model.ResultVO
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/5/21 9:35
	 */
	@ApiOperation(value="修改图片信息",notes="修改")
	@ApiImplicitParam(name="vo",value="图片对象")
	@RequiresPermissions("system/imgupload:edit")
	@PostMapping("/detail/updateByVO")
	public @ResponseBody ResultVO updateByVO(@RequestBody ImgUploadVO imgUploadVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(imgUploadService.doUpdateImgByVO(imgUploadVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	/**
	 * @Description: 根据手动输入图片类型查询图片数量
	 * @Param: [picName]
	 * @Return: com.syfri.baseapi.model.ResultVO
	 * @Author: dongbo
	 * @Modified By:
	 * @Date: 2018/4/27 9:53
	 */
	@ApiOperation(value="根据手动输入图片类型查询图片数量",notes="查询")
	@ApiImplicitParam(name="picType",value="图片类型")
	@GetMapping("/getInputNum/{picType}")
	public @ResponseBody ResultVO getInputNum(@PathVariable String picType){
		ResultVO resultVO = ResultVO.build();
		try{
			ImgUploadVO imgUploadVO = new ImgUploadVO();
			imgUploadVO.setPicType(picType);
			List<ImgUploadVO> result = imgUploadService.doSearchListByInputPicType(imgUploadVO);
			resultVO.setResult(result);
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
}
