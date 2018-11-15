package com.syfri.userservice.service.impl.system;

import com.syfri.userservice.utils.CurrentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.system.MailDAO;
import com.syfri.userservice.model.system.MailVO;
import com.syfri.userservice.service.system.MailService;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("mailService")
public class MailServiceImpl extends BaseServiceImpl<MailVO> implements MailService {

	@Autowired
	private MailDAO mailDAO;

	@Override
	public MailDAO getBaseDAO() {
		return mailDAO;
	}

	@Override
	public MailVO setJavaMailSender(JavaMailSenderImpl javaMailSender) throws Exception{
		List<MailVO> mvos=mailDAO.doSearchAbleListByVO(null);
		if(mvos!=null&&mvos.size()>0){
			MailVO mvo=mvos.get(0);
			javaMailSender.setUsername(mvo.getUsername());
			javaMailSender.setDefaultEncoding(mvo.getEncoding());
			javaMailSender.setHost(mvo.getHost());
			javaMailSender.setPassword(mvo.getPassword());
			javaMailSender.setPort(mvo.getPort());
			javaMailSender.setProtocol(mvo.getProtocol());
			return mvo;
		}else{
			throw new RuntimeException("当前无可用邮箱！请联系管理员！");
		}
	}
	public void doDisAbleMail(MailVO mailVO){
		if(mailVO!=null&& mailVO.getUuid()!=null&& mailVO.getUuid().length()>0){
			mailVO.setStatue("N");
			//yyyy-MM-dd HH24:mi:ss
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String today=sdf.format(new Date());
			mailVO.setTerm(today);
			mailVO.setAlterTime(today);
			mailVO.setAlterId(CurrentUserUtil.getCurrentUserId());
			mailVO.setAlterName(CurrentUserUtil.getCurrentUserName());
			mailDAO.doUpdateByVO(mailVO);
		}
	}
}