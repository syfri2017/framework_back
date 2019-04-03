package com.syfri.portalservice.controller.news;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.portalservice.config.properties.CpjsProperties;
import com.syfri.portalservice.controller.base.BaseController;
import com.syfri.portalservice.model.prediction.QyjbjsVO;
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
		BufferedInputStream bis=null;
		OutputStream os=null;
		try {
			NewsfjVO db=newsfjService.doFindById(vo.getUuid());
			String path=cpjsProperties.getSavePath()+db.getSrc();
			File file=new File(path);
			//String fileName=file.getName();
			String fileName=db.getFjmc();
			String ext=fileName.substring(fileName.lastIndexOf(".")+1);
			String agent=(String)request.getHeader("USER-AGENT"); //判断浏览器类型
			if(agent!=null && agent.indexOf("Fireforx")!=-1) {
				fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");   //UTF-8编码，防止输出文件名乱码
			}
			else {
				fileName= URLEncoder.encode(fileName,"UTF-8");
			}
			response.reset();
			response.setCharacterEncoding("utf-8");
			if(ext=="docx") {
				response.setContentType("application/msword"); // word格式
			}else if(ext=="pdf") {
				response.setContentType("application/pdf"); // word格式
			}
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			bis=new BufferedInputStream(new FileInputStream(file));
			byte[] b=new byte[bis.available()+1000];
			int i=0;
			os = response.getOutputStream();   //直接下载导出
			while((i=bis.read(b))!=-1) {
				os.write(b, 0, i);
			}
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("{}",e.getMessage());
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
