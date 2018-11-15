package com.syfri.userservice.service.system;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.system.MailVO;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public interface MailService  extends BaseService<MailVO>{
    public MailVO setJavaMailSender(JavaMailSenderImpl javaMailSender)throws Exception;
    public void doDisAbleMail(MailVO mailVO);
}