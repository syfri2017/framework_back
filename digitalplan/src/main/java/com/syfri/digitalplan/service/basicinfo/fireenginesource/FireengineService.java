package com.syfri.digitalplan.service.basicinfo.fireenginesource;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.auxiliarydecision.danger.DangerVO;
import com.syfri.digitalplan.model.basicinfo.fireenginesource.FireengineVO;

import java.util.List;

public interface FireengineService  extends BaseService<FireengineVO>{
    /***
     * @Description: 删除：车辆信息
     * @Param: [fireengineVO]
     * @Return: java.util.List<com.syfri.digitalplan.model.basicinfo.fireenginesource.FireengineVO>
     * @Author: zhaijianchen
     * @Modified By:
     * @Date: 2018/7/24 09:42
     */
     int doDeleteFireengine(List<FireengineVO> fireengineList);
    /**
     * @Description: 修改：车辆信息
     * @Param: [fireengineVO]
     * @Return: int
     * @Author: zhaijianchen
     * @Modified By:
     * @Date: 2018/7/25 10:48
     */
     int doUpdateFireengine(FireengineVO fireengineVO);
}