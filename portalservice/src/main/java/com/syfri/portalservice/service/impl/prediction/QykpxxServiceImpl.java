package com.syfri.portalservice.service.impl.prediction;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.portalservice.dao.prediction.QykpxxDAO;
import com.syfri.portalservice.model.prediction.QykpxxVO;
import com.syfri.portalservice.service.prediction.QykpxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qykpxxService")
public class QykpxxServiceImpl extends BaseServiceImpl<QykpxxVO> implements QykpxxService {

	@Autowired
	private QykpxxDAO qykpxxDAO;

	@Override
	public QykpxxDAO getBaseDAO() {
		return qykpxxDAO;
	}
}