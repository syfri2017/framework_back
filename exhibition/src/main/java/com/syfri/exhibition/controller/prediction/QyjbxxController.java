package com.syfri.exhibition.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
	 * 根据用户信息、公司名称获取企业基本信息
	 * by li.xue 2018/10/9 11:05
	 */
	@ApiOperation(value="根据企业查询企业信息",notes="列表")
	@ApiImplicitParam(name="vo",value="企业对象")
	@PostMapping("/findByVO")
	public @ResponseBody ResultVO findByVO(@RequestBody QyjbxxVO qyjbxxVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(qyjbxxService.doFindZsxxByQyjbxx(qyjbxxVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}


}
