package com.syfri.userservice.config;

import org.apache.shiro.authc.UsernamePasswordToken;

public class InfoCollectToken extends UsernamePasswordToken {

    //登陆类型
    private String loginType;

    //统一社会信用代码
    private String unscid;

    //展商来源
    private String comfrom;

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

    public InfoCollectToken(final String username, final String password, final String loginType, final String comfrom){
        super(username,password);
        this.loginType = loginType;
        this.comfrom = comfrom;
    }


    /**统计社会信用代码方式获取用户名  by li.xue 2018/10/17 10:55
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
    */
    @Override
    public Object getPrincipal() {
        return getUsername();
    }

    @Override
    public Object getCredentials() {
        return getPassword();
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

    public String getComfrom() {
        return comfrom;
    }

    public void setComfrom(String comfrom) {
        this.comfrom = comfrom;
    }
}
