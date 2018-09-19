package com.syfri.digitalplan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.UtilDAO;
import com.syfri.digitalplan.model.UtilXfdzVO;
import com.syfri.digitalplan.service.UtilService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("utilService")
public class UtilServiceImpl extends BaseServiceImpl<UtilXfdzVO> implements UtilService {

	@Autowired
	private UtilDAO utilDAO;

	@Override
	public UtilDAO getBaseDAO() {
		return utilDAO;
	}

	/*--查询到消防总队--*/
	@Override
	public List<UtilXfdzVO> doSearchContingents(){
		return utilDAO.doSearchContingents();
	}

	/*--根据总队ID获取其下属队站 by li.xue 2018/8/29.--*/
	@Override
	public List<UtilXfdzVO> doFindXfdzByZongdId(String dzid){
		return utilDAO.doFindXfdzByZongdId(dzid);
	}
}