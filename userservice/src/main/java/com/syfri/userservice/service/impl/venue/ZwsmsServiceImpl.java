package com.syfri.userservice.service.impl.venue;

import com.github.qcloudsms.SmsSingleSenderResult;
import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.venue.ZwsmsDAO;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.model.venue.ZwsmsVO;
import com.syfri.userservice.service.venue.ZwsmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("zwsmsService")
public class ZwsmsServiceImpl extends BaseServiceImpl<ZwsmsVO> implements ZwsmsService {

	@Autowired
	private ZwsmsDAO zwsmsDAO;

	public ZwsmsDAO getBaseDAO() {
		return zwsmsDAO;
	}

	public void createZwsmslog(ZwjbxxVO vo, QyjbxxVO qvo, SmsSingleSenderResult result) {
		ZwsmsVO zs=new ZwsmsVO();
		zs.setZwh(vo.getZwh());
		zs.setZwuuid(vo.getUuid());
		zs.setSjhm(qvo.getLxrsj());
		zs.setErrmsg(result.errMsg);
		zs.setSid(result.sid);
		zs.setFee(result.fee+"");
		zs.setExt(result.ext);
		zs.setResult(result.result+"");
		zs.setFssj(new Date());
		zwsmsDAO.doInsertByVO(zs);
	}

	public int doDeleteByFssj(ZwsmsVO vo){
		return zwsmsDAO.doDeleteByFssj(vo);
	}
}