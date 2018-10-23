package com.syfri.userservice.service.impl.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.prediction.QycpjsDAO;
import com.syfri.userservice.model.prediction.QycpjsVO;
import com.syfri.userservice.service.prediction.QycpjsService;
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