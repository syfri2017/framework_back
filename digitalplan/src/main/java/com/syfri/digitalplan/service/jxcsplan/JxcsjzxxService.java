package com.syfri.digitalplan.service.jxcsplan;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.jxcsplan.JxcsjzxxVO;

import java.util.List;

public interface JxcsjzxxService  extends BaseService<JxcsjzxxVO>{

    /*--根据单位ID查询其建筑信息 by liurui 2018/9/7--*/
    List<JxcsjzxxVO> doFindJzxxByDwid(String dwid);

    int doDeleteByList(List<JxcsjzxxVO> jxcsjzxxList);

    //新增建筑信息 返回建筑vo add by yushch 20180925
    JxcsjzxxVO doInsertBuildingByVO(JxcsjzxxVO vo);
}