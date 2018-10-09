package com.syfri.userservice.utils;

/**
 * @Description:
 * @Author: lixiaoyang
 * @Modified By:
 * @Date: 2018/10/9 10:00
 */
public class MathUtil {
    public static String getCode(int w){
        //6位随机数验证码
        StringBuffer randomStr=new StringBuffer();
        for(int i=1;i<=w;i++){
            randomStr.append((int)(Math.random()*9+1));
        }
        return randomStr.toString();
    }
}
