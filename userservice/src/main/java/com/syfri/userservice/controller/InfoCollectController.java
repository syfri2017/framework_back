package com.syfri.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.userservice.model.InfocollectVO;
import com.syfri.userservice.service.InfoCollectService;
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
