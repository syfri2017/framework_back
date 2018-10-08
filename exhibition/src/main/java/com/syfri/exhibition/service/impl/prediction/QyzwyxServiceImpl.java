package com.syfri.exhibition.service.impl.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.exhibition.dao.prediction.QyzwyxDAO;
import com.syfri.exhibition.model.prediction.QyzwyxVO;
import com.syfri.exhibition.service.prediction.QyzwyxService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qyzwyxService")
public class QyzwyxServiceImpl extends BaseServiceImpl<QyzwyxVO> implements QyzwyxService {

	@Autowired
	private QyzwyxDAO qyzwyxDAO;

	@Override
	public QyzwyxDAO getBaseDAO() {
		return qyzwyxDAO;
	}
}