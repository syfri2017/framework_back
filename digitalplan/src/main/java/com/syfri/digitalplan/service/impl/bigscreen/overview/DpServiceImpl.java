package com.syfri.digitalplan.service.impl.bigscreen.overview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.bigscreen.overview.DpDAO;
import com.syfri.digitalplan.model.bigscreen.overview.DpVO;
import com.syfri.digitalplan.service.bigscreen.overview.DpService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("dpService")
public class DpServiceImpl extends BaseServiceImpl<DpVO> implements DpService {

	@Autowired
	private DpDAO dpDAO;

	@Override
	public DpDAO getBaseDAO() {
		return dpDAO;
	}

	@Override
	public List<DpVO> getListByType(DpVO vo) {
		return this.dpDAO.getListByType(vo);
	}
}