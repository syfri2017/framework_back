package com.syfri.digitalplan.service.jxcsplan;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.jxcsplan.JxcsxfssVO;

import java.util.List;

public interface JxcsxfssService  extends BaseService<JxcsxfssVO>{

    /*--根据单位ID查询其消防设施 by liurui 2018/9/7--*/
    List<JxcsxfssVO> doFindXfssByDwid(String dwid);
}