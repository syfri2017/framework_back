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

	@Override
	public int doDeleteByList(List<JxcsjzxxVO> jxcsjzxxList) {
		int count = 0;
		if (jxcsjzxxList.size() > 0) {
			for (JxcsjzxxVO jxcsjzxxVO : jxcsjzxxList) {
				JxcsjzxxVO vo = new JxcsjzxxVO();
				vo.setJzid(jxcsjzxxVO.getJzid());
				vo.setXgrid(jxcsjzxxVO.getXgrid());
				vo.setXgrmc(jxcsjzxxVO.getXgrmc());
//				vo.setXgsj("1");
				vo.setDeleteFlag("Y");
				count = count + jxcsjzxxDAO.doDeleteByVO(vo);
			}
		}
		return count;
	}

	public JxcsjzxxVO doInsertBuildingByVO(JxcsjzxxVO vo){
		jxcsjzxxDAO.doInsertByVO(vo);
		return vo;
	}
}