package com.syfri.digitalplan.service.impl.ewbh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.ewbh.EwbhDAO;
import com.syfri.digitalplan.model.ewbh.EwbhVO;
import com.syfri.digitalplan.service.ewbh.EwbhService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("ewbhService")
public class EwbhServiceImpl extends BaseServiceImpl<EwbhVO> implements EwbhService {

	@Autowired
	private EwbhDAO ewbhDAO;

	@Override
	public EwbhDAO getBaseDAO() {
		return ewbhDAO;
	}
}