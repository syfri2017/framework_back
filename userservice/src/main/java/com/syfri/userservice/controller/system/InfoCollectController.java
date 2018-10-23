package com.syfri.userservice.controller.system;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.userservice.model.system.InfocollectVO;
import com.syfri.userservice.service.system.InfoCollectService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("infocollect")
public class InfoCollectController extends BaseController<InfocollectVO>{

	@Autowired
	private InfoCollectService infocollectService;

	@Override
	public InfoCollectService getBaseService() {
		return this.infocollectService;
	}

}
