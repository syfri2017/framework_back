package com.syfri.userservice.service.impl.venue;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.venue.ZwjbxxDAO;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.service.venue.ZwjbxxService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("zwjbxxService")
public class ZwjbxxServiceImpl extends BaseServiceImpl<ZwjbxxVO> implements ZwjbxxService {

	@Autowired
	private ZwjbxxDAO zwjbxxDAO;

	@Override
	public ZwjbxxDAO getBaseDAO() {
		return zwjbxxDAO;
	}
	@Override
	public PageInfo<ZwjbxxVO> doSearchQyPage(ZwjbxxVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<ZwjbxxVO> list = zwjbxxDAO.doSearchListQyByVO(vo);
		PageInfo<ZwjbxxVO> page = new PageInfo<ZwjbxxVO>(list);
		return page;
	}
}