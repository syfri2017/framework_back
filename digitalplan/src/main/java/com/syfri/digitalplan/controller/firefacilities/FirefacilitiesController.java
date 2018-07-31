package com.syfri.digitalplan.controller.firefacilities;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.digitalplan.model.firefacilities.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.digitalplan.service.firefacilities.FirefacilitiesService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("firefacilities")
public class FirefacilitiesController  extends BaseController<FirefacilitiesVO>{

	@Autowired
	private FirefacilitiesService firefacilitiesService;

	@Override
	public FirefacilitiesService getBaseService() {
		return this.firefacilitiesService;
	}

	@ApiOperation(value="查询安全设施列表",notes="列表信息")
	@ApiImplicitParam(name="vo",value = "业务实体")
	@PostMapping("doFindlist")
	public @ResponseBody ResultVO list(@RequestBody FirefacilitiesVO vo ) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(firefacilitiesService.doFindlist(vo));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}


	@ApiOperation(value="查询安全设施详情",notes="详情信息")
	@ApiImplicitParam(name="vo",value = "业务实体")
	@PostMapping("doFindXfssDetail")
	public @ResponseBody ResultVO doFindXfssDetail(@RequestBody FirefacilitiesVO vo) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(firefacilitiesService.doFindXfssDetail(vo));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}



}
