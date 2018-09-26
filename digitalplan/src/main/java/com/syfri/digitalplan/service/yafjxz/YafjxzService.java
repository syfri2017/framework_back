package com.syfri.digitalplan.service.yafjxz;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.yafjxz.YafjxzVO;

import java.util.List;

public interface YafjxzService  extends BaseService<YafjxzVO>{
    public void doDeletcNotIn(String oldYafjxzVOs);
    List<YafjxzVO> doFindByPlanId(YafjxzVO yafjxzVO);
    public int  doUpdateByVOList(List<YafjxzVO> yafjxzVOList);
}