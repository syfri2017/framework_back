package com.syfri.userservice.controller.system;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.userservice.model.system.*;
import com.syfri.userservice.utils.CurrentUserUtil;
import com.syfri.userservice.utils.ImageCodeUtil;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Api(value = "登录",tags = "登录API",description = "登录")
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	protected Environment environment;

//	@ModelAttribute
//	public void Model(Model model){
//		if (environment.containsProperty("server.context-path")) {
//			model.addAttribute("contextPath", environment.getProperty("server.context-path"));
//		}else{
//			model.addAttribute("contextPath", "/");
//		}
//	}

	@RequestMapping("/home")
	public String bigscreen(Model model, @RequestParam(value="index", required = false) String index){
		if(index == null || "".equals(index)){
			index = "1";
		}
		model.addAttribute("index", index);
		return "/index";
	}

	@GetMapping("/index")
	public String index(){
		return "bigscreen/big_screen_all";
	}

	@GetMapping({"/","/login"})
	public String login(){
		logger.info("-----GET请求方式登录-----");
		if(SecurityUtils.getSubject().isAuthenticated()){
			return "redirect:/index";
		}
		return "/login";
	}

	/**
	@PostMapping("/login2")
	public @ResponseBody String login(HttpServletRequest request, @RequestBody AccountVO vo){
		logger.info("-----POST请求方式登录-----");
		Subject currentUser = SecurityUtils.getSubject();
		//测试当前用户是否被验证
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(vo.getUsername(), vo.getPassword());
			String code = (String)request.getSession().getAttribute("code");
			if(code != null && code.equals(vo.getValidateCode())){
				try{
					currentUser.login(token);
				}catch(AuthenticationException e){
					System.out.println("登录失败--->" + e.getMessage());
					return "falseDLZH";
				}
			}else{
				return "falseYZM";
			}
		}
		return "success";
	}
	*/


	/**
	 * 此方法不处理登录成功的情况，由shiro进行处理
	 */
	@PostMapping("/login")
	public String login(HttpServletRequest request, String comfrom, Map<String,Object> map) throws Exception{
		logger.info("-----POST请求方式登录-----");
		ShiroUser user = CurrentUserUtil.getCurrentUser();
		if(user != null){
			return "/index";
		}else{
			String exception = (String) request.getAttribute("shiroLoginFailure");
			logger.info("【loginController】" + exception);
			String msg = "";
			if(exception != null){
				if(UnknownAccountException.class.getName().equals(exception)){
					msg = "UnknownAccountException --> 账号不存在";
				}else if(IncorrectCredentialsException.class.getName().equals(exception)){
					msg = "IncorrectCredentialsException --> 密码不正确";
				}else if(ExcessiveAttemptsException.class.getName().equals(exception)){
					msg = "ExcessiveAttemptsException --> 密码输入错误次数超过5次";
				}else if("kaptchaValidateFailed".equals(exception)){
					msg = "kaptchaValidateFailed --> 验证码错误";
				}else{
					msg = "else --> " + exception;
				}
			}
			map.put("msg",msg);
			//以下是登录错误时返回login.html页面
			//后台工程  by li.xue 2018/07/03
			//return "/login";
			//前台工程  by li.xue 2018/07/03
			if("ENG".equals(comfrom)){
				return "redirect:templates/login_ENG.html";
			}else {
				return "redirect:templates/login.html";
			}
		}
	}

	@GetMapping("/403")
	public String unauthorizedRole(){
		logger.info("-----没有权限-----");
		return "/403";
	}

	/**
	 * 验证码
	 */
	@GetMapping("/imageCode")
	public void reloadCode(HttpServletRequest request, HttpServletResponse response) throws IOException{

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		OutputStream os = response.getOutputStream();
		Map<String,Object> map = ImageCodeUtil.getImageCode(60,20,os);
		HttpSession session = request.getSession();
		session.setAttribute("code", map.get("strEnsure").toString().toLowerCase());
		session.setAttribute("codeTime", new Date().getTime());
		try{
			ImageIO.write((BufferedImage) map.get("image"), "JPEG", os);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * logout
	 */
	@GetMapping("/logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login";
	}

	@RequestMapping("/shiro")
	@ResponseBody
	public ShiroUser getShiroUser(){
		Subject subject = SecurityUtils.getSubject();
		return (ShiroUser)subject.getPrincipal();
	}

	@GetMapping("/getMenu")
	public @ResponseBody ResultVO getMenu(){
		List<ResourceTree> menus = CurrentUserUtil.getCurrentUser().getResourceTrees();
		ResultVO resultVO = ResultVO.build();
		resultVO.setResult(menus);
		return resultVO;
	}

	@GetMapping("/ENG/logout")
	public String ENGlogout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/loginENG";
	}
}
