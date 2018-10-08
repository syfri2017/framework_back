package com.syfri.exhibition.service.impl.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.exhibition.dao.prediction.QywjdcDAO;
import com.syfri.exhibition.model.prediction.QywjdcVO;
import com.syfri.exhibition.service.prediction.QywjdcService;
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