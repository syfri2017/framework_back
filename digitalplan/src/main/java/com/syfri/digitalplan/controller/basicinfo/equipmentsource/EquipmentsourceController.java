package com.syfri.digitalplan.controller.basicinfo.equipmentsource;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.digitalplan.model.basicinfo.equipmentsource.EquipmentVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.syfri.digitalplan.service.basicinfo.equipmentsource.EquipmentsourceService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("equipmentsource")
public class EquipmentsourceController  extends BaseController<EquipmentVO>{

	@Autowired
	private EquipmentsourceService equipmentsourceService;

	@Override
	public EquipmentsourceService getBaseService() {
		return this.equipmentsourceService;
	}

	@Autowired
	protected Environment environment;

	@ApiOperation(value="装备器材新增",notes="新增")
	@ApiImplicitParam(name="vo",value="装备器材")
	@PostMapping("/insertByVO")
	public @ResponseBody ResultVO insertByVO(@RequestBody EquipmentVO equipmentVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(equipmentsourceService.doInsertEquipment(equipmentVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

}
