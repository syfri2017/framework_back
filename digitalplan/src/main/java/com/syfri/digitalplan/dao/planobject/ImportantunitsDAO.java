package com.syfri.digitalplan.dao.planobject;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.planobject.ImportantunitsBuildingVO;
import com.syfri.digitalplan.model.planobject.XiaofangliliangVO;
import com.syfri.digitalplan.model.planobject.ImportantunitsVO;

import java.util.List;

public interface ImportantunitsDAO extends BaseDAO<ImportantunitsVO>{

    //通过重点单位id 获取单位中所有消防力量信息
    List<XiaofangliliangVO> doFindXfllListByZddwId(String zddwId);

    /**
     * author lxy
     * @param vo
     * @return
     */
    List<ImportantunitsVO> doSearchZddwListByVO(ImportantunitsVO vo);

    /*--校验重点单位名称是否存在 by li.xue 2018/8/13.--*/
    int doCheckName(String dwmc);

    /*--新增消防力量 by li.xue 2018/8/13.--*/
    int doInsertByVOXfll(XiaofangliliangVO vo);

    /*--修改消防力量 by li.xue 2018/8/13.--*/
    int doUpdateByVOXfll(XiaofangliliangVO vo);

    /*--按重点单位ID删除消防力量 by li.xue 2018/8/13.--*/
    void doDeleteByIdXfll(String zddwid);

    /*--新增单位建筑信息 by li.xue 2018/8/13.--*/
    int doInsertByVOJzxx(ImportantunitsBuildingVO vo);

    /*--修改单位建筑信息 by li.xue 2018/8/13.--*/
    int doUpdateByVOJzxx(ImportantunitsBuildingVO vo);

    /*--按重点单位ID删除单位建筑信息 by li.xue 2018/8/13.--*/
    void doDeleteByIdJzxx(String zddwid);

    /*--通过重点单位id 查询包含重点单位-建筑信息关系表 by li.xue 2018/8/14.--*/
    List<ImportantunitsBuildingVO> doFindJzxxListByZddwId(String zddwid);

    /*--通过消防队伍ID删除消防队伍 by li.xue 2018/8/14.--*/
    void doDeleteXfllById(String uuid);

    /*--通过重点单位-建筑ID删除重点单位-建筑 by li.xue 2018/8/14.--*/
    void doDeleteJzxxById(String uuid);
}