package com.syfri.userservice.service.venue;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.venue.ZgjbxxVO;

import java.util.List;

public interface ZgjbxxService  extends BaseService<ZgjbxxVO>{
    public List<ZgjbxxVO> doSearchHbListByVO(ZgjbxxVO vo);
    public List<ZgjbxxVO> doSearchHbTpListByVO(ZgjbxxVO vo);
    public List<ZgjbxxVO> doSearchDataListByVO(ZgjbxxVO vo);
    public List<ZgjbxxVO> doSearchZgmc();
}