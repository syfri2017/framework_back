package com.syfri.portalservice.controller.prediction;


import com.syfri.portalservice.controller.base.BaseController;
import com.syfri.portalservice.model.prediction.QywjdcVO;
import com.syfri.portalservice.service.prediction.QywjdcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
