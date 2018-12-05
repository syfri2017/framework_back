package com.syfri.userservice.service.impl.system;

import com.syfri.userservice.utils.CurrentUserUtil;
import org.springframework.aop.framework.AopContext;
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

	/*--查询：邮箱表格数据--*/
	@Override
	public List<MailVO> doFindMail(MailVO mailVO){ return mailDAO.doFindMail(mailVO); }

	/*-- 删除：邮箱表格数据 --*/
	@Override
	public int doDeleteMail(List<MailVO> list){
		int num = 0;
		for(MailVO vo: list){
			String mailid = vo.getUuid();
			//删除邮件数据表
			mailDAO.doDeleteById(mailid);
			num++;
		}
		return num;
	}

	/*--新增：邮箱表格数据--*/
	public MailVO doInsertMail(MailVO mailVO){
		mailVO.setCreateId(CurrentUserUtil.getCurrentUserId());
		mailVO.setCreateName(CurrentUserUtil.getCurrentUserName());
		mailDAO.doInsertByVO(mailVO);
		return mailVO;
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