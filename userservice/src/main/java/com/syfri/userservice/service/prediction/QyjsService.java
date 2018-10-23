package com.syfri.userservice.service.prediction;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.prediction.QyjsVO;

public interface QyjsService  extends BaseService<QyjsVO>{
    //新增企业介绍和产品介绍
    QyjsVO doInsertQyAndCpByVO(QyjsVO vo);
    //更新企业介绍和产品介绍
    QyjsVO doUpdateQyCpByVO(QyjsVO vo);
}