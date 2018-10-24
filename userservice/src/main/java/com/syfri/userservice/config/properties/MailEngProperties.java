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
@ConfigurationProperties(prefix = MailEngProperties.MAIL_PREFIX)
public class MailEngProperties {
    public static final String MAIL_PREFIX = "mailEng";
    private String from;
    private String subject;
	private String time;
	private String systemName;
	private String teamName;
	private String text ;

	public String getText() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb=new StringBuffer("<html><body>")
				.append("<h3>Dear Exhibitors:</h3>")
				.append("<br><br>")
				.append("Welcome to ")
				.append(systemName)
				.append("!Now you are verifying this email address as your username for China Fire 2019 ExhibitorSystem")
				.append(",and here is your verification code:<br>")
				.append("<span style=\"font-size:18px;color:#f90\">%s</span>")
				.append("<span style=\"margin:0;padding:0;margin-left:10px;line-height:30px;")
				.append("font-size:14px;color:#979797;font-family:'宋体',arial,sans-serif\">")
				.append("(Please enter this code on your registration page in")
				.append(time)
				.append("after you receive this email.)</span><br><br>")
				.append("China Fire 2019 will be held on October16-19, 2019 at China International Exhibition Center (New Hall)")
				.append(", located at Shunyi District, Beijing, P. R. China. We are looking forward to your visit.</span><br><br>")
				.append(teamName)
				.append("<br>")
				.append(sdf.format(new Date()))
				.append("<br><br>")
				.append("No Replies to this Automatic Email!")
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
