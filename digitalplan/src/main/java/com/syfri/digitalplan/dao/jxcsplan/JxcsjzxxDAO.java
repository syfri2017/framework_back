package com.syfri.digitalplan.dao.jxcsplan;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.jxcsplan.JxcsjzxxVO;

import java.util.List;

public interface JxcsjzxxDAO extends BaseDAO<JxcsjzxxVO> {

    /*--根据单位id获取建筑详情集合.--*/
    List<JxcsjzxxVO> doFindJzxxByDwid(String dwid);

}