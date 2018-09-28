package com.syfri.digitalplan.service.jxcsplan;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.jxcsplan.JxcsjbxxVO;

import java.util.List;

public interface JxcsjbxxService extends BaseService<JxcsjbxxVO> {

    /*--批量删除九小场所 by liurui 2018/9/7--*/
    int doDeleteByVOList(List<JxcsjbxxVO> jxcsjbxxVOList);
    //新增九小场所 by yushch 20180920
    JxcsjbxxVO doInsertJbcsByVO(JxcsjbxxVO vo);
}