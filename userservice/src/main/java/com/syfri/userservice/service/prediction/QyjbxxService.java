package com.syfri.userservice.service.prediction;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QyjbxxService  extends BaseService<QyjbxxVO>{

    /*--通过用户、企业查询展商信息 by li.xue 2018/10/0 11:13.--*/
    List<QyjbxxVO> doFindZsxxByQyjbxx(QyjbxxVO qyjbxxVO);

    int doDeleteJbxx(List<QyjbxxVO> voList);
    //add by yushch insert返回vo
    QyjbxxVO doInsertJbxxByVO(QyjbxxVO qyjbxxVO);
    //查询邮箱是否被注册过（account表、jbxx表）
    int doSearchCountByMail(String mail);

    //上传图片
    QyjbxxVO uploadPics(MultipartFile multipartFile,QyjbxxVO vo,String fileName);
    //上传pdf
    int uploadPdfs(MultipartFile multipartFile,QyjbxxVO vo);
    String savenew(MultipartFile file);
}