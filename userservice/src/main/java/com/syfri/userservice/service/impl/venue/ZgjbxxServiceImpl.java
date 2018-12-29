package com.syfri.userservice.service.impl.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.venue.ZgjbxxDAO;
import com.syfri.userservice.model.venue.ZgjbxxVO;
import com.syfri.userservice.service.venue.ZgjbxxService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("zgjbxxService")
public class ZgjbxxServiceImpl extends BaseServiceImpl<ZgjbxxVO> implements ZgjbxxService {

	@Autowired
	private ZgjbxxDAO zgjbxxDAO;

	@Override
	public ZgjbxxDAO getBaseDAO() {
		return zgjbxxDAO;
	}

	public List<ZgjbxxVO> doSearchHbListByVO(ZgjbxxVO vo){
		return zgjbxxDAO.doSearchHbListByVO(vo);
	}
	public List<ZgjbxxVO> doSearchHbTpListByVO(ZgjbxxVO vo){
		return zgjbxxDAO.doSearchHbTpListByVO(vo);
	}
	public List<ZgjbxxVO> doSearchDataListByVO(ZgjbxxVO vo){
		return zgjbxxDAO.doSearchDataListByVO(vo);
	}
	public List<ZgjbxxVO> doSearchZgmc(){
		return zgjbxxDAO.doSearchZgmc();
	}
}