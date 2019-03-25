package com.syfri.portalservice.service.impl.venue;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.portalservice.dao.venue.ZwmkDAO;
import com.syfri.portalservice.model.venue.ZwmkVO;
import com.syfri.portalservice.service.venue.ZwmkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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