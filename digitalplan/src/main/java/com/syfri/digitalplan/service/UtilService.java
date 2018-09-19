package com.syfri.digitalplan.service;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.UtilXfdzVO;

import java.util.List;

public interface UtilService  extends BaseService<UtilXfdzVO>{

    /*--查询到消防总队--*/
    List<UtilXfdzVO> doSearchContingents();

    /*--根据总队ID获取其下属队站 by li.xue 2018/8/29.--*/
    List<UtilXfdzVO> doFindXfdzByZongdId(String dzid);
}