package com.syfri.userservice.service.venue;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.venue.ZwflxxVO;

import java.util.List;

public interface ZwflxxService  extends BaseService<ZwflxxVO>{
    int doDeleteZwflxx(List<ZwflxxVO> voList);
}