package com.syfri.userservice.config;

import org.apache.shiro.authc.UsernamePasswordToken;

public class InfoCollectToken extends UsernamePasswordToken {

    //登陆类型
    private String loginType;

    //统一社会信用代码
    private String unscid;

    public InfoCollectToken() {
    }

    public InfoCollectToken(final String unscid, final String loginType){
        super("","");
        this.unscid = unscid;
        this.loginType = loginType;
    }

    public InfoCollectToken(final String username, final String password, final String loginType){
        super(username,password);
        this.loginType = loginType;
    }

    @Override
    public Object getPrincipal() {
        if(unscid == null){
            return getUsername();
        }else{
            return getUnscid();
        }
    }

    @Override
    public Object getCredentials() {
        if(unscid == null){
            return getPassword();
        }else{
            return "";
        }
    }


    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getUnscid() {
        return unscid;
    }

    public void setUnscid(String unscid) {
        this.unscid = unscid;
    }
}
