package com.syfri.userservice.service.impl.venue;

import com.syfri.userservice.model.system.CurrentUser;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.venue.ZwlogDAO;
import com.syfri.userservice.model.venue.ZwlogVO;
import com.syfri.userservice.service.venue.ZwlogService;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("zwlogService")
public class ZwlogServiceImpl extends BaseServiceImpl<ZwlogVO> implements ZwlogService {

	public static final String INSERT = "INSERT";
	public static final String UPDATE = "UPDATE";

	@Autowired
	private ZwlogDAO zwlogDAO;

	@Override
	public ZwlogDAO getBaseDAO() {
		return zwlogDAO;
	}
	@Override
	public void createZwlog(ZwjbxxVO o, ZwjbxxVO n, String czlx, String ffmc) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ZwlogVO vo=new ZwlogVO();
			vo.setCzlx(czlx);
			vo.setFfmc(ffmc);
			if(o!=null){
				vo.setYqyid(o.getQyid());
			}
			if(n!=null){
				if(czlx.equals(ZwlogServiceImpl.INSERT)){
					vo.setCzrid(n.getCjrid());
					vo.setCzrmc(n.getCjrmc());
					if(n.getCjsj()!=null){
						vo.setCzsj(sdf.parse(n.getCjsj()));
					}else{
						vo.setCzsj(new Date());
					}
				}
				if(czlx.equals(ZwlogServiceImpl.UPDATE)){
					vo.setCzrid(n.getXgrid());
					vo.setCzrmc(n.getXgrmc());
					if(n.getXgsj()!=null){
						vo.setCzsj(sdf.parse(n.getXgsj()));
					}
				}

				vo.setQyid(n.getQyid());
				vo.setZwuuid(n.getUuid());
				vo.setZwh(n.getZwh());
			}
			zwlogDAO.doInsertByVO(vo);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public int doDeleteByRzsj(ZwlogVO vo){
		return zwlogDAO.doDeleteByRzsj(vo);
	}
}