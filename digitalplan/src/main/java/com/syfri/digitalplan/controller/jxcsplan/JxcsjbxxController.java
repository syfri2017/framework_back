package com.syfri.digitalplan.controller.jxcsplan;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.digitalplan.model.jxcsplan.JxcsjbxxVO;
import com.syfri.digitalplan.service.jxcsplan.JxcsjbxxService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("jxcsjbxx")
public class JxcsjbxxController  extends BaseController<JxcsjbxxVO>{

	@Autowired
	private JxcsjbxxService jxcsjbxxService;

	@Override
	public JxcsjbxxService getBaseService() {
		return this.jxcsjbxxService;
	}

}
