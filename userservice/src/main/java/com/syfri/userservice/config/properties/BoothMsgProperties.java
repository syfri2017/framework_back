package com.syfri.userservice.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * pmsg相关配置
 *
 * @author fengshuonan
 * @date 2018-01-9 9:23
 */
@Configuration
@ConfigurationProperties(prefix = BoothMsgProperties.BMSG_PREFIX)
public class BoothMsgProperties {
    public static final String BMSG_PREFIX = "bmsg";
    private String validatePath;
    private String sendPath;
    private Integer appId;
    private String appKey;
    private Integer signId;
    private Integer templId;
    
    
	public String getValidatePath() {
		return validatePath;
	}
	public void setValidatePath(String validatePath) {
		this.validatePath = validatePath;
	}
	public String getSendPath() {
		return sendPath;
	}
	public void setSendPath(String sendPath) {
		this.sendPath = sendPath;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public Integer getSignId() {
		return signId;
	}
	public void setSignId(Integer signId) {
		this.signId = signId;
	}
	public Integer getTemplId() {
		return templId;
	}
	public void setTemplId(Integer templId) {
		this.templId = templId;
	}
	public static String getBmsgPrefix() {
		return BMSG_PREFIX;
	}
	
}	
