package com.syfri.digitalplan.service.impl.basicinfo.firestationsource;

import com.syfri.digitalplan.model.basicinfo.firestationsource.*;
import com.syfri.digitalplan.service.redis.RedisService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.basicinfo.firestationsource.XfdzDAO;
import com.syfri.digitalplan.service.basicinfo.firestationsource.XfdzService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("xfdzService")
public class XfdzServiceImpl extends BaseServiceImpl<XfdzVO> implements XfdzService {

    @Autowired
    private XfdzDAO xfdzDAO;

    @Autowired
    private RedisService redisService;

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

    /*--通过Dzid查询队站树，不带公安部消防局 by li.xue 2018/7/25.--*/
    public List<XfdzTree> doFindDzTreeByUser(XfdzVO xfdzVO) {
        List<XfdzTree> tree2s = new ArrayList<>();
        if (redisService.exists("xfdzTree2" + xfdzVO.getDzid())) {
            tree2s = (List<XfdzTree>) redisService.get("xfdzTree2" + xfdzVO.getDzid());
        }else{
            tree2s = xfdzDAO.doFindXfdzBySjdzid(xfdzVO.getDzid());
            List<XfdzTree> tree2Children = new ArrayList<>();
            for (XfdzTree tree2 : tree2s) {
                List<XfdzTree> tree3s = xfdzDAO.doFindXfdzBySjdzid(tree2.getDzid());
                List<XfdzTree> tree3Children = new ArrayList<>();
                for (XfdzTree tree3 : tree3s) {
                    List<XfdzTree> tree4s = xfdzDAO.doFindXfdzBySjdzid(tree3.getDzid());
                    List<XfdzTree> tree4Children = new ArrayList<>();
                    for (XfdzTree tree4 : tree4s) {
                        List<XfdzTree> tree5s = xfdzDAO.doFindXfdzBySjdzid(tree4.getDzid());
                        if (!tree5s.isEmpty()) {
                            tree4.setChildren(tree5s);
                        }
                        tree4Children.add(tree4);
                    }
                    if (!tree4s.isEmpty()) {
                        tree3.setChildren(tree4s);
                    }
                    tree3Children.add(tree3);
                }
                if (!tree3Children.isEmpty()) {
                    tree2.setChildren(tree3Children);
                }
                tree2Children.add(tree2);
            }
            redisService.set("xfdzTree2"+xfdzVO.getDzid(), tree2s);
        }
        return tree2s;
    }
    /*--通过Dzid查询队站树ALL(包括公安部消防局) by li.xue 2018/7/25.--*/
    public List<XfdzTree> doFindDzTreeByUserAll(XfdzVO xfdzVO) {
        List<XfdzTree> tree1s = new ArrayList<>();
        if (redisService.exists("xfdzTreeAll" + xfdzVO.getDzid())) {
            tree1s = (List<XfdzTree>) redisService.get("xfdzTreeAll" + xfdzVO.getDzid());
        }else{
            XfdzTree tree1 = new XfdzTree(xfdzVO.getDzid(), xfdzVO.getDzjc(), xfdzVO.getDzbm());
            List<XfdzTree> tree2s = xfdzDAO.doFindXfdzBySjdzid(xfdzVO.getDzid());
            List<XfdzTree> tree2Children = new ArrayList<>();
            for (XfdzTree tree2 : tree2s) {
                List<XfdzTree> tree3s = xfdzDAO.doFindXfdzBySjdzid(tree2.getDzid());
                List<XfdzTree> tree3Children = new ArrayList<>();
                for (XfdzTree tree3 : tree3s) {
                    List<XfdzTree> tree4s = xfdzDAO.doFindXfdzBySjdzid(tree3.getDzid());
                    List<XfdzTree> tree4Children = new ArrayList<>();
                    for (XfdzTree tree4 : tree4s) {
                        List<XfdzTree> tree5s = xfdzDAO.doFindXfdzBySjdzid(tree4.getDzid());
                        if (!tree5s.isEmpty()) {
                            tree4.setChildren(tree5s);
                        }
                        tree4Children.add(tree4);
                    }
                    if (!tree4s.isEmpty()) {
                        tree3.setChildren(tree4s);
                    }
                    tree3Children.add(tree3);
                }
                if (!tree3Children.isEmpty()) {
                    tree2.setChildren(tree3Children);
                }
                tree2Children.add(tree2);
            }
            if (!tree2Children.isEmpty()) {
                tree1.setChildren(tree2Children);
            }
            tree1s.add(tree1);
            redisService.set("xfdzTreeAll"+xfdzVO.getDzid(), tree1s);
        }
        return tree1s;
    }

    /*--新增消防队站 by li.xue 2018/7/25.--*/
    @Override
    public XfdzVO doInsertByXfdzVO(XfdzVO xfdzVO){
        //插入主表
        xfdzDAO.doInsertByVO(xfdzVO);
        //插入从表
        ((XfdzService) AopContext.currentProxy()).doExeInsertOrUpdate(xfdzVO);
        return xfdzVO;
    }

    /*--修改消防队站 by li.xue 2018/7/25.--*/
    @Override
    public XfdzVO doUpdateByXfdzVO(XfdzVO xfdzVO){
        XfdzVO vo = xfdzDAO.doFindById(xfdzVO.getDzid());
        //修改主表
        xfdzDAO.doUpdateByVO(xfdzVO);
        //判断队站类型是否修改
        if(!xfdzVO.getDzlx().isEmpty() && !(xfdzVO.getDzlx().equals(vo.getDzlx()))){
            //先删除原来从表
            ((XfdzService) AopContext.currentProxy()).doDeleteDetail(vo);
        }
        //修改或插入从表
        ((XfdzService) AopContext.currentProxy()).doExeInsertOrUpdate(xfdzVO);
        return xfdzVO;
    }

    /*--判断队站从表执行新增还是修改.--*/
    @Override
    public void doExeInsertOrUpdate(XfdzVO xfdzVO){
        if(!xfdzVO.getDzlx().isEmpty()){
            switch(xfdzVO.getDzlx().substring(0,2)){
                case "02":
                    ZongdVO zongdVO = xfdzVO.getZongdVO();
                    zongdVO.setDzid(xfdzVO.getDzid());
                    if(xfdzDAO.doCountZongdByDzid(xfdzVO.getDzid())>0){
                        xfdzDAO.doUpdateZongdByVO(zongdVO);
                    }else{
                        xfdzDAO.doInsertZongdByVO(zongdVO);
                    }
                    break;
                case "03":
                    ZhidVO zhidVO = xfdzVO.getZhidVO();
                    zhidVO.setDzid(xfdzVO.getDzid());
                    if(xfdzDAO.doCountZhidByDzid(xfdzVO.getDzid())>0){
                        xfdzDAO.doUpdateZhidByVO(zhidVO);
                    }else{
                        xfdzDAO.doInsertZhidByVO(zhidVO);
                    }
                    break;
                case "05":
                    DadVO dadVO = xfdzVO.getDadVO();
                    dadVO.setDzid(xfdzVO.getDzid());
                    if(xfdzDAO.doCountDadByDzid(xfdzVO.getDzid())>0){
                        xfdzDAO.doUpdateDadByVO(dadVO);
                    }else{
                        xfdzDAO.doInsertDadByVO(dadVO);
                    }
                    break;
                case "09":
                    ZhongdVO zhongdVO = xfdzVO.getZhongdVO();
                    zhongdVO.setDzid(xfdzVO.getDzid());
                    if(xfdzDAO.doCountZhongdByDzid(xfdzVO.getDzid())>0){
                        xfdzDAO.doUpdateZhongdByVO(zhongdVO);
                    }else{
                        xfdzDAO.doInsertZhongdByVO(zhongdVO);
                    }
                    break;
                case "0A":
                    QtxfdwVO qtxfdwVO = xfdzVO.getQtxfdwVO();
                    qtxfdwVO.setDzid(xfdzVO.getDzid());
                    if(xfdzDAO.doCountQtxfdwByDzid(xfdzVO.getDzid())>0){
                        xfdzDAO.doUpdateQtxfdwByVO(qtxfdwVO);
                    }else{
                        xfdzDAO.doInsertQtxfdwByVO(qtxfdwVO);
                    }
                    break;
            }
        }
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
            //删除主表
            vo.setDeleteFlag("Y");
            xfdzDAO.doUpdateByVO(vo);
            //删除从表
            ((XfdzService) AopContext.currentProxy()).doDeleteDetail(vo);
            deleteNums++;
        }
        return deleteNums;
    }

    /*--删除从表队站 by li.xue 2018/8/7.--*/
    public void doDeleteDetail(XfdzVO xfdzVO){
        if(!xfdzVO.getDzlx().isEmpty()) {
            switch (xfdzVO.getDzlx().substring(0, 2)) {
                case "02":
                    ZongdVO zongdVO = new ZongdVO();
                    zongdVO.setDzid(xfdzVO.getDzid());
                    zongdVO.setDeleteFlag("Y");
                    xfdzDAO.doDeleteZongdByDzid(zongdVO);
                    break;
                case "03":
                    ZhidVO zhidVO = new ZhidVO();
                    zhidVO.setDzid(xfdzVO.getDzid());
                    zhidVO.setDeleteFlag("Y");
                    xfdzDAO.doDeleteZhidByDzid(zhidVO);
                    break;
                case "05":
                    DadVO dadVO = new DadVO();
                    dadVO.setDzid(xfdzVO.getDzid());
                    dadVO.setDeleteFlag("Y");
                    xfdzDAO.doDeleteDadByDzid(dadVO);
                    break;
                case "09":
                    ZhongdVO zhongdVO = new ZhongdVO();
                    zhongdVO.setDzid(xfdzVO.getDzid());
                    zhongdVO.setDeleteFlag("Y");
                    xfdzDAO.doDeleteZhongdByDzid(zhongdVO);
                    break;
                case "0A":
                    QtxfdwVO qtxfdwVO = new QtxfdwVO();
                    qtxfdwVO.setDzid(xfdzVO.getDzid());
                    qtxfdwVO.setDeleteFlag("Y");
                    xfdzDAO.doDeleteQtxfdwByDzid(qtxfdwVO);
                    break;
            }
        }
    }
}