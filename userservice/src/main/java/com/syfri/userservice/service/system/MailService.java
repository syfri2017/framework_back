package com.syfri.userservice.service.system;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.system.MailVO;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.List;

public interface MailService  extends BaseService<MailVO>{
    public MailVO setJavaMailSender(JavaMailSenderImpl javaMailSender)throws Exception;
    public void doDisAbleMail(MailVO mailVO);

    /*--查询：邮箱表格数据--*/
    List<MailVO> doFindMail(MailVO mailVO);

   /*--删除：邮箱表格数据--*/
    int doDeleteMail(List<MailVO> list);

    /*--新增：新增邮箱表格数据--*/
    MailVO doInsertMail(MailVO mailVO);

}