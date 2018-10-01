package com.syfri.exhibition.service.impl.ybm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.exhibition.dao.ybm.QyjbxxDAO;
import com.syfri.exhibition.model.ybm.QyjbxxVO;
import com.syfri.exhibition.service.ybm.QyjbxxService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qyjbxxService")
public class QyjbxxServiceImpl extends BaseServiceImpl<QyjbxxVO> implements QyjbxxService {

	@Autowired
	private QyjbxxDAO qyjbxxDAO;

	@Override
	public QyjbxxDAO getBaseDAO() {
		return qyjbxxDAO;
	}
}