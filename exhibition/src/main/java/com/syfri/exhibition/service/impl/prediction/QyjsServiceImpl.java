package com.syfri.exhibition.service.impl.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.exhibition.dao.prediction.QyjsDAO;
import com.syfri.exhibition.model.prediction.QyjsVO;
import com.syfri.exhibition.service.prediction.QyjsService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qyjsService")
public class QyjsServiceImpl extends BaseServiceImpl<QyjsVO> implements QyjsService {

	@Autowired
	private QyjsDAO qyjsDAO;

	@Override
	public QyjsDAO getBaseDAO() {
		return qyjsDAO;
	}
}