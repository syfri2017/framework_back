package com.syfri.userservice.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取路径Controller
 * by li.xue 2018-03-22
 */

@RestController
public class PathController {

	@Autowired
	protected Environment environment;

	@RequestMapping("getPath")
	public String getPath(){
		if (environment.containsProperty("server.context-path")) {
			return environment.getProperty("server.context-path");
		}else{
			return "";
		}
	}
}
