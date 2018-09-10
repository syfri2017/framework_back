package com.syfri.digitalplan.service.impl.jxcsplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.jxcsplan.JxcsxfssDAO;
import com.syfri.digitalplan.model.jxcsplan.JxcsxfssVO;
import com.syfri.digitalplan.service.jxcsplan.JxcsxfssService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("jxcsxfssService")
public class JxcsxfssServiceImpl extends BaseServiceImpl<JxcsxfssVO> implements JxcsxfssService {

	@Autowired
	private JxcsxfssDAO jxcsxfssDAO;

	@Override
	public JxcsxfssDAO getBaseDAO() {
		return jxcsxfssDAO;
	}

	public List<JxcsxfssVO> doFindXfssByDwid(String dwid){
		return jxcsxfssDAO.doFindXfssByDwid(dwid);
	}
}