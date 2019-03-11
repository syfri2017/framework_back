package com.syfri.portalservice.controller.prediction;

import com.syfri.portalservice.controller.base.BaseController;
import com.syfri.portalservice.model.prediction.QykpxxVO;
import com.syfri.portalservice.service.prediction.QykpxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
