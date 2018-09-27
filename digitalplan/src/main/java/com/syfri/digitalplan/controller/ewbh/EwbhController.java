package com.syfri.digitalplan.controller.ewbh;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.digitalplan.model.ewbh.EwbhVO;
import com.syfri.digitalplan.service.ewbh.EwbhService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("ewbh")
public class EwbhController  extends BaseController<EwbhVO>{

	@Autowired
	private EwbhService ewbhService;

	@Override
	public EwbhService getBaseService() {
		return this.ewbhService;
	}

}
