package com.syfri.digitalplan.dao.importantparts;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.buildingzoning.ChuguanVO;
import com.syfri.digitalplan.model.buildingzoning.WeixianjiezhiVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsCglVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsJzlVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsZzlVO;

import java.util.List;

public interface ImportantpartsDAO extends BaseDAO<ImportantpartsVO>{
    /*--根据重点单位id获取建筑类重点部位详情集合.--*/
    List<ImportantpartsVO> doFindJzlListByZddwId(String zddwId);
    /*--根据重点单位id获取装置类重点部位详情集合.--*/
    List<ImportantpartsVO> doFindZzlListByZddwId(String zddwId);
    /*--根据重点单位id获取储罐类重点部位详情集合.--*/
    List<ImportantpartsVO> doFindCglListByZddwId(String zddwId);

    /*--新增重点部位-建筑类 by li.xue 2018/8/13*/
    int doInsertByVOJzl(ImportantpartsJzlVO vo);

    /*--新增重点部位-建筑类-危险介质 by li.xue 2018/8/13*/
    int doInsertByVOJzlWxjz(WeixianjiezhiVO vo);

    /*--新增重点部位-装置类 by li.xue 2018/8/13*/
    int doInsertByVOZzl(ImportantpartsZzlVO vo);

    /*--新增重点部位-储罐类 by li.xue 2018/8/13*/
    int doInsertByVOCgl(ImportantpartsCglVO vo);

    /*--新增重点部位-储罐类-储罐 by li.xue 2018/8/13*/
    int doInsertByVOCglCg(ChuguanVO vo);

    /*--修改重点部位-建筑类 by li.xue 2018/8/13*/
    int doUpdateByVOJzl(ImportantpartsJzlVO vo);

    /*--修改重点部位-建筑类-危险介质 by li.xue 2018/8/13*/
    int doUpdateByVOJzlWxjz(WeixianjiezhiVO vo);

    /*--修改重点部位-装置类 by li.xue 2018/8/13*/
    int doUpdateByVOZzl(ImportantpartsZzlVO vo);

    /*--修改重点部位-储罐类 by li.xue 2018/8/13*/
    int doUpdateByVOCgl(ImportantpartsCglVO vo);

    /*--修改重点部位-储罐类-储罐 by li.xue 2018/8/13*/
    int doUpdateByVOCglCg(ChuguanVO vo);

    /*--根据重点部位ID删除重点部位-建筑类 by li.xue 2018/8/13*/
    void doDeleteByZdbwIdJzl(String zdbwId);

    /*--根据重点部位ID删除重点部位-建筑类-危险介质 by li.xue 2018/8/13*/
    void doDeleteByZdbwJzlIdJzlWxjz(String zdbwJzlId);

    /*--根据重点部位ID删除重点部位-装置类 by li.xue 2018/8/13*/
    void doDeleteByZdbwIdZzl(String zdbwid);

    /*--根据重点部位ID删除重点部位-储罐类 by li.xue 2018/8/13*/
    void doDeleteByZdbwIdCgl(String zdbwid);

    /*--根据重点部位ID删除重点部位-储罐类-储罐 by li.xue 2018/8/13*/
    void doDeleteByZdbwCglIdCglCg(String zdbwCglId);
}