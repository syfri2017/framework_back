package com.syfri.digitalplan.service.bigscreen.overview;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.bigscreen.overview.DpVO;

import java.util.List;

public interface DpService  extends BaseService<DpVO>{

    public List<DpVO> getListByType(DpVO vo);
}