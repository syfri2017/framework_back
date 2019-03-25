package com.syfri.portalservice.controller.news;

import com.syfri.portalservice.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.portalservice.model.news.NewsVO;
import com.syfri.portalservice.service.news.NewsService;


@RestController
@RequestMapping("news")
public class NewsController  extends BaseController<NewsVO> {

	@Autowired
	private NewsService newsService;

	@Override
	public NewsService getBaseService() {
		return this.newsService;
	}

}
