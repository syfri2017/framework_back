package com.syfri.exhibition.controller.prediction;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.exhibition.model.prediction.QyjbxxVO;
import com.syfri.exhibition.service.prediction.QyjbxxService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("qyjbxx")
public class QyjbxxController  extends BaseController<QyjbxxVO>{

	@Autowired
	private QyjbxxService qyjbxxService;

	@Override
	public QyjbxxService getBaseService() {
		return this.qyjbxxService;
	}

}
