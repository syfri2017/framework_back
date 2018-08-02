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

    /*--修改总队从表 by li.xue 2018/07/27.--*/
    int doDeleteZongdByDzid(ZongdVO zongdVO);

    /*--修改支队从表 by li.xue 2018/07/27.--*/
    int doDeleteZhidByDzid(ZhidVO zhidVO);

    /*--修改大队从表 by li.xue 2018/07/27.--*/
    int doDeleteDadByDzid(DadVO dadVO);

    /*--修改中队从表 by li.xue 2018/07/27.--*/
    int doDeleteZhongdByDzid(ZhongdVO zhongdVO);

    /*--修改其他消防队伍从表 by li.xue 2018/07/27.--*/
    int doDeleteQtxfdwByDzid(QtxfdwVO qtxfdwVO);

    /*--根据队站ID查询总队记录数 by li.xue 2018/08/02.--*/
    int doCountZongdByDzid(String dzid);

    /*--根据队站ID查询支队记录数 by li.xue 2018/08/02.--*/
	int doCountZhidByDzid(String dzid);

	/*--根据队站ID查询大队记录数 by li.xue 2018/08/02.--*/
    int doCountDadByDzid(String dzid);

	/*--根据队站ID查询中队记录数 by li.xue 2018/08/02.--*/
    int doCountZhongdByDzid(String dzid);

	/*--根据队站ID查询其他消防队伍记录数 by li.xue 2018/08/02.--*/
    int doCountQtxfdwByDzid(String dzid);
}