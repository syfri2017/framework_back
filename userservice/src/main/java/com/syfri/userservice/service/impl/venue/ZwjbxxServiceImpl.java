package com.syfri.userservice.service.impl.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.venue.ZwjbxxDAO;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.service.venue.ZwjbxxService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("zwjbxxService")
public class ZwjbxxServiceImpl extends BaseServiceImpl<ZwjbxxVO> implements ZwjbxxService {

	@Autowired
	private ZwjbxxDAO zwjbxxDAO;

	@Override
	public ZwjbxxDAO getBaseDAO() {
		return zwjbxxDAO;
	}


}