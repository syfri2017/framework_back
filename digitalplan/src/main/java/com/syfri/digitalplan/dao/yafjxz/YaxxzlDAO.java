package com.syfri.digitalplan.dao.yafjxz;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.yafjxz.YaxxzlVO;

import java.util.List;

public interface YaxxzlDAO extends BaseDAO<YaxxzlVO>{
    List<YaxxzlVO> doFindHisByPlanId(String yaid);
}