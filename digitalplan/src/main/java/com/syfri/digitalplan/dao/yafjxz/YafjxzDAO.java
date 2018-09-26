package com.syfri.digitalplan.dao.yafjxz;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.yafjxz.YafjxzVO;

import java.util.List;

public interface YafjxzDAO extends BaseDAO<YafjxzVO>{
    public void doDeletcNotIn(String oldYafjxzVOs);
    List<YafjxzVO> doFindByPlanId(YafjxzVO yafjxzVO);
    List<YafjxzVO> doFindPicsByPlanId(YafjxzVO yafjxzVO);
}