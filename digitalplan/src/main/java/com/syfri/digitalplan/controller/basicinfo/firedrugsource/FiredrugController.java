package com.syfri.digitalplan.controller.basicinfo.firedrugsource;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.digitalplan.model.basicinfo.firedrugsource.FiredrugVO;
import com.syfri.digitalplan.service.basicinfo.firedrugsource.FiredrugService;
import com.syfri.baseapi.controller.BaseController;

import java.util.List;


@RestController
@RequestMapping("firedrug")
public class FiredrugController  extends BaseController<FiredrugVO>{

	@Autowired
	private FiredrugService firedrugService;

	@Override
	public FiredrugService getBaseService() {
		return this.firedrugService;
	}

	@ApiOperation(value="消防药剂新增",notes="新增")
	@ApiImplicitParam(name="vo",value="消防药剂")
	@RequiresPermissions("basicinfo/firedrug:add")
	@PostMapping("/insertByVO")
	public @ResponseBody ResultVO insertByVO(@RequestBody FiredrugVO firedrugVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(firedrugService.doInsertByVO(firedrugVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	@ApiOperation(value="删除消防药剂",notes="列表信息")
	@ApiImplicitParam(name="vo",value="消防药剂")
	@RequiresPermissions("basicinfo/firedrug:delete")
	@PostMapping("/doDeleteDrug")
	public @ResponseBody ResultVO doDeleteDrug(@RequestBody List<FiredrugVO> firedrugList) {
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(firedrugService.doDeleteDrug(firedrugList));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	@ApiOperation(value="修改消防药剂",notes="列表信息")
	@ApiImplicitParam(name="vo",value="消防药剂")
	@RequiresPermissions("basicinfo/firedrug:edit")
	@PostMapping("/doUpdateDrug")
	public @ResponseBody ResultVO doUpdateDrug(@RequestBody FiredrugVO firedrugVO) {
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(firedrugService.doUpdateDrug(firedrugVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
}
