package com.syfri.digitalplan.service.impl.jxcsplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.jxcsplan.JxcsjbxxDAO;
import com.syfri.digitalplan.model.jxcsplan.JxcsjbxxVO;
import com.syfri.digitalplan.service.jxcsplan.JxcsjbxxService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("jxcsjbxxService")
public class JxcsjbxxServiceImpl extends BaseServiceImpl<JxcsjbxxVO> implements JxcsjbxxService {

	@Autowired
	private JxcsjbxxDAO jxcsjbxxDAO;

	@Override
	public JxcsjbxxDAO getBaseDAO() {
		return jxcsjbxxDAO;
	}
}