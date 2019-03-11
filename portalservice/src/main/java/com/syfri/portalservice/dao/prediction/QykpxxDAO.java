package com.syfri.portalservice.dao.prediction;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.portalservice.model.prediction.QykpxxVO;

public interface QykpxxDAO extends BaseDAO<QykpxxVO>{

    int doDeleteByVO(QykpxxVO vo);//按企业id删除
}