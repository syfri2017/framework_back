package com.syfri.portalservice.service.impl.prediction;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.portalservice.dao.prediction.QywjdcDAO;
import com.syfri.portalservice.model.prediction.QywjdcVO;
import com.syfri.portalservice.service.prediction.QywjdcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qywjdcService")
public class QywjdcServiceImpl extends BaseServiceImpl<QywjdcVO> implements QywjdcService {

	@Autowired
	private QywjdcDAO qywjdcDAO;

	@Override
	public QywjdcDAO getBaseDAO() {
		return qywjdcDAO;
	}
}