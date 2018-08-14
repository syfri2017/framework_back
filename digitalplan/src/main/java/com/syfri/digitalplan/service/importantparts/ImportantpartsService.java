package com.syfri.digitalplan.service.importantparts;

import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.buildingzoning.ChuguanVO;
import com.syfri.digitalplan.model.buildingzoning.WeixianjiezhiVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsCglVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsJzlVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsZzlVO;

import java.util.List;

public interface ImportantpartsService  extends BaseService<ImportantpartsVO>{

    /*--根据重点单位id获取建筑类重点部位详情集合.--*/
    List<ImportantpartsVO> doFindJzlListByZddwId(String zddwId);
    /*--根据重点单位id获取装置类重点部位详情集合.--*/
    List<ImportantpartsVO> doFindZzlListByZddwId(String zddwId);
    /*--根据重点单位id获取储罐类重点部位详情集合.--*/
    List<ImportantpartsVO> doFindCglListByZddwId(String zddwId);

    /*--根据重点单位ID查询其重点部位信息 by li.xue 2018/8/14--*/
    List<ImportantpartsVO> doFindZdbwListByZddwId(String zddwId);

    /*--新增重点部位 by li.xue 2018/8/13*/
    int doInsertZdbwByList(List<ImportantpartsVO> list, String zddwId, String jdh);

    /*--修改重点部位 by li.xue 2018/8/13*/
    void doUpdateZdbwByList(List<ImportantpartsVO> list, String zddwId, String jdh);

    /*--通过重点单位ID删除重点部位 by li.xue 2018/8/13*/
    int doDeleteZdbwByZddwId(String zddwId, String xgrid, String xgrmc);

    /*--根据重点部位类型删除从表及从从表 by li.xue 2018/8/14*/
    void doDeleteZdbwCongByZdbwlx(ImportantpartsVO vo);
}