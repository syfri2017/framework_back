package com.syfri.digitalplan.service.impl.basicinfo.firestationsource;

import com.syfri.digitalplan.model.basicinfo.firestationsource.XfdzTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.basicinfo.firestationsource.XfdzDAO;
import com.syfri.digitalplan.model.basicinfo.firestationsource.XfdzVO;
import com.syfri.digitalplan.service.basicinfo.firestationsource.XfdzService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("xfdzService")
public class XfdzServiceImpl extends BaseServiceImpl<XfdzVO> implements XfdzService {

    @Autowired
    private XfdzDAO xfdzDAO;

    @Override
    public XfdzDAO getBaseDAO() {
        return xfdzDAO;
    }

    public XfdzVO doFindDzDetailByVo(XfdzVO xfdzVO) {
        String dzlx = xfdzVO.getDzlx().substring(0, 2);
        XfdzVO vo = new XfdzVO();
        switch (dzlx) {
            case "02":
                vo = xfdzDAO.doFindDzZongDDetailByVo(xfdzVO);
                break;
            case "03":
                vo = xfdzDAO.doFindDzZhiDDetailByVo(xfdzVO);
                break;
            case "05":
                vo = xfdzDAO.doFindDzDaDDetailByVo(xfdzVO);
                break;
            case "09":
                vo = xfdzDAO.doFindDzZhongDDetailByVo(xfdzVO);
                break;
            case "0A":
                vo = xfdzDAO.doFindDzQtxfdwDetailByVo(xfdzVO);
                break;
        }

        return vo;
    }

    public List<XfdzVO> doSearchProvinceList(XfdzVO xfdzVO) {
        List<XfdzVO> vo = xfdzDAO.doSearchProvinceList(xfdzVO);
        return vo;
    }

    /*--通过Dzid查询队站树 by li.xue 2018/7/25.--*/
    public List<XfdzTree> doFindDzTreeByUser(XfdzVO xfdzVO) {
        List<XfdzTree> zongTrees = new ArrayList<>();
        XfdzTree zongTree = new XfdzTree(xfdzVO.getDzid(), xfdzVO.getDzjc());
        List<XfdzTree> zhiTrees = xfdzDAO.doFindXfdzBySjdzid(xfdzVO.getDzid());
        List<XfdzTree> zhiChildren = new ArrayList<>();
        for(XfdzTree zhiTree : zhiTrees){
            List<XfdzTree> daTrees = xfdzDAO.doFindXfdzBySjdzid(zhiTree.getDzid());
            List<XfdzTree> daChildren = new ArrayList<>();
            for(XfdzTree daTree : daTrees){
                List<XfdzTree> zhongTrees = xfdzDAO.doFindXfdzBySjdzid(daTree.getDzid());
                if(!zhongTrees.isEmpty()){
                    daTree.setChildren(zhongTrees);
                }
                daChildren.add(daTree);
            }
            if(!daChildren.isEmpty()){
                zhiTree.setChildren(daChildren);
            }
            zhiChildren.add(zhiTree);
        }
        if(!zhiChildren.isEmpty()){
            zongTree.setChildren(zhiChildren);
        }
        zongTrees.add(zongTree);
        return zongTrees;
    }

    /*--新增消防队站 by li.xue 2018/7/25.--*/
    @Override
    public XfdzVO doInsertByXfdzVO(XfdzVO xfdzVO){
        xfdzDAO.doInsertByVO(xfdzVO);
        return xfdzVO;
    }

    /*--修改消防队站 by li.xue 2018/7/25.--*/
    @Override
    public XfdzVO doUpdateByXfdzVO(XfdzVO xfdzVO){
        return xfdzVO;
    }

    /*--判断队站名称是否存在 by li.xue 2018/7/25.--*/
    @Override
    public int doCheckName(String dzmc){
        return xfdzDAO.doCheckName(dzmc);
    }

    /*--批量删除队站 by li.xue 2018/7/25*/
    @Override
    public int doDeleteBatch(List<XfdzVO> list){
        int deleteNums = 0;
        for(XfdzVO vo : list){
            vo.setDeleteFlag("Y");
            xfdzDAO.doUpdateByVO(vo);
            deleteNums++;
        }
        return deleteNums;
    }
}