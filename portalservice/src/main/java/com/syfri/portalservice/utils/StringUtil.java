package com.syfri.portalservice.utils;

import com.syfri.baseapi.model.ResultVO;
import net.sf.json.JSONObject;

/**
 * @Description:
 * @Author: lixiaoyang
 * @Modified By:
 * @Date: 2019/3/11 15:24
 */
public class StringUtil {
    public static String callbackString(String callback,ResultVO resultVO){
        StringBuffer sb=new StringBuffer(callback)
                .append("(")
                .append(JSONObject.fromObject(resultVO).toString())
                .append(")");
        return sb.toString();
    }
}
