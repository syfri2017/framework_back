package com.syfri.digitalplan.service.yafjxz;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.yafjxz.YaxxzlVO;

import java.util.List;

public interface YaxxzlService  extends BaseService<YaxxzlVO>{
    List<YaxxzlVO> doFindHisByPlanId(String yaid);
}