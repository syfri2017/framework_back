package com.syfri.userservice.service.impl.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.prediction.QykpxxDAO;
import com.syfri.userservice.model.prediction.QykpxxVO;
import com.syfri.userservice.service.prediction.QykpxxService;
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