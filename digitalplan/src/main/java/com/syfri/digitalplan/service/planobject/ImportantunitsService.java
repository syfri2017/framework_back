package com.syfri.digitalplan.service.planobject;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.buildingzoning.BuildingVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsVO;
import com.syfri.digitalplan.model.planobject.XiaofangliliangVO;
import com.syfri.digitalplan.model.planobject.ImportantunitsVO;

import java.util.List;
import java.util.Map;

public interface ImportantunitsService  extends BaseService<ImportantunitsVO>{

    //通过重点单位id 查询包含消防队伍详情
    List<XiaofangliliangVO> doFindXfllListByZddwId(String zddwId);

    //通过重点单位 查询包含分区详情
    List<BuildingVO> doFindBuildingDetailsByVo(ImportantunitsVO vo);

    //通过重点单位 查询包含消防设施详情
    Map<String, List> doFindFireFacilitiesDetailsByVo(ImportantunitsVO vo);

    //通过重点单位 查询建筑分区详情包含消防设施详情
    List<BuildingVO> doFindBuildingDetailsAndFirefacilitiesByVo(ImportantunitsVO vo);

    /**
     * author lxy
     * @param vo
     * @return
     */
    List<ImportantunitsVO> doSearchZddwListByVO(ImportantunitsVO vo);

    /*--校验重点单位名称是否存在 by li.xue 2018/8/13.--*/
    int doCheckName(String dwmc);

    /*--新增重点单位 by li.xue 2018/8/13.--*/
    ImportantunitsVO doInsertByVOAll(ImportantunitsVO vo);

    /*--修改重点单位 by li.xue 2018/8/13.--*/
    ImportantunitsVO doUpdateByVOAll(ImportantunitsVO vo);

    /*--批量删除重点单位 by li.xue 2018/8/13.--*/
    int doDeleteBatch(List<ImportantunitsVO> list);

    /*--判断建筑信息从表执行新增还是修改 by li.xue 2018/8/13.--*/
    int doExeInsertOrUpdateJzxx(ImportantunitsVO vo);

    /*--判断消防力量从表执行新增还是修改 by li.xue 2018/8/13.--*/
    int doExeInsertOrUpdateXfll(ImportantunitsVO vo);

    /*--判断重点部位从表执行新增还是修改 by li.xue 2018/8/13.--*/
    int doExeInsertOrUpdateZdbw(ImportantunitsVO vo);

    /*--判断重点部位-建筑类-危险介质从表执行新增还是修改 by li.xue 2018/8/13.--*/
    int doExeInsertOrUpdateZdbwJzlWxjz(ImportantunitsVO vo);

    /*--判断重点部位-储罐类-储罐从表执行新增还是修改 by li.xue 2018/8/13.--*/
    int doExeInsertOrUpdateZdbwCglCg(ImportantunitsVO vo);
}