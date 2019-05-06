package com.syfri.portalservice.controller.news;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.portalservice.config.properties.CpjsProperties;
import com.syfri.portalservice.controller.base.BaseController;
import com.syfri.portalservice.model.prediction.QyjbjsVO;
import com.syfri.portalservice.utils.DownloadUtil;
import com.syfri.portalservice.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syfri.portalservice.model.news.NewsfjVO;
import com.syfri.portalservice.service.news.NewsfjService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
@RequestMapping("newsfj")
public class NewsfjController  extends BaseController<NewsfjVO> {

	@Autowired
	private NewsfjService newsfjService;
	@Autowired
	private CpjsProperties cpjsProperties;

	@Override
	public NewsfjService getBaseService() {
		return this.newsfjService;
	}

	@GetMapping(value="downloadFj",produces="text/html;charset=UTF-8")
	public @ResponseBody
	void downloadFj( HttpServletRequest request, HttpServletResponse response,NewsfjVO vo, String callback) {
		ResultVO resultVO = ResultVO.build();
		NewsfjVO db=newsfjService.doFindById(vo.getUuid());
		String path=cpjsProperties.getSavePath()+db.getSrc();
		//String fileName=file.getName();
		String fileName=db.getFjmc();
		DownloadUtil.download(request,response,path,fileName);
	}
}
