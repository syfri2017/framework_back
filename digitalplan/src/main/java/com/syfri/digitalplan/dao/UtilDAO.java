package com.syfri.digitalplan.dao;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.UtilXfdzVO;

import java.util.List;

public interface UtilDAO extends BaseDAO<UtilXfdzVO>{

    /*--查询到消防总队--*/
    List<UtilXfdzVO> doSearchContingents();

    /*--根据总队ID获取其下属队站 by li.xue 2018/8/29.--*/
    List<UtilXfdzVO> doFindXfdzByZongdId(String dzid);
}