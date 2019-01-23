package com.syfri.userservice.dao.venue;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.venue.ZwlogVO;

public interface ZwlogDAO extends BaseDAO<ZwlogVO>{
    int doDeleteByRzsj(ZwlogVO vo);
}