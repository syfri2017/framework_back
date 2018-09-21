package com.syfri.userservice.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;

public class InfoModularRealmAuthenticator extends ModularRealmAuthenticator {

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        //判断getRealms()是否返回为空
        assertRealmsConfigured();
        //强制转换为自定义的InfoCollectToken
        InfoCollectToken infoCollectToken = (InfoCollectToken) authenticationToken;
        //登陆类型
        String loginType = infoCollectToken.getLoginType();
        //所有Realm
        Collection<Realm> realms = getRealms();
        Collection<Realm> typeRealms = new ArrayList<>();
        for(Realm realm : realms){
            if(realm.getName().contains(loginType)){
                typeRealms.add(realm);
            }
        }

        //判断是单Realm还是多Realm
        if(typeRealms.size() == 1){
            return doSingleRealmAuthentication(typeRealms.iterator().next(), infoCollectToken);
        }else{
            return doMultiRealmAuthentication(typeRealms, infoCollectToken);
        }
    }
}