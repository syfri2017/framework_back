package com.syfri.userservice.service.impl.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.venue.ZwmkDAO;
import com.syfri.userservice.model.venue.ZwmkVO;
import com.syfri.userservice.service.venue.ZwmkService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("zwmkService")
public class ZwmkServiceImpl extends BaseServiceImpl<ZwmkVO> implements ZwmkService {

	@Autowired
	private ZwmkDAO zwmkDAO;

	@Override
	public ZwmkDAO getBaseDAO() {
		return zwmkDAO;
	}
}