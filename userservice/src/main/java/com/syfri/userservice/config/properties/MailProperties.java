package com.syfri.userservice.config.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * pmsg相关配置
 *
 * @author fengshuonan
 * @date 2018-01-9 9:23
 */
@Configuration
@ConfigurationProperties(prefix = MailProperties.MAIL_PREFIX)
public class MailProperties {
    public static final String MAIL_PREFIX = "mail";
    private String from = "1106612528@qq.com";
    private String subject = "展会邮箱验证码";
	private String time = "1小时" ;
	private String systemName = "展会系统";
	private String text ;

	public String getText() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
		StringBuffer sb=new StringBuffer("<html><body>")
				.append("<h3>亲爱的用户：</h3>")
				.append("<br><br>")
				.append("您好！感谢您使用")
				.append(systemName)
				.append("，您正在进行邮箱验证，本次请求的验证码为：<br>")
				.append("<span style=\"font-size:18px;color:#f90\">%s</span>")
				.append("<span style=\"margin:0;padding:0;margin-left:10px;line-height:30px;")
				.append("font-size:14px;color:#979797;font-family:'宋体',arial,sans-serif\">")
				.append("(为了保障您帐号的安全性，请在")
				.append(time)
				.append("内完成验证。)</span><br><br>")
				.append(systemName)
				.append("团队<br>")
				.append(sdf.format(new Date()))
				.append("</body>")
				.append("</html>");
		text=sb.toString();
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
