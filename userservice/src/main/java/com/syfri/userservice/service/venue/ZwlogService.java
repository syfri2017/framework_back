package com.syfri.userservice.service.venue;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.system.ShiroUser;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.model.venue.ZwlogVO;

public interface ZwlogService  extends BaseService<ZwlogVO>{

    public void createZwlog(ZwjbxxVO o, ZwjbxxVO n, String czlx, String ffmc);

    int doDeleteByRzsj(ZwlogVO vo);
}