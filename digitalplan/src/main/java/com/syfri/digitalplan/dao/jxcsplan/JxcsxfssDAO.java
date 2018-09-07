package com.syfri.digitalplan.dao.jxcsplan;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.jxcsplan.JxcsxfssVO;

import java.util.List;

public interface JxcsxfssDAO extends BaseDAO<JxcsxfssVO>{

    /*--根据单位id获取消防设施集合.--*/
    List<JxcsxfssVO> doFindXfssByDwid(String dwid);
}