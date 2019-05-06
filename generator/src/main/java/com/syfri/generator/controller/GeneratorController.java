package com.syfri.generator.controller;

import com.alibaba.fastjson.JSON;
import com.syfri.generator.model.GeneratorBean;
import com.syfri.generator.service.GeneratorService;
import com.syfri.generator.utils.StringUtils;
import com.syfri.generator.utils.ZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
public class GeneratorController {

	@Autowired
	public GeneratorService generatorService;

	@Value("${framework.projectName}")
	private String projectName;

	@Value("${framework.modelName}")
	private String modelName;

	@Value("${framework.genPath}")
	private String genPath;

	@Value("${framework.prefix}")
	private String prefix;

	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@RequestMapping("/doGetTables")
	public @ResponseBody Map<String,Object> doGetTables(GeneratorBean gb){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("projectName", projectName);
		map.put("modelName", modelName);
		map.put("prefix", prefix);
		try {
			map.put("list", generatorService.getTables(gb));
		} catch (Exception e) {
			map.put("error",e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/doGetColumns", produces = "application/json;charset=utf-8")
	public @ResponseBody String doGetColumns(GeneratorBean gb){
		try {
			return JSON.toJSONString(generatorService.getTableColumn(gb));
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	@RequestMapping("/doGenerate")
	public @ResponseBody String doGenerator(HttpServletRequest request, HttpServletResponse response, GeneratorBean bean){
		String now =StringUtils.getNow();
		bean.setGenPath(genPath+"/"+ now);
		generatorService.generate(bean);
		ZipUtil.zip(bean.getGenPath());
		return now;
	}

	@RequestMapping("/doDownload")
	public @ResponseBody void doDownload(HttpServletRequest request, HttpServletResponse response,String time){
		ZipUtil.download(request,response,genPath+"/"+time+".zip","生成代码.zip");
	}
}
