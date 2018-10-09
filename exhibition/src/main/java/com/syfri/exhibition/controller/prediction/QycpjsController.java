package com.syfri.exhibition.controller.prediction;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.exhibition.model.prediction.QycpjsVO;
import com.syfri.exhibition.service.prediction.QycpjsService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("qycpjs")
public class QycpjsController  extends BaseController<QycpjsVO>{

	@Autowired
	private QycpjsService qycpjsService;

	@Override
	public QycpjsService getBaseService() {
		return this.qycpjsService;
	}

}
