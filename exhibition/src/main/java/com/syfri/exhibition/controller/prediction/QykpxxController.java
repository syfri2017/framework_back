package com.syfri.exhibition.controller.prediction;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.exhibition.model.prediction.QykpxxVO;
import com.syfri.exhibition.service.prediction.QykpxxService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("qykpxx")
public class QykpxxController  extends BaseController<QykpxxVO>{

	@Autowired
	private QykpxxService qykpxxService;

	@Override
	public QykpxxService getBaseService() {
		return this.qykpxxService;
	}

}
