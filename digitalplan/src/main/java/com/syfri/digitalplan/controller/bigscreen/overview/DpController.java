package com.syfri.digitalplan.controller.bigscreen.overview;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.digitalplan.model.bigscreen.overview.DpVO;
import com.syfri.digitalplan.service.bigscreen.overview.DpService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("dp")
public class DpController  extends BaseController<DpVO>{

	@Autowired
	private DpService dpService;

	@Override
	public DpService getBaseService() {
		return this.dpService;
	}

	@ApiOperation(value="通过DpVO获取列表",notes="查询")
	@ApiImplicitParam(name="vo",value="Dp对象")
	@PostMapping("/getListByType")
	public @ResponseBody ResultVO getListByType(@RequestBody DpVO vo){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(dpService.getListByType(vo));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
}
