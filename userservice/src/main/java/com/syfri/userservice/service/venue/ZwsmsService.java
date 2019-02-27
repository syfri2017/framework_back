package com.syfri.userservice.service.venue;

import com.github.qcloudsms.SmsSingleSenderResult;
import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.model.venue.ZwsmsVO;

public interface ZwsmsService extends BaseService<ZwsmsVO> {
    void createZwsmslog(ZwjbxxVO vo, QyjbxxVO qvo, SmsSingleSenderResult result);

    int doDeleteByFssj(ZwsmsVO vo);
}