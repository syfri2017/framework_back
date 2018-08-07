package com.syfri.digitalplan.service.impl.buildingzoning;

import com.syfri.digitalplan.model.buildingzoning.ChuguanVO;
import com.syfri.digitalplan.model.buildingzoning.WeixianjiezhiVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.buildingzoning.BuildingDAO;
import com.syfri.digitalplan.model.buildingzoning.BuildingVO;
import com.syfri.digitalplan.service.buildingzoning.BuildingService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("buildingService")
public class BuildingServiceImpl extends BaseServiceImpl<BuildingVO> implements BuildingService {

    @Autowired
    private BuildingDAO buildingDAO;

    @Override
    public BuildingDAO getBaseDAO() {
        return buildingDAO;
    }

    @Override
    public BuildingVO doFindFqDetailByVo(BuildingVO buildingVO) {
        String fqlx = buildingVO.getJzlx();
        BuildingVO vo = new BuildingVO();
        switch (fqlx) {
            case "10":
            case "20":
                //分区类型为10和20 查找建筑分区详情关联建筑分区-建筑类
                vo = buildingDAO.doFindFqAndJzDetailByVo(buildingVO);
                break;
            case "30":
                //查找建筑分区详情关联建筑分区-装置类
                vo = buildingDAO.doFindFqAndZzDetailByVo(buildingVO);
                break;
            case "40":
                //查找建筑分区详情关联建筑分区-储罐类
                vo = buildingDAO.doFindFqAndCgDetailByVo(buildingVO);
                ChuguanVO chuguanVO = new ChuguanVO();
                chuguanVO.setPkid(vo.getJzid());
                List<ChuguanVO> chuguanList = this.buildingDAO.doFindChuGuanList(chuguanVO);
                vo.setChuguanList(chuguanList);
                break;
            default:
                break;
        }
        return vo;
    }

    //delete
    public int doDeleteBuildingzoning(BuildingVO buildingVO) {
        int count = 0;
        String jzlx = buildingVO.getJzlx();
        String jzid = buildingVO.getJzid();
        //删除从表
        if (!jzlx.isEmpty()) {
            switch (jzlx) {
                case "10":
                case "20":
                    count = count + buildingDAO.doDeleteJzlById(jzid);
                    break;
                case "30":
                    count = count + buildingDAO.doDeleteZzlById(jzid);
                    break;
                case "40":
                    count = count + buildingDAO.doDeleteCglById(jzid);
                    break;
            }
        }
        return count;
    }
//add
    public BuildingVO doInsertDetailByVO(BuildingVO buildingVO) {
        String jzid = buildingVO.getJzid();
        String jzlx = buildingVO.getJzlx();
        BuildingVO detailVO = buildingVO.getBuildingVO();
        detailVO.setJzid(jzid);
        detailVO.setJdh(buildingVO.getJdh());
        switch (jzlx) {
            case "10":
            case "20":

                buildingDAO.doInsertJzlByVO(detailVO);
                break;
            case "30":
                buildingDAO.doInsertZzlByVO(detailVO);
                break;
            case "40":
                buildingDAO.doInsertCglByVO(detailVO);
                break;
        }
        return detailVO;
    }

    public BuildingVO doUpdateBuildingzoning(BuildingVO buildingVO) {
        String jzid = buildingVO.getJzid();
        String jzlx = buildingVO.getJzlx();
        BuildingVO oldVO = buildingDAO.doFindById(jzid);
        BuildingVO detailVO = buildingVO.getBuildingVO();
        detailVO.setJzid(jzid);
        if (!oldVO.getJzlx().equals(jzlx)) {
            this.doDeleteBuildingzoning(oldVO);
            this.doInsertDetailByVO(buildingVO);
        } else {
            switch (jzlx) {
                case "10":
                case "20":
                    //分区类型为10和20 查找建筑分区详情关联建筑分区-建筑类
                    buildingDAO.doUpdateJzlByVO(detailVO);
                    break;
                case "30":
                    //查找建筑分区详情关联建筑分区-装置类
                    buildingDAO.doUpdateZzlByVO(detailVO);
                    break;
                case "40":
                    //查找建筑分区详情关联建筑分区-储罐类
                    buildingDAO.doUpdateCglByVO(detailVO);
                    break;
            }
        }
        return buildingVO;
    }

}