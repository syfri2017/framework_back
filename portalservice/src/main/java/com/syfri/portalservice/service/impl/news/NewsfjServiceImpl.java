package com.syfri.portalservice.service.impl.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.portalservice.dao.news.NewsfjDAO;
import com.syfri.portalservice.model.news.NewsfjVO;
import com.syfri.portalservice.service.news.NewsfjService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("newsfjService")
public class NewsfjServiceImpl extends BaseServiceImpl<NewsfjVO> implements NewsfjService {

	@Autowired
	private NewsfjDAO newsfjDAO;

	@Override
	public NewsfjDAO getBaseDAO() {
		return newsfjDAO;
	}
}