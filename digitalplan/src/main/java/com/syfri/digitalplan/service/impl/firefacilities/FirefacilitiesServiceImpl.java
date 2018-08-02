package com.syfri.digitalplan.service.impl.firefacilities;

import com.syfri.baseapi.model.ValueObject;
import com.syfri.digitalplan.model.firefacilities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.firefacilities.FirefacilitiesDAO;
import com.syfri.digitalplan.service.firefacilities.FirefacilitiesService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("firefacilitiesService")
public class FirefacilitiesServiceImpl extends BaseServiceImpl<FirefacilitiesVO> implements FirefacilitiesService {

    @Autowired
    private FirefacilitiesDAO firefacilitiesDAO;

    @Override
    public FirefacilitiesDAO getBaseDAO() {
        return firefacilitiesDAO;
    }

    /*
    * 查询安全设施列表，分类关联从表查询从表信息
    * 返回map<消防设施类型，类型对应的从表信息list>
    * by yushch 20180509
    * */
    public Map<String, List> doFindlist(FirefacilitiesVO vo) {
        List<FirefacilitiesVO> firefacilities = firefacilitiesDAO.doSearchListByVO(vo);
        Map<String, List> map = new HashMap<String, List>();
        List aqck = new ArrayList();
        List sslt = new ArrayList();
        List xfdt = new ArrayList();
        List bnc = new ArrayList();
        List yjgb = new ArrayList();
        List xfbf = new ArrayList();
        List xfsx = new ArrayList();
        List xfsc = new ArrayList();
        List snxhs = new ArrayList();
        List swxhs = new ArrayList();
        List sbjhq = new ArrayList();
        List plxt = new ArrayList();
        List lqsxt = new ArrayList();
        List gdsp = new ArrayList();
        List bgdss = new ArrayList();
        List pmbf = new ArrayList();
        List pmxhs = new ArrayList();
        List gdpmp = new ArrayList();
        List pmfsq = new ArrayList();
        List pm_bgdss = new ArrayList();
        List gds = new ArrayList();
        List bgds = new ArrayList();
        List xfkzs = new ArrayList();
        List pycyk = new ArrayList();
        List fpyxt = new ArrayList();
        List fhfq = new ArrayList();
        List qtmhxt = new ArrayList();
        List gfmhxt = new ArrayList();
        List qtxfss = new ArrayList();
        for (FirefacilitiesVO data : firefacilities) {
            String xfsslx = data.getJbxx_xfsslx();
            String xfssid = data.getJbxx_xfssid();
            switch (xfsslx) {
                //安全疏散措施
                case "1000":
                    break;
                case "1001":
                    List list_1001 = firefacilitiesDAO.doFindAqckList(xfssid);
                    for (int i = 0; i < list_1001.size(); i++) {
                        aqck.add(list_1001.get(i));
                    }
                    break;
                case "1002":
                    List list_1002 = firefacilitiesDAO.doFindSsltList(xfssid);
                    for (int i = 0; i < list_1002.size(); i++) {
                        sslt.add(list_1002.get(i));
                    }
                    break;
                case "1003":
                    List list_1003 = firefacilitiesDAO.doFindXfdtList(xfssid);
                    for (int i = 0; i < list_1003.size(); i++) {
                        xfdt.add(list_1003.get(i));
                    }
                    break;
                case "1004":
                    List list_1004 = firefacilitiesDAO.doFindBncList(xfssid);
                    for (int i = 0; i < list_1004.size(); i++) {
                        bnc.add(list_1004.get(i));
                    }
                    break;
                case "1005":
                    List list_1005 = firefacilitiesDAO.doFindYjgbList(xfssid);
                    for (int i = 0; i < list_1005.size(); i++) {
                        yjgb.add(list_1005.get(i));
                    }
                    break;
                //消防水系统
                case "2000":
                    break;
                case "2001":
                    List list_2001 = firefacilitiesDAO.doFindXfbfList(xfssid);
                    for (int i = 0; i < list_2001.size(); i++) {
                        xfbf.add(list_2001.get(i));
                    }
                    break;
                case "2002":
                    List list_2002 = firefacilitiesDAO.doFindXfsxList(xfssid);
                    for (int i = 0; i < list_2002.size(); i++) {
                        xfsx.add(list_2002.get(i));
                    }
                    break;
                case "2003":
                    List list_2003 = firefacilitiesDAO.doFindXfscList(xfssid);
                    for (int i = 0; i < list_2003.size(); i++) {
                        xfsc.add(list_2003.get(i));
                    }
                    break;
                case "2004":
                    List list_2004 = firefacilitiesDAO.doFindSnxhsList(xfssid);
                    for (int i = 0; i < list_2004.size(); i++) {
                        snxhs.add(list_2004.get(i));
                    }
                    break;
                case "2005":
                    List list_2005 = firefacilitiesDAO.doFindSwxhsList(xfssid);
                    for (int i = 0; i < list_2005.size(); i++) {
                        swxhs.add(list_2005.get(i));
                    }
                    break;
                case "2006":
                    List list_2006 = firefacilitiesDAO.doFindSbjhqList(xfssid);
                    for (int i = 0; i < list_2006.size(); i++) {
                        sbjhq.add(list_2006.get(i));
                    }
                    break;
                case "2007":
                    List list_2007 = firefacilitiesDAO.doFindPlxtList(xfssid);
                    for (int i = 0; i < list_2007.size(); i++) {
                        plxt.add(list_2007.get(i));
                    }
                    break;
                case "2008":
                    List list_2008 = firefacilitiesDAO.doFindLqsxtList(xfssid);
                    for (int i = 0; i < list_2008.size(); i++) {
                        lqsxt.add(list_2008.get(i));
                    }
                    break;
                case "2009":
                    List list_2009 = firefacilitiesDAO.doFindGdspList(xfssid);
                    for (int i = 0; i < list_2009.size(); i++) {
                        gdsp.add(list_2009.get(i));
                    }
                    break;
                case "2010":
                    List list_2010 = firefacilitiesDAO.doFindBgdssList(xfssid);
                    for (int i = 0; i < list_2010.size(); i++) {
                        bgdss.add(list_2010.get(i));
                    }
                    break;
                //泡沫系统
                case "3000":
                    break;
                case "3001":
                    List list_3001 = firefacilitiesDAO.doFindPmbfList(xfssid);
                    for (int i = 0; i < list_3001.size(); i++) {
                        pmbf.add(list_3001.get(i));
                    }
                    break;
                case "3002":
                    List list_3002 = firefacilitiesDAO.doFindPmxhsList(xfssid);
                    for (int i = 0; i < list_3002.size(); i++) {
                        pmxhs.add(list_3002.get(i));
                    }
                    break;
                case "3003":
                    List list_3003 = firefacilitiesDAO.doFindGdpmpList(xfssid);
                    for (int i = 0; i < list_3003.size(); i++) {
                        gdpmp.add(list_3003.get(i));
                    }
                    break;
                case "3004":
                    List list_3004 = firefacilitiesDAO.doFindPmfsqList(xfssid);
                    for (int i = 0; i < list_3004.size(); i++) {
                        pmfsq.add(list_3004.get(i));
                    }
                    break;
                case "3005":
                    List list_3005 = firefacilitiesDAO.doFindPmBgdssList(xfssid);
                    for (int i = 0; i < list_3005.size(); i++) {
                        pm_bgdss.add(list_3005.get(i));
                    }
                    break;
                //蒸汽灭火系统
                case "4000":
                    break;
                case "4001":
                    List list_4001 = firefacilitiesDAO.doFindGdsList(xfssid);
                    for (int i = 0; i < list_4001.size(); i++) {
                        gds.add(list_4001.get(i));
                    }
                    break;
                case "4002":
                    List list_4002 = firefacilitiesDAO.doFindBgdsList(xfssid);
                    for (int i = 0; i < list_4002.size(); i++) {
                        bgds.add(list_4002.get(i));
                    }
                    break;
                //消防控制室
                case "5000":
                    List list_5000 = firefacilitiesDAO.doFindXfkzsList(xfssid);
                    for (int i = 0; i < list_5000.size(); i++) {
                        xfkzs.add(list_5000.get(i));
                    }
                    break;
                //防排烟设施
                case "6000":
                    break;
                case "6001":
                    List list_6001 = firefacilitiesDAO.doFindPycykList(xfssid);
                    for (int i = 0; i < list_6001.size(); i++) {
                        pycyk.add(list_6001.get(i));
                    }
                    break;
                case "6002":
                    List list_6002 = firefacilitiesDAO.doFindFpyxtList(xfssid);
                    for (int i = 0; i < list_6002.size(); i++) {
                        fpyxt.add(list_6002.get(i));
                    }
                    break;
                //防火分区
                case "7000":
                    List list_7000 = firefacilitiesDAO.doFindFhfqList(xfssid);
                    for (int i = 0; i < list_7000.size(); i++) {
                        fhfq.add(list_7000.get(i));
                    }
                    break;
                //其他灭火系统
                case "8000":
                    break;
                case "8001":
                    List list_8001 = firefacilitiesDAO.doFindQtmhxtList(xfssid);
                    for (int i = 0; i < list_8001.size(); i++) {
                        qtmhxt.add(list_8001.get(i));
                    }
                    break;
                case "8002":
                    List list_8002 = firefacilitiesDAO.doFindGfmhxtList(xfssid);
                    for (int i = 0; i < list_8002.size(); i++) {
                        gfmhxt.add(list_8002.get(i));
                    }
                    break;
                //其他消防设施
                case "9000":
                    List list_9000 = firefacilitiesDAO.doFindQtxfssList(xfssid);
                    for (int i = 0; i < list_9000.size(); i++) {
                        qtxfss.add(list_9000.get(i));
                    }
                    break;
            }
        }
        if (!aqck.isEmpty())
            map.put("1001", aqck);
        if (!sslt.isEmpty())
            map.put("1002", sslt);
        if (!xfdt.isEmpty())
            map.put("1003", xfdt);
        if (!bnc.isEmpty())
            map.put("1004", bnc);
        if (!yjgb.isEmpty())
            map.put("1005", yjgb);
        if (!xfbf.isEmpty())
            map.put("2001", xfbf);
        if (!xfsx.isEmpty())
            map.put("2002", xfsx);
        if (!xfsc.isEmpty())
            map.put("2003", xfsc);
        if (!snxhs.isEmpty())
            map.put("2004", snxhs);
        if (!swxhs.isEmpty())
            map.put("2005", swxhs);
        if (!sbjhq.isEmpty())
            map.put("2006", sbjhq);
        if (!plxt.isEmpty())
            map.put("2007", plxt);
        if (!lqsxt.isEmpty())
            map.put("2008", lqsxt);
        if (!gdsp.isEmpty())
            map.put("2009", gdsp);
        if (!bgdss.isEmpty())
            map.put("2010", bgdss);
        if (!pmbf.isEmpty())
            map.put("3001", pmbf);
        if (!pmxhs.isEmpty())
            map.put("3002", pmxhs);
        if (!gdpmp.isEmpty())
            map.put("3003", gdpmp);
        if (!pmfsq.isEmpty())
            map.put("3004", pmfsq);
        if (!pm_bgdss.isEmpty())
            map.put("3005", pm_bgdss);
        if (!gds.isEmpty())
            map.put("4001", gds);
        if (!bgds.isEmpty())
            map.put("4002", bgds);
        if (!xfkzs.isEmpty())
            map.put("5000", xfkzs);
        if (!pycyk.isEmpty())
            map.put("6001", pycyk);
        if (!fpyxt.isEmpty())
            map.put("6002", fpyxt);
        if (!fhfq.isEmpty())
            map.put("7000", fhfq);
        if (!qtmhxt.isEmpty())
            map.put("8001", qtmhxt);
        if (!gfmhxt.isEmpty())
            map.put("8002", gfmhxt);
        if (!qtxfss.isEmpty())
            map.put("9000", qtxfss);
        return map;
    }

    public ValueObject doFindXfssDetail(FirefacilitiesVO vo) {
        ValueObject detailVo = new ValueObject();
        String xfsslx = vo.getJbxx_xfsslx();
        String xfssid = vo.getJbxx_xfssid();
        switch (xfsslx) {
            //安全疏散措施
            case "1000":
                break;
            case "1001":
                List<Firefacilities_aqsscs_aqckVO> list_1001 = firefacilitiesDAO.doFindAqckList(xfssid);
                if (list_1001.size() > 0) {
                    detailVo =  list_1001.get(0);
                }
                break;
            case "1002":
                List<Firefacilities_aqsscs_ssltVO> list_1002 = firefacilitiesDAO.doFindSsltList(xfssid);
                if (list_1002.size() > 0) {
                    detailVo =  list_1002.get(0);
                }
                break;
            case "1003":
                List<Firefacilities_aqsscs_xfdtVO> list_1003 = firefacilitiesDAO.doFindXfdtList(xfssid);
                if (list_1003.size() > 0) {
                    detailVo =  list_1003.get(0);
                }
                break;
            case "1004":
                List<Firefacilities_aqsscs_bncVO> list_1004 = firefacilitiesDAO.doFindBncList(xfssid);
                if (list_1004.size() > 0) {
                    detailVo =  list_1004.get(0);
                }
                break;
            case "1005":
                List<Firefacilities_aqsscs_yjgbVO> list_1005 = firefacilitiesDAO.doFindYjgbList(xfssid);
                if (list_1005.size() > 0) {
                    detailVo =  list_1005.get(0);
                }
                break;
                //消防水系统
            case "2000":
                break;
            case "2001":
                List<Firefacilities_xfsxt_xfbfVO> list_2001 = firefacilitiesDAO.doFindXfbfList(xfssid);
                if (list_2001.size() > 0) {
                    detailVo =  list_2001.get(0);
                }
                break;
            case "2002":
                List<Firefacilities_xfsxt_xfsxVO> list_2002 = firefacilitiesDAO.doFindXfsxList(xfssid);
                if (list_2002.size() > 0) {
                    detailVo =  list_2002.get(0);
                }
                break;
            case "2003":
                List<Firefacilities_xfsxt_xfscVO> list_2003 = firefacilitiesDAO.doFindXfscList(xfssid);
                if (list_2003.size() > 0) {
                    detailVo =  list_2003.get(0);
                }
                break;
            case "2004":
                List<Firefacilities_xfsxt_snxhsVO> list_2004 = firefacilitiesDAO.doFindSnxhsList(xfssid);
                if (list_2004.size() > 0) {
                    detailVo =  list_2004.get(0);
                }
                break;
            case "2005":
                List<Firefacilities_xfsxt_swxhsVO> list_2005 = firefacilitiesDAO.doFindSwxhsList(xfssid);
                if (list_2005.size() > 0) {
                    detailVo =  list_2005.get(0);
                }
                break;
            case "2006":
                List<Firefacilities_xfsxt_sbjhqVO> list_2006 = firefacilitiesDAO.doFindSbjhqList(xfssid);
                if (list_2006.size() > 0) {
                    detailVo =  list_2006.get(0);
                }
            case "2007":
                List<Firefacilities_xfsxt_plxtVO> list_2007 = firefacilitiesDAO.doFindPlxtList(xfssid);
                if (list_2007.size() > 0) {
                    detailVo =  list_2007.get(0);
                }
                break;
            case "2008":
                List<Firefacilities_xfsxt_lqsxtVO> list_2008 = firefacilitiesDAO.doFindLqsxtList(xfssid);
                if (list_2008.size() > 0) {
                    detailVo =  list_2008.get(0);
                }
            case "2009":
                List<Firefacilities_xfsxt_gdspVO> list_2009 = firefacilitiesDAO.doFindGdspList(xfssid);
                if (list_2009.size() > 0) {
                    detailVo =  list_2009.get(0);
                }
                break;
            case "2010":
                List<Firefacilities_xfsxt_bgdssVO> list_2010 = firefacilitiesDAO.doFindBgdssList(xfssid);
                if (list_2010.size() > 0) {
                    detailVo =  list_2010.get(0);
                }
                break;
                //泡沫系统
            case "3000":
                break;
            case "3001":
                List<Firefacilities_pmxt_pmbfVO> list_3001 = firefacilitiesDAO.doFindPmbfList(xfssid);
                if (list_3001.size() > 0) {
                    detailVo =  list_3001.get(0);
                }
                break;
            case "3002":
                List<Firefacilities_pmxt_pmxhsVO> list_3002 = firefacilitiesDAO.doFindPmxhsList(xfssid);
                if (list_3002.size() > 0) {
                    detailVo =  list_3002.get(0);
                }
                break;
            case "3003":
                List<Firefacilities_pmxt_gdpmpVO> list_3003 = firefacilitiesDAO.doFindGdpmpList(xfssid);
                if (list_3003.size() > 0) {
                    detailVo =  list_3003.get(0);
                }
            case "3004":
                List<Firefacilities_pmxt_pmfsqVO> list_3004 = firefacilitiesDAO.doFindPmfsqList(xfssid);
                if (list_3004.size() > 0) {
                    detailVo =  list_3004.get(0);
                }
                break;
            case "3005":
                List<Firefacilities_pmxt_bgdssVO> list_3005 = firefacilitiesDAO.doFindPmBgdssList(xfssid);
                if (list_3005.size() > 0) {
                    detailVo =  list_3005.get(0);
                }
                break;
                //蒸汽灭火系统
            case "4000":
                break;
            case "4001":
                List<Firefacilities_zqmhxt_gdsVO> list_4001 = firefacilitiesDAO.doFindGdsList(xfssid);
                if (list_4001.size() > 0) {
                    detailVo =  list_4001.get(0);
                }
                break;
            case "4002":
                List<Firefacilities_zqmhxt_bgdsVO> list_4002 = firefacilitiesDAO.doFindBgdsList(xfssid);
                if (list_4002.size() > 0) {
                    detailVo =  list_4002.get(0);
                }
                break;
                //消防控制室
            case "5000":
                List<Firefacilities_xfkzsVO> list_5000 = firefacilitiesDAO.doFindXfkzsList(xfssid);
                if (list_5000.size() > 0) {
                    detailVo =  list_5000.get(0);
                }
                break;
                //防排烟设施
            case "6000":
                break;
            case "6001":
                List<Firefacilities_fpycs_pycykVO> list_6001 = firefacilitiesDAO.doFindPycykList(xfssid);
                if (list_6001.size() > 0) {
                    detailVo =  list_6001.get(0);
                }
                break;
            case "6002":
                List<Firefacilities_fpycs_fpyxtVO> list_6002 = firefacilitiesDAO.doFindFpyxtList(xfssid);
                if (list_6002.size() > 0) {
                    detailVo =  list_6002.get(0);
                }
                break;
                //防火分区
            case "7000":
                List<Firefacilities_fhfqVO> list_7000 = firefacilitiesDAO.doFindFhfqList(xfssid);
                if (list_7000.size() > 0) {
                    detailVo =  list_7000.get(0);
                }
                break;
                //其他灭火系统
            case "8000":
                break;
            case "8001":
                List<Firefacilities_qtmhxt_qtmhxtVO> list_8001 = firefacilitiesDAO.doFindQtmhxtList(xfssid);
                if (list_8001.size() > 0) {
                    detailVo =  list_8001.get(0);
                }
                break;
            case "8002":
                List<Firefacilities_qtmhxt_gfmhxtVO> list_8002 = firefacilitiesDAO.doFindGfmhxtList(xfssid);
                if (list_8002.size() > 0) {
                    detailVo =  list_8002.get(0);
                }
                break;
                //其他消防设施
            case "9000":
                List<Firefacilities_qtxfssVO> list_9000 = firefacilitiesDAO.doFindQtxfssList(xfssid);
                if (list_9000.size() > 0) {
                    detailVo =  list_9000.get(0);
                }
                break;
        }
        return detailVo;
    }
}