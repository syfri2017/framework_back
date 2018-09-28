package com.syfri.userservice.filter;

import com.syfri.userservice.config.InfoCollectToken;
import com.syfri.userservice.config.LoginType;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 验证码过滤器
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

	//登陆验证
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws  Exception{
		//登陆类型
		String loginType = request.getParameter("loginType");
		if(LoginType.MYSHIRO.toString().equals(loginType)){
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpSession session = httpServletRequest.getSession();
			//取出Session中验证码
			String code = (String) session.getAttribute("code");
			//取出输入的验证码
			String validateCode = httpServletRequest.getParameter("validateCode");
			if(code!=null && validateCode!=null && !validateCode.equals(code)){
				httpServletRequest.setAttribute("shiroLoginFailure","kaptchaValidateFailed");
				return true;
			}
			//return super.onAccessDenied(request, response);
		}
		return super.onAccessDenied(request, response);
	}

	//创建Token
	@Override
	protected InfoCollectToken createToken(ServletRequest request, ServletResponse response){
		String username = getUsername(request);
		String password = getPassword(request);
		String loginType = request.getParameter("loginType");
		String unscid = request.getParameter("unscid");
		if(LoginType.MYSHIRO.toString().equals(loginType)){
			return new InfoCollectToken(username, password, LoginType.MYSHIRO.toString());
		} else {
			return new InfoCollectToken(unscid, LoginType.INFOCOLLECT.toString());
		}
	}

	//成功登陆
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
		//登陆方式
		String loginType = ((InfoCollectToken) token).getLoginType();
		//loginType = "MyShiro";
		if(LoginType.INFOCOLLECT.toString().equals(loginType)){
			//HttpServletRequest req = (HttpServletRequest) request;
			//req.getSession().setAttribute("loginType", "infoCollect");
			WebUtils.getAndClearSavedRequest(request);
			String infoCollectUrl = "/jxcsplan/jxcsplanAll";
			WebUtils.redirectToSavedRequest(request, response, infoCollectUrl);
		}else{
			issueSuccessRedirect(request, response);
		}
		return false;
	}
}
