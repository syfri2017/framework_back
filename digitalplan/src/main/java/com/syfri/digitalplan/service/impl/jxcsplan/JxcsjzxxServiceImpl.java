package com.syfri.digitalplan.service.impl.jxcsplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.jxcsplan.JxcsjzxxDAO;
import com.syfri.digitalplan.model.jxcsplan.JxcsjzxxVO;
import com.syfri.digitalplan.service.jxcsplan.JxcsjzxxService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("jxcsjzxxService")
public class JxcsjzxxServiceImpl extends BaseServiceImpl<JxcsjzxxVO> implements JxcsjzxxService {

	@Autowired
	private JxcsjzxxDAO jxcsjzxxDAO;

	@Override
	public JxcsjzxxDAO getBaseDAO() {
		return jxcsjzxxDAO;
	}

	public List<JxcsjzxxVO> doFindJzxxByDwid(String dwid){
		return jxcsjzxxDAO.doFindJzxxByDwid(dwid);
	}
}