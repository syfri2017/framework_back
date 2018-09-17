package com.syfri.digitalplan.service.basicinfo.firestationsource;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.basicinfo.firestationsource.XfdzTree;
import com.syfri.digitalplan.model.basicinfo.firestationsource.XfdzVO;

import java.util.List;

public interface XfdzService  extends BaseService<XfdzVO>{
    public XfdzVO doFindDzDetailByVo(XfdzVO xfdzVO);
    public List<XfdzVO> doSearchProvinceList(XfdzVO xfdzVO);

    /*--通过Dzid查询队站树 by li.xue 2018/7/25.--*/
    List<XfdzTree> doFindDzTreeByUser(XfdzVO xfdzVO);

    /*--通过Dzid查询队站树ALL(包括公安部消防局) by li.xue 2018/7/25.--*/
    List<XfdzTree> doFindDzTreeByUserAll(XfdzVO xfdzVO);

    /*--新增消防队站 by li.xue 2018/7/25.--*/
    XfdzVO doInsertByXfdzVO(XfdzVO xfdzVO);

    /*--修改消防队站 by li.xue 2018/7/25.--*/
    XfdzVO doUpdateByXfdzVO(XfdzVO xfdzVO);

    /*--判断队站从表执行新增还是修改 by li.xue 2018/08/02.--*/
    void doExeInsertOrUpdate(XfdzVO xfdzVO);

    /*--判断队站名称是否存在 by li.xue 2018/7/25.--*/
    int doCheckName(String dzmc);

    /*--批量删除队站 by li.xue 2018/7/25*/
    int doDeleteBatch(List<XfdzVO> list);

    /*--删除从表队站 by li.xue 2018/8/7.--*/
    void doDeleteDetail(XfdzVO xfdzVO);

    /*--根据登录人组织机构ID获取其一级队站 by li.xue 2018/9/17.--*/
    List<XfdzTree> doFindDzYjByOrgId(String orgId);
}