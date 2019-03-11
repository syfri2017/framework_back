package com.syfri.portalservice.service.impl.prediction;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.portalservice.dao.prediction.QycpjsDAO;
import com.syfri.portalservice.model.prediction.QycpjsVO;
import com.syfri.portalservice.service.prediction.QycpjsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qycpjsService")
public class QycpjsServiceImpl extends BaseServiceImpl<QycpjsVO> implements QycpjsService {

	@Autowired
	private QycpjsDAO qycpjsDAO;

	@Override
	public QycpjsDAO getBaseDAO() {
		return qycpjsDAO;
	}
}