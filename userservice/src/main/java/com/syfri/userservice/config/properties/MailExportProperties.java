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
@ConfigurationProperties(prefix = MailExportProperties.MAIL_PREFIX)
public class MailExportProperties {
    public static final String MAIL_PREFIX = "mailExp";
    private String from;
    private String subject;
	private String time;
	private String systemName;
	private String teamName;
	private String text ;
	private String picName;


	public String getText() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
		StringBuffer sb=new StringBuffer("<html><body>")
				.append("<h3>亲爱的展商用户：</h3>")
				.append("<br>")
				.append("您好！<h2>您已选择{1}<br><br>")
				.append("附件为{2}展馆的展位图</h2>，敬请查收。")
				.append("<br><br>")
				.append("第十八届中国国际消防展将于2019年10月16-19日在北京顺义区新国展举行，欢迎您的莅临。<br><br>")
				.append(teamName)
				.append("<br>")
				.append(sdf.format(new Date()))
				.append("</body>")
				.append("</html>");
		text=sb.toString();
		return text;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
