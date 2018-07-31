package com.syfri.digitalplan.service.firefacilities;

import com.syfri.baseapi.model.ValueObject;
import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.firefacilities.*;

import java.util.List;
import java.util.Map;

public interface FirefacilitiesService  extends BaseService<FirefacilitiesVO>{
    public Map<String, List> doFindlist(FirefacilitiesVO vo);
    public ValueObject doFindXfssDetail(FirefacilitiesVO vo);

}