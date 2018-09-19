package com.syfri.digitalplan.service.basicinfo.watersource;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.basicinfo.watersource.XfsyVO;

import java.util.List;

public interface XfsyService  extends BaseService<XfsyVO>{
    XfsyVO doFindSyAndSxByVo(XfsyVO xfsyVO);
    List<XfsyVO> doFindListByVO(XfsyVO xfsyVO);
    //插入
    XfsyVO doInsertByXfsyVO(XfsyVO xfsyVO);
    //修改
    XfsyVO doUpdateByXfsyVO(XfsyVO xfsyVO);
    //删除
    int doDeleteBatch(List<XfsyVO> list);

    List<XfsyVO> doFindTrsyListByVO(XfsyVO xfsyVO);
    XfsyVO doFindTrsyByUUId(XfsyVO xfsyVO);
    XfsyVO insertTrsyByXfsyVO(XfsyVO xfsyVO);
    XfsyVO doUpdateTrsyByVO(XfsyVO xfsyVO);
    int doDeleteTrsyByUUId(List<XfsyVO> list);
}