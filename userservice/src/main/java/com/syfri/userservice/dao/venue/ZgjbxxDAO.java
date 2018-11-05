package com.syfri.userservice.dao.venue;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.venue.ZgjbxxVO;

import java.util.List;

public interface ZgjbxxDAO extends BaseDAO<ZgjbxxVO>{
    public List<ZgjbxxVO> doSearchHbListByVO(ZgjbxxVO vo);
    public List<ZgjbxxVO> doSearchDataListByVO(ZgjbxxVO vo);
}