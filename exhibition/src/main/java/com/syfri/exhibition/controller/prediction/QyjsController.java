package com.syfri.exhibition.controller.prediction;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.exhibition.model.prediction.QyjsVO;
import com.syfri.exhibition.service.prediction.QyjsService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("qyjs")
public class QyjsController  extends BaseController<QyjsVO>{

	@Autowired
	private QyjsService qyjsService;

	@Override
	public QyjsService getBaseService() {
		return this.qyjsService;
	}

}
