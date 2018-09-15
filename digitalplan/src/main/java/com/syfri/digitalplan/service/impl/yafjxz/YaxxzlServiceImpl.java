package com.syfri.digitalplan.service.impl.yafjxz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.yafjxz.YaxxzlDAO;
import com.syfri.digitalplan.model.yafjxz.YaxxzlVO;
import com.syfri.digitalplan.service.yafjxz.YaxxzlService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("yaxxzlService")
public class YaxxzlServiceImpl extends BaseServiceImpl<YaxxzlVO> implements YaxxzlService {

	@Autowired
	private YaxxzlDAO yaxxzlDAO;

	@Override
	public YaxxzlDAO getBaseDAO() {
		return yaxxzlDAO;
	}

	@Override
	public List<YaxxzlVO> doFindHisByPlanId(String yaid){
		List<YaxxzlVO> resultList= yaxxzlDAO.doFindHisByPlanId(yaid);
		return resultList;
	}
}