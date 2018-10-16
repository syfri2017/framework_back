package com.syfri.exhibition.service.prediction;

import com.syfri.baseapi.service.BaseService;
import com.syfri.exhibition.model.prediction.QyjbxxVO;

import java.util.List;

public interface QyjbxxService  extends BaseService<QyjbxxVO>{

    /*--通过用户、企业查询展商信息 by li.xue 2018/10/0 11:13.--*/
    List<QyjbxxVO> doFindZsxxByQyjbxx(QyjbxxVO qyjbxxVO);

    int doDeleteJbxx(List<QyjbxxVO> voList);
    //add by yushch insert返回vo
    QyjbxxVO doInsertJbxxByVO(QyjbxxVO qyjbxxVO);
}