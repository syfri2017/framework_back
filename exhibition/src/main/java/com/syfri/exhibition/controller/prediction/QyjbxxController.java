package com.syfri.exhibition.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import com.syfri.exhibition.utils.Base64ImageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.exhibition.model.prediction.QyjbxxVO;
import com.syfri.exhibition.service.prediction.QyjbxxService;
import com.syfri.baseapi.controller.BaseController;

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
            resultVO.setResult(qyjbxxService.doFindZsxxByQyjbxx(qyjbxxVO));
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

	/**
	 * @Description: 营业执照转base64
	 * @Author: rliu
	 * @Date: 2018/10/9 10:35
	 */
	@ApiOperation(value="营业执照转base64",notes="vo")
	@GetMapping("/doYyzzToBase64")
	public @ResponseBody ResultVO doYyzzToBase64(@RequestBody QyjbxxVO qyjbxxVO){
		ResultVO resultVO = ResultVO.build();
		try{
			QyjbxxVO result = new QyjbxxVO();
			//将二进制转为Base64格式字符串
			String photo64 = Base64ImageUtil.byteArr2String(qyjbxxVO.getYyzz());
			result.setYyzzBase64(photo64);
			resultVO.setResult(result);
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
}
