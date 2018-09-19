package com.syfri.digitalplan.controller.jxcsplan;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.digitalplan.model.jxcsplan.JxcsdlyzVO;
import com.syfri.digitalplan.service.jxcsplan.JxcsdlyzService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("jxcsdlyz")
public class JxcsdlyzController  extends BaseController<JxcsdlyzVO>{

	@Autowired
	private JxcsdlyzService jxcsdlyzService;

	@Override
	public JxcsdlyzService getBaseService() {
		return this.jxcsdlyzService;
	}

}
