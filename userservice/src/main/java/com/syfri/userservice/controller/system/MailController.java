package com.syfri.userservice.controller.system;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.userservice.model.system.MailVO;
import com.syfri.userservice.service.system.MailService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("mail")
public class MailController  extends BaseController<MailVO>{

	@Autowired
	private MailService mailService;

	@Override
	public MailService getBaseService() {
		return this.mailService;
	}

}
