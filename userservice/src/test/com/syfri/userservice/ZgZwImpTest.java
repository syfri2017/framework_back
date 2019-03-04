package com.syfri.userservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.syfri.userservice.model.venue.ZwmkVO;
import com.syfri.userservice.service.venue.ZwmkService;
import com.syfri.userservice.utils.FileUtil;
import org.junit.Test;
import javax.annotation.Resource;
import com.syfri.userservice.base.BaseJunit;
import java.util.List;


public class ZgZwImpTest extends BaseJunit {
    private final static String BASE="C:/Users/THINK/Desktop/";
    @Resource
    ZwmkService zwmkService;
    @Test
    public void impMk(){
        System.out.println("--------impMk  start--------");
        //导入文件
        String filePath = BASE+"e1-shapes.json";
        String jsonContent = FileUtil.ReadFile(filePath);
        List<JSONObject> list = JSON.parseArray(jsonContent,JSONObject.class);
        for(JSONObject jo:list){
            ZwmkVO mk=new ZwmkVO();
            //展馆UUID
            mk.setStageUuid("7D6E508202416243E050007F010078E8");

            mk.setCjrid("F2B35A68CDEB401A91A593068FDFC3FE");
            mk.setCjrmc("admin");
            mk.setShapeUuid(jo.getJSONObject("attrs").getString("shapeUuid"));
            mk.setJsonData(jo.toString());
            System.out.println("--------shapeUuid:-----"+mk.getShapeUuid());
            System.out.println(mk.getJsonData());
            zwmkService.doInsertByVO(mk);
        }
        System.out.println("--------impMk  end--------");
    }
}