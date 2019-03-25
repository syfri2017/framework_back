package com.syfri.portalservice.controller.news;

import com.syfri.portalservice.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.portalservice.model.news.NewsfjVO;
import com.syfri.portalservice.service.news.NewsfjService;

@RestController
@RequestMapping("newsfj")
public class NewsfjController  extends BaseController<NewsfjVO> {

	@Autowired
	private NewsfjService newsfjService;

	@Override
	public NewsfjService getBaseService() {
		return this.newsfjService;
	}

}
