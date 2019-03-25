package com.syfri.portalservice.service.impl.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.portalservice.dao.news.NewsDAO;
import com.syfri.portalservice.model.news.NewsVO;
import com.syfri.portalservice.service.news.NewsService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("newsService")
public class NewsServiceImpl extends BaseServiceImpl<NewsVO> implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	@Override
	public NewsDAO getBaseDAO() {
		return newsDAO;
	}
}