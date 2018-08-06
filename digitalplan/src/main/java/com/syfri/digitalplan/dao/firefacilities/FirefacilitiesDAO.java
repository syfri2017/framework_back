package com.syfri.digitalplan.dao.firefacilities;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.firefacilities.*;

import java.util.List;

public interface FirefacilitiesDAO extends BaseDAO<FirefacilitiesVO>{
    //查询 安全疏散措施-安全出口 列表
    public List<Firefacilities_aqsscs_aqckVO> doFindAqckList(String xfssid);
    //查询 安全疏散措施-疏散楼梯 列表
    public List<Firefacilities_aqsscs_ssltVO> doFindSsltList(String xfssid);
    //查询 安全疏散措施-消防电梯 列表
    public List<Firefacilities_aqsscs_xfdtVO> doFindXfdtList(String xfssid);
    //查询 安全疏散措施-避难层 列表
    public List<Firefacilities_aqsscs_bncVO> doFindBncList(String xfssid);
    //查询 安全疏散措施-应急广播 列表
    public List<Firefacilities_aqsscs_yjgbVO> doFindYjgbList(String xfssid);

    //查询消防水系统-消防泵房 列表
    public List<Firefacilities_xfsxt_xfbfVO> doFindXfbfList(String xfssid);
    //查询 消防水系统-消防水箱 列表
    public List<Firefacilities_xfsxt_xfsxVO> doFindXfsxList(String xfssid);
    //查询 消防水系统-消防水池 列表
    public List<Firefacilities_xfsxt_xfscVO> doFindXfscList(String xfssid);
    //查询 消防水系统-室内消火栓 列表
    public List<Firefacilities_xfsxt_snxhsVO> doFindSnxhsList(String xfssid);
    //消防水系统-室外消火栓
    public List<Firefacilities_xfsxt_swxhsVO> doFindSwxhsList(String xfssid);
    //消防水系统-水泵接合器
    public List<Firefacilities_xfsxt_sbjhqVO> doFindSbjhqList(String xfssid);
    //消防水系统-喷淋系统
    public List<Firefacilities_xfsxt_plxtVO> doFindPlxtList(String xfssid);
    //消防水系统-冷却水系统
    public List<Firefacilities_xfsxt_lqsxtVO> doFindLqsxtList(String xfssid);
    //消防水系统-固定水炮
    public List<Firefacilities_xfsxt_gdspVO> doFindGdspList(String xfssid);
    //消防水系统-半固定设施
    public List<Firefacilities_xfsxt_bgdssVO> doFindBgdssList(String xfssid);

    //泡沫系统-泡沫泵房
    public List<Firefacilities_pmxt_pmbfVO> doFindPmbfList(String xfssid);
    //泡沫系统-泡沫消火栓
    public List<Firefacilities_pmxt_pmxhsVO> doFindPmxhsList(String xfssid);
    //泡沫系统-固定泡沫炮
    public List<Firefacilities_pmxt_gdpmpVO> doFindGdpmpList(String xfssid);
    //泡沫系统-泡沫发生器
    public List<Firefacilities_pmxt_pmfsqVO> doFindPmfsqList(String xfssid);
    //泡沫系统-半固定设施
    public List<Firefacilities_pmxt_bgdssVO> doFindPmBgdssList(String xfssid);

    //蒸汽灭火系统-固定式
    public List<Firefacilities_zqmhxt_gdsVO> doFindGdsList(String xfssid);
    //蒸汽灭火系统-半固定式
    public List<Firefacilities_zqmhxt_bgdsVO> doFindBgdsList(String xfssid);
    //消防控制室
    public List<Firefacilities_xfkzsVO> doFindXfkzsList(String xfssid);
    //防排烟措施-排烟口/出烟口
    public List<Firefacilities_fpycs_pycykVO> doFindPycykList(String xfssid);
    //防排烟措施-防排烟系统
    public List<Firefacilities_fpycs_fpyxtVO> doFindFpyxtList(String xfssid);
    //防火分区
    public List<Firefacilities_fhfqVO> doFindFhfqList(String xfssid);
    //其他灭火系统-气体灭火系统
    public List<Firefacilities_qtmhxt_qtmhxtVO> doFindQtmhxtList(String xfssid);
    //其他灭火系统-干粉灭火系统
    public List<Firefacilities_qtmhxt_gfmhxtVO> doFindGfmhxtList(String xfssid);
    //其他消防设施
    public List<Firefacilities_qtxfssVO> doFindQtxfssList(String xfssid);





    //新增 安全疏散措施-安全出口 列表
    public int doInsertAqckByVO(Firefacilities_aqsscs_aqckVO vo);
    //新增 安全疏散措施-疏散楼梯 列表
    public int doInsertSsltByVO(Firefacilities_aqsscs_ssltVO vo);
    //新增 安全疏散措施-消防电梯 列表
    public int doInsertXfdtByVO(Firefacilities_aqsscs_xfdtVO vo);
    //新增 安全疏散措施-避难层 列表
    public int doInsertBncByVO(Firefacilities_aqsscs_bncVO vo);
    //新增 安全疏散措施-应急广播 列表
    public int doInsertYjgbByVO(Firefacilities_aqsscs_yjgbVO vo);

    //新增消防水系统-消防泵房 列表
    public int doInsertXfbfByVO(Firefacilities_xfsxt_xfbfVO vo);
    //新增 消防水系统-消防水箱 列表
    public int doInsertXfsxByVO(Firefacilities_xfsxt_xfsxVO vo);
    //新增 消防水系统-消防水池 列表
    public int doInsertXfscByVO(Firefacilities_xfsxt_xfscVO vo);
    //新增 消防水系统-室内消火栓 列表
    public int doInsertSnxhsByVO(Firefacilities_xfsxt_snxhsVO vo);
    //新增 消防水系统-室外消火栓
    public int doInsertSwxhsByVO(Firefacilities_xfsxt_swxhsVO vo);
    //新增 消防水系统-水泵接合器
    public int doInsertSbjhqByVO(Firefacilities_xfsxt_sbjhqVO vo);
    //新增 消防水系统-喷淋系统
    public int doInsertPlxtByVO(Firefacilities_xfsxt_plxtVO vo);
    //新增 消防水系统-冷却水系统
    public int doInsertLqsxtByVO(Firefacilities_xfsxt_lqsxtVO vo);
    //新增 消防水系统-固定水炮
    public int doInsertGdspByVO(Firefacilities_xfsxt_gdspVO vo);
    //新增 消防水系统-半固定设施
    public int doInsertBgdssByVO(Firefacilities_xfsxt_bgdssVO vo);

    //新增 泡沫系统-泡沫泵房
    public int doInsertPmbfByVO(Firefacilities_pmxt_pmbfVO vo);
    //新增 泡沫系统-泡沫消火栓
    public int doInsertPmxhsByVO(Firefacilities_pmxt_pmxhsVO vo);
    //新增 泡沫系统-固定泡沫炮
    public int doInsertGdpmpByVO(Firefacilities_pmxt_gdpmpVO vo);
    //新增 泡沫系统-泡沫发生器
    public int doInsertPmfsqByVO(Firefacilities_pmxt_pmfsqVO vo);
    //新增 泡沫系统-半固定设施
    public int doInsertPmBgdssByVO(Firefacilities_pmxt_bgdssVO vo);

    //新增 蒸汽灭火系统-固定式
    public int doInsertGdsByVO(Firefacilities_zqmhxt_gdsVO vo);
    //新增 蒸汽灭火系统-半固定式
    public int doInsertBgdsByVO(Firefacilities_zqmhxt_bgdsVO vo);
    //新增 消防控制室
    public int doInsertXfkzsByVO(Firefacilities_xfkzsVO vo);
    //新增 防排烟措施-排烟口/出烟口
    public int doInsertPycykByVO(Firefacilities_fpycs_pycykVO vo);
    //新增 防排烟措施-防排烟系统
    public int doInsertFpyxtByVO(Firefacilities_fpycs_fpyxtVO vo);
    //新增 防火分区
    public int doInsertFhfqByVO(Firefacilities_fhfqVO vo);
    //新增 其他灭火系统-气体灭火系统
    public int doInsertQtmhxtByVO(Firefacilities_qtmhxt_qtmhxtVO vo);
    //新增 其他灭火系统-干粉灭火系统
    public int doInsertGfmhxtByVO(Firefacilities_qtmhxt_gfmhxtVO vo);
    //新增 其他消防设施
    public int doInsertQtxfssByVO(Firefacilities_qtxfssVO vo);




    //修改 安全疏散措施-安全出口 列表
    public int doUpdateAqckByVO(Firefacilities_aqsscs_aqckVO vo);
    //修改 安全疏散措施-疏散楼梯 列表
    public int doUpdateSsltByVO(Firefacilities_aqsscs_ssltVO vo);
    //修改 安全疏散措施-消防电梯 列表
    public int doUpdateXfdtByVO(Firefacilities_aqsscs_xfdtVO vo);
    //修改 安全疏散措施-避难层 列表
    public int doUpdateBncByVO(Firefacilities_aqsscs_bncVO vo);
    //修改 安全疏散措施-应急广播 列表
    public int doUpdateYjgbByVO(Firefacilities_aqsscs_yjgbVO vo);

    //新增消防水系统-消防泵房 列表
    public int doUpdateXfbfByVO(Firefacilities_xfsxt_xfbfVO vo);
    //修改 消防水系统-消防水箱 列表
    public int doUpdateXfsxByVO(Firefacilities_xfsxt_xfsxVO vo);
    //修改 消防水系统-消防水池 列表
    public int doUpdateXfscByVO(Firefacilities_xfsxt_xfscVO vo);
    //修改 消防水系统-室内消火栓 列表
    public int doUpdateSnxhsByVO(Firefacilities_xfsxt_snxhsVO vo);
    //修改 消防水系统-室外消火栓
    public int doUpdateSwxhsByVO(Firefacilities_xfsxt_swxhsVO vo);
    //修改 消防水系统-水泵接合器
    public int doUpdateSbjhqByVO(Firefacilities_xfsxt_sbjhqVO vo);
    //修改 消防水系统-喷淋系统
    public int doUpdatePlxtByVO(Firefacilities_xfsxt_plxtVO vo);
    //修改 消防水系统-冷却水系统
    public int doUpdateLqsxtByVO(Firefacilities_xfsxt_lqsxtVO vo);
    //修改 消防水系统-固定水炮
    public int doUpdateGdspByVO(Firefacilities_xfsxt_gdspVO vo);
    //修改 消防水系统-半固定设施
    public int doUpdateBgdssByVO(Firefacilities_xfsxt_bgdssVO vo);

    //修改 泡沫系统-泡沫泵房
    public int doUpdatePmbfByVO(Firefacilities_pmxt_pmbfVO vo);
    //修改 泡沫系统-泡沫消火栓
    public int doUpdatePmxhsByVO(Firefacilities_pmxt_pmxhsVO vo);
    //修改 泡沫系统-固定泡沫炮
    public int doUpdateGdpmpByVO(Firefacilities_pmxt_gdpmpVO vo);
    //修改 泡沫系统-泡沫发生器
    public int doUpdatePmfsqByVO(Firefacilities_pmxt_pmfsqVO vo);
    //修改 泡沫系统-半固定设施
    public int doUpdatePmBgdssByVO(Firefacilities_pmxt_bgdssVO vo);

    //修改 蒸汽灭火系统-固定式
    public int doUpdateGdsByVO(Firefacilities_zqmhxt_gdsVO vo);
    //修改 蒸汽灭火系统-半固定式
    public int doUpdateBgdsByVO(Firefacilities_zqmhxt_bgdsVO vo);
    //修改 消防控制室
    public int doUpdateXfkzsByVO(Firefacilities_xfkzsVO vo);
    //修改 防排烟措施-排烟口/出烟口
    public int doUpdatePycykByVO(Firefacilities_fpycs_pycykVO vo);
    //修改 防排烟措施-防排烟系统
    public int doUpdateFpyxtByVO(Firefacilities_fpycs_fpyxtVO vo);
    //修改 防火分区
    public int doUpdateFhfqByVO(Firefacilities_fhfqVO vo);
    //修改 其他灭火系统-气体灭火系统
    public int doUpdateQtmhxtByVO(Firefacilities_qtmhxt_qtmhxtVO vo);
    //修改 其他灭火系统-干粉灭火系统
    public int doUpdateGfmhxtByVO(Firefacilities_qtmhxt_gfmhxtVO vo);
    //修改 其他消防设施
    public int doUpdateQtxfssByVO(Firefacilities_qtxfssVO vo);
}