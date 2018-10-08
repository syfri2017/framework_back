package com.syfri.exhibition.controller.prediction;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.exhibition.model.prediction.QywjdcVO;
import com.syfri.exhibition.service.prediction.QywjdcService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("qywjdc")
public class QywjdcController  extends BaseController<QywjdcVO>{

	@Autowired
	private QywjdcService qywjdcService;

	@Override
	public QywjdcService getBaseService() {
		return this.qywjdcService;
	}

}
