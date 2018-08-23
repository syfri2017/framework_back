package com.syfri.digitalplan.service.impl.basicinfo.watersource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.basicinfo.watersource.XfsyDAO;
import com.syfri.digitalplan.model.basicinfo.watersource.XfsyVO;
import com.syfri.digitalplan.service.basicinfo.watersource.XfsyService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("xfsyService")
public class XfsyServiceImpl extends BaseServiceImpl<XfsyVO> implements XfsyService {

    @Autowired
    private XfsyDAO xfsyDAO;

    @Override
    public XfsyDAO getBaseDAO() {
        return xfsyDAO;
    }

    @Override
    public XfsyVO doFindSyAndSxByVo(XfsyVO xfsyVO) {
        String sylx = xfsyVO.getSylx();
        XfsyVO vo = new XfsyVO();
        switch (sylx) {
            case "01":
                vo = xfsyDAO.doFindSyAndXHSByVo(xfsyVO);
                break;
            case "02":
                vo = xfsyDAO.doFindSyAndXFSHByVo(xfsyVO);
                break;
            case "03":
                vo = xfsyDAO.doFindSyAndXFSCByVo(xfsyVO);
                break;
            case "04":
                vo = xfsyDAO.doFindSyAndTrsyqsdByVo(xfsyVO);
                break;
            default:
                vo = xfsyDAO.doFindSyAndSxByVo(xfsyVO);
        }
        return vo;
    }

    @Override
    public List doFindListByVO(XfsyVO xfsyVO) {
        String sylx = xfsyVO.getSylx();
        List<XfsyVO> list = new ArrayList<XfsyVO>();
        if (sylx == null || sylx == "")
            list = xfsyDAO.doFindListByVO(xfsyVO);
        else {
            switch (sylx) {
                case "01":
                    list = xfsyDAO.doFindXhsListByVO(xfsyVO);
                    break;
                case "02":
                    list = xfsyDAO.doFindXfshListByVO(xfsyVO);
                    break;
                case "03":
                    list = xfsyDAO.doFindXfscListByVO(xfsyVO);
                    break;
                case "04":
                    list = xfsyDAO.doFindTrsyqsdListByVO(xfsyVO);
                    break;
                default:
                    list = xfsyDAO.doFindListByVO(xfsyVO);
                    break;
            }
        }

        return list;
    }

    public List<XfsyVO> doFindTrsyListByVO(XfsyVO xfsyVO) {
        return xfsyDAO.doFindTrsyListByVO(xfsyVO);
    }

    //插入水源 by yushch 20180802
    @Override
    public XfsyVO doInsertByXfdzVO(XfsyVO xfsyVO) {
        if (!xfsyVO.getSylx().isEmpty()) {
            switch (xfsyVO.getSylx()) {
                case "01":
                    xfsyDAO.doInsertXhsByVo(xfsyVO);
                    xfsyVO.setSysxxxid(xfsyVO.getXhs_uuid());
                    break;
                case "02":
                    xfsyDAO.doInsertXfshByVO(xfsyVO);
                    xfsyVO.setSysxxxid(xfsyVO.getXfsh_uuid());
                    break;
                case "03":
                    xfsyDAO.doInsertXfscByVO(xfsyVO);
                    xfsyVO.setSysxxxid(xfsyVO.getXfsc_uuid());
                    break;
                case "04":
                    xfsyDAO.doInsertTrsyqsdByVO(xfsyVO);
                    xfsyVO.setSysxxxid(xfsyVO.getTrsyqsd_uuid());
                    break;
            }
        }
        xfsyDAO.doInsertByVO(xfsyVO);
        return xfsyVO;
    }

    /*--修改消防水源 by yushch 20180803.--*/
    @Override
    public XfsyVO doUpdateByXfsyVO(XfsyVO xfsyVO) {
        XfsyVO oldVO = xfsyDAO.doFindById(xfsyVO.getUuid());
        if (oldVO.getSylx().equals(xfsyVO.getSylx())) { //水源类型未改变
            if (!xfsyVO.getSylx().isEmpty()) {
                String sysxxxid = xfsyVO.getSysxxxid();
                int count = 0;
                switch (xfsyVO.getSylx()) {
                    case "01":
                        count = xfsyDAO.doCountXhsBySxid(sysxxxid);
                        if (count > 0)
                            xfsyDAO.doUpdateXhsByVo(xfsyVO);
                        else {
                            xfsyDAO.doInsertXhsByVo(xfsyVO);
                            xfsyVO.setSysxxxid(xfsyVO.getXhs_uuid());
                        }
                        break;
                    case "02":
                        count = xfsyDAO.doCountXfshBySxid(sysxxxid);
                        if (count > 0)
                            xfsyDAO.doUpdateXfshByVO(xfsyVO);
                        else {
                            xfsyDAO.doInsertXfshByVO(xfsyVO);
                            xfsyVO.setSysxxxid(xfsyVO.getXfsh_uuid());
                        }
                        break;
                    case "03":
                        count = xfsyDAO.doCountXfscBySxid(sysxxxid);
                        if (count > 0)
                            xfsyDAO.doUpdateXfscByVO(xfsyVO);
                        else {
                            xfsyDAO.doInsertXfscByVO(xfsyVO);
                            xfsyVO.setSysxxxid(xfsyVO.getXfsc_uuid());
                        }
                        break;
                    case "04":
                        count = xfsyDAO.doCountXhsBySxid(sysxxxid);
                        if (count > 0)
                            xfsyDAO.doUpdateXhsByVo(xfsyVO);
                        else {
                            xfsyDAO.doInsertTrsyqsdByVO(xfsyVO);
                            xfsyVO.setSysxxxid(xfsyVO.getTrsyqsd_uuid());
                        }
                        break;
                }
            }
        } else {
            if (!oldVO.getSylx().isEmpty()) {
                String uuid = oldVO.getSysxxxid();
                if (!oldVO.getSylx().isEmpty()) {
                    switch (oldVO.getSylx()) {
                        case "01":
                            xfsyDAO.doDeleteXhsByUuid(uuid);
                            break;
                        case "02":
                            xfsyDAO.doDeleteXfshByUuid(uuid);
                            break;
                        case "03":
                            xfsyDAO.doDeleteXfscByUuid(uuid);
                            break;
                        case "04":
                            xfsyDAO.doDeleteTrsyqsdByUuid(uuid);
                            break;
                    }
                }
                if (!xfsyVO.getSylx().isEmpty()) {
                    switch (xfsyVO.getSylx()) {
                        case "01":
                            xfsyDAO.doInsertXhsByVo(xfsyVO);
                            xfsyVO.setSysxxxid(xfsyVO.getXhs_uuid());
                            break;
                        case "02":
                            xfsyDAO.doInsertXfshByVO(xfsyVO);
                            xfsyVO.setSysxxxid(xfsyVO.getXfsh_uuid());
                            break;
                        case "03":
                            xfsyDAO.doInsertXfscByVO(xfsyVO);
                            xfsyVO.setSysxxxid(xfsyVO.getXfsc_uuid());
                            break;
                        case "04":
                            xfsyDAO.doInsertTrsyqsdByVO(xfsyVO);
                            xfsyVO.setSysxxxid(xfsyVO.getTrsyqsd_uuid());
                            break;
                    }
                }
            }
        }
        xfsyDAO.doUpdateByVO(xfsyVO);
        return xfsyVO;
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }

    //批量删除 by yushch 20180803
    @Override
    public int doDeleteBatch(List<XfsyVO> list) {
        int deleteNums = 0;
        for (XfsyVO vo : list) {
            //删除主表
            vo.setDeleteFlag("Y");
            xfsyDAO.doUpdateByVO(vo);
            String uuid = vo.getSysxxxid();
            //删除从表
            if (!vo.getSylx().isEmpty()) {
                switch (vo.getSylx()) {
                    case "01":
                        xfsyDAO.doDeleteXhsByUuid(uuid);
                        break;
                    case "02":
                        xfsyDAO.doDeleteXfshByUuid(uuid);
                        break;
                    case "03":
                        xfsyDAO.doDeleteXfscByUuid(uuid);
                        break;
                    case "04":
                        xfsyDAO.doDeleteTrsyqsdByUuid(uuid);
                        break;
                }
            }
            deleteNums++;
        }
        return deleteNums;
    }

    public XfsyVO insertTrsyByXfsyVO(XfsyVO xfsyVO) {
        xfsyDAO.doInsertTrsyByVO(xfsyVO);
        return xfsyVO;
    }

    public XfsyVO doUpdateTrsyByVO(XfsyVO xfsyVO) {
        xfsyDAO.doUpdateTrsyByVO(xfsyVO);
        return xfsyVO;
    }

    public XfsyVO doFindTrsyByUUId(XfsyVO xfsyVO) {
        String uuid = xfsyVO.getTrsy_uuid();
        return xfsyDAO.doFindTrsyByUUId(uuid);
    }

    public int doDeleteTrsyByUUId(List<XfsyVO> list) {
        int count = 0;
        for (XfsyVO vo : list) {
            vo.setTrsy_deleteFlag("Y");
            count = count + xfsyDAO.doUpdateTrsyByVO(vo);
        }
        return count;
    }
}