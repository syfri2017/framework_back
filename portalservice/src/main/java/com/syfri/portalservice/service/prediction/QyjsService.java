package com.syfri.portalservice.service.prediction;

import com.syfri.baseapi.service.BaseService;
import com.syfri.portalservice.model.prediction.QyjsVO;

public interface QyjsService  extends BaseService<QyjsVO>{
    //新增企业介绍和产品介绍
    QyjsVO doInsertQyAndCpByVO(QyjsVO vo);
    //更新企业介绍和产品介绍
    QyjsVO doUpdateQyCpByVO(QyjsVO vo);
}