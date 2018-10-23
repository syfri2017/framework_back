package com.syfri.userservice.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.system.InfoCollectDAO;
import com.syfri.userservice.model.system.InfocollectVO;
import com.syfri.userservice.service.system.InfoCollectService;
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