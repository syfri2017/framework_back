package com.syfri.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.InfoCollectDAO;
import com.syfri.userservice.model.InfocollectVO;
import com.syfri.userservice.service.InfoCollectService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("infoCollectService")
public class InfoCollectServiceImpl extends BaseServiceImpl<InfocollectVO> implements InfoCollectService {

	@Autowired
	private InfoCollectDAO infocollectDAO;

	@Override
	public InfoCollectDAO getBaseDAO() {
		return infocollectDAO;
	}
}