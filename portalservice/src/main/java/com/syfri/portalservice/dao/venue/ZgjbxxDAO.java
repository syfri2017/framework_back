package com.syfri.portalservice.dao.venue;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.portalservice.model.venue.ZgjbxxVO;

import java.util.List;

public interface ZgjbxxDAO extends BaseDAO<ZgjbxxVO>{
    public List<ZgjbxxVO> doSearchHbListByVO(ZgjbxxVO vo);
    public List<ZgjbxxVO> doSearchDataListByVO(ZgjbxxVO vo);
    public List<ZgjbxxVO> doSearchHbTpListByVO(ZgjbxxVO vo);
    public List<ZgjbxxVO> doSearchZgmc();
}