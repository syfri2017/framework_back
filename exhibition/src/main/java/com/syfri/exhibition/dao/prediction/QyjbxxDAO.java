package com.syfri.exhibition.dao.prediction;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.exhibition.model.prediction.QyjbxxVO;

import java.util.List;

public interface QyjbxxDAO extends BaseDAO<QyjbxxVO>{

    /*--通过用户、企业查询展商信息 by li.xue 2018/10/0 11:13.--*/
    List<QyjbxxVO> doFindZsxxByQyjbxx(QyjbxxVO qyjbxxVO);
}