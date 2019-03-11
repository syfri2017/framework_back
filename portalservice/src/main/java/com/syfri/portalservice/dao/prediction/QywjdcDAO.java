package com.syfri.portalservice.dao.prediction;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.portalservice.model.prediction.QywjdcVO;

public interface QywjdcDAO extends BaseDAO<QywjdcVO>{
    int doDeleteByVO(QywjdcVO vo);//按企业id删除
}