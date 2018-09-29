package com.syfri.digitalplan.dao.jxcsplan;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.jxcsplan.JxcsdlyzVO;

public interface JxcsdlyzDAO extends BaseDAO<JxcsdlyzVO>{
    //根据单位id逻辑删除中间表中信息
    int doDeleteByDwid(String dwid);

}