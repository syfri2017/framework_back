package com.syfri.digitalplan.dao.basicinfo.firestationsource;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.basicinfo.firestationsource.*;

import java.util.List;

public interface XfdzDAO extends BaseDAO<XfdzVO>{
    //查询总队队站详情
    public XfdzVO doFindDzZongDDetailByVo(XfdzVO xfdzVO);
    //查询支队队站详情
    public XfdzVO doFindDzZhiDDetailByVo(XfdzVO xfdzVO);
    //查询大队队站详情
    public XfdzVO doFindDzDaDDetailByVo(XfdzVO xfdzVO);
    //查询中队队站详情
    public XfdzVO doFindDzZhongDDetailByVo(XfdzVO xfdzVO);
    //查询其他消防队伍队站详情
    public XfdzVO doFindDzQtxfdwDetailByVo(XfdzVO xfdzVO);
    //查询行政区划所在省的所有队站
    public List<XfdzVO> doSearchProvinceList(XfdzVO xfdzVO);

    /*--根据上级队站ID查询队站列表by li.xue 2018/07/25.--*/
    List<XfdzTree> doFindXfdzBySjdzid(String sjdzid);

    /*--判断队站名称是否存在 by li.xue 2018/07/25.--*/
    int doCheckName(String dzmc);

    /*--插入总队从表 by li.xue 2018/07/27.--*/
    int doInsertZongdByVO(ZongdVO zongdVO);

    /*--插入支队从表 by li.xue 2018/07/27.--*/
    int doInsertZhidByVO(ZhidVO zhidVO);

    /*--插入大队从表 by li.xue 2018/07/27.--*/
    int doInsertDadByVO(DadVO dadVO);

    /*--插入中队从表 by li.xue 2018/07/27.--*/
    int doInsertZhongdByVO(ZhongdVO zhongdVO);

    /*--插入其他消防队伍从表 by li.xue 2018/07/27.--*/
    int doInsertQtxfdwByVO(QtxfdwVO qtxfdwVO);

    /*--修改总队从表 by li.xue 2018/07/27.--*/
    int doUpdateZongdByVO(ZongdVO zongdVO);

    /*--修改支队从表 by li.xue 2018/07/27.--*/
    int doUpdateZhidByVO(ZhidVO zhidVO);

    /*--修改大队从表 by li.xue 2018/07/27.--*/
    int doUpdateDadByVO(DadVO dadVO);

    /*--修改中队从表 by li.xue 2018/07/27.--*/
    int doUpdateZhongdByVO(ZhongdVO zhongdVO);

    /*--修改其他消防队伍从表 by li.xue 2018/07/27.--*/
    int doUpdateQtxfdwByVO(QtxfdwVO qtxfdwVO);
}