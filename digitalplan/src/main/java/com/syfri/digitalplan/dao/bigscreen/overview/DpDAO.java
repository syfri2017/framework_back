package com.syfri.digitalplan.dao.bigscreen.overview;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.bigscreen.overview.DpVO;

import java.util.List;

public interface DpDAO extends BaseDAO<DpVO>{

    public List<DpVO> getListByType(DpVO vo);
}