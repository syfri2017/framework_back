package com.syfri.digitalplan.service.impl.importantparts;

import com.syfri.digitalplan.model.buildingzoning.*;
import com.syfri.digitalplan.model.importantparts.ImportantpartsCglVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsJzlVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsZzlVO;
import com.syfri.digitalplan.utils.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.importantparts.ImportantpartsDAO;
import com.syfri.digitalplan.dao.buildingzoning.BuildingDAO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsVO;
import com.syfri.digitalplan.service.importantparts.ImportantpartsService;

import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("importantpartsService")
public class ImportantpartsServiceImpl extends BaseServiceImpl<ImportantpartsVO> implements ImportantpartsService {

	@Autowired
	private ImportantpartsDAO importantpartsDAO;
	@Autowired
	private BuildingDAO buildingDAO;

	@Override
	public ImportantpartsDAO getBaseDAO() {
		return importantpartsDAO;
	}

	/*--根据重点单位id获取建筑类重点部位详情集合.--*/
	@Override
	public List<ImportantpartsVO> doFindJzlListByZddwId(String zddwId) {
		List<ImportantpartsVO> resultList = this.importantpartsDAO.doFindJzlListByZddwId(zddwId);
		for (ImportantpartsVO vo : resultList){
			if(vo.getJzl() != null){
				WeixianjiezhiVO weixianjiezhiVO = new WeixianjiezhiVO();
				weixianjiezhiVO.setBwid(vo.getJzl().getUuid());
				List<WeixianjiezhiVO> wxjzList = this.buildingDAO.doFindWeiXianJieZhiList(weixianjiezhiVO);
				vo.getJzl().setWxjzList(wxjzList);
			}
		}
		return resultList;
	}
	/*--根据重点单位id获取装置类重点部位详情集合.--*/
	@Override
	public List<ImportantpartsVO> doFindZzlListByZddwId(String zddwId) {
		List<ImportantpartsVO> resultList = this.importantpartsDAO.doFindZzlListByZddwId(zddwId);
		return resultList;
	}
	/*--根据重点单位id获取储罐类重点部位详情集合.--*/
	@Override
	public List<ImportantpartsVO> doFindCglListByZddwId(String zddwId) {
		List<ImportantpartsVO> resultList = this.importantpartsDAO.doFindCglListByZddwId(zddwId);
		for (ImportantpartsVO vo : resultList){
			if(vo.getCgl() != null){
				ChuguanVO chuguanVO = new ChuguanVO();
				chuguanVO.setPkid(vo.getCgl().getUuid());
				List<ChuguanVO> cgList = this.buildingDAO.doFindChuGuanList(chuguanVO);
				vo.getCgl().setCgList(cgList);
			}
		}
		return resultList;
	}
	/*--根据重点单位ID查询其重点部位信息 by li.xue 2018/8/14--*/
	@Override
	public List<ImportantpartsVO> doFindZdbwListByZddwId(String zddwId){
		List<ImportantpartsVO> list = importantpartsDAO.doSearchListByVO(new ImportantpartsVO(zddwId));
		for(ImportantpartsVO vo : list){
			if(vo.getZdbwlx()!=null && !"".equals(vo.getZdbwlx())){
				switch(vo.getZdbwlx()){
					case "10":
						ImportantpartsJzlVO jzlVO = importantpartsDAO.doFindJzlByZdbwId(vo.getZdbwid()).get(0);
						//建筑使用性质
						if(jzlVO.getSyxz() != null && !"".equals(jzlVO.getSyxz())){
							List<String> syxzList = new ArrayList<>();
							syxzList.add(jzlVO.getSyxz().substring(0,1) + "0000");
							syxzList.add(jzlVO.getSyxz());
						}
						//危险介质
						List<WeixianjiezhiVO> wxjzList = importantpartsDAO.doFindWxjzByJzlId(jzlVO.getUuid());
						jzlVO.setWxjzList(wxjzList);
						vo.setJzl(jzlVO);
						break;
					case "20":
						ImportantpartsZzlVO zzlVO = importantpartsDAO.doFindZzlByZdbwId(vo.getZdbwid()).get(0);
						vo.setZzl(zzlVO);
						break;
					case "30":
						ImportantpartsCglVO cglVO = importantpartsDAO.doFindCglByZdbwId(vo.getZdbwid()).get(0);
						//储罐
						List<ChuguanVO> cgList = importantpartsDAO.doFindCgByCglId(cglVO.getUuid());
						cglVO.setCgList(cgList);
						vo.setCgl(cglVO);
						break;
				}
			}
		}
		return list;
	}

	/*--新增重点部位 by li.xue 2018/8/13*/
	public int doInsertZdbwByList(List<ImportantpartsVO> list, String zddwId, String jdh){
		int num = 0;
		for(ImportantpartsVO zdbwVO : list){
			zdbwVO.setZddwid(zddwId);
			zdbwVO.setJdh(jdh);
			importantpartsDAO.doInsertByVO(zdbwVO);
			String zdbwid = zdbwVO.getZdbwid();
			if(!StringUtils.isEmpty(zdbwVO.getZdbwlx())){
				switch(zdbwVO.getZdbwlx()){
					case "10":
						ImportantpartsJzlVO jzl = zdbwVO.getJzl();
						jzl.setZdbwid(zdbwid);
						jzl.setJdh(jdh);
						//使用性质
						if(jzl.getSyxzList().size()>0){
							jzl.setSyxz(jzl.getSyxzList().get(jzl.getSyxzList().size()-1));
						}
						importantpartsDAO.doInsertByVOJzl(jzl);
						String jzlId = jzl.getUuid();
						for(WeixianjiezhiVO wxjzVO : jzl.getWxjzList()){
							wxjzVO.setBwid(jzlId);
							wxjzVO.setJdh(jdh);
							importantpartsDAO.doInsertByVOJzlWxjz(wxjzVO);
						}
						break;
					case "20":
						ImportantpartsZzlVO zzl = zdbwVO.getZzl();
						zzl.setZdbwid(zdbwid);
						zzl.setJdh(jdh);
						importantpartsDAO.doInsertByVOZzl(zzl);
						break;
					case "30":
						ImportantpartsCglVO cgl = zdbwVO.getCgl();
						cgl.setZdbwid(zdbwid);
						cgl.setJdh(jdh);
						importantpartsDAO.doInsertByVOCgl(cgl);
						String cglId = cgl.getUuid();
						for(ChuguanVO cgVO : cgl.getCgList()){
							cgVO.setPkid(cglId);
							cgVO.setJdh(jdh);
							importantpartsDAO.doInsertByVOCglCg(cgVO);
						}
						break;
				}
			}
			num++;
		}
		return num;
	}

	/*--修改重点部位 by li.xue 2018/8/13*/
	public void doUpdateZdbwByList(List<ImportantpartsVO> list, String zddwId, String jdh){
		List<ImportantpartsVO> listOld = importantpartsDAO.doSearchListByVO(new ImportantpartsVO(zddwId));
		//先删除旧的有，新的没有的
		for(ImportantpartsVO voOld : listOld){
			Boolean flag = true;
			for(ImportantpartsVO voNew : list){
				if(voOld.getZdbwid().equals(voNew.getZdbwid()) && voNew.getZdbwid()!=null){
					flag = false;
				}
			}
			if(flag){
				//删除重点部位主表
				voOld.setDeleteFlag("Y");
				importantpartsDAO.doUpdateByVO(voOld);
				//删除从表
				((ImportantpartsService) AopContext.currentProxy()).doDeleteZdbwCongByZdbwlx(voOld);
			}
		}
		//新增或修改新重点部位
		for(ImportantpartsVO voNew : list){
			if(voNew.getZdbwid()!=null && !"".equals(voNew.getZdbwid())){

			}else{

			}
		}
	}

	/*--通过重点单位ID删除重点部位 by li.xue 2018/8/13*/
	@Override
	public int doDeleteZdbwByZddwId(String zddwId, String xgrid, String xgrmc){
		int num = 0;
		//根据重点单位ID查询重点部位
		ImportantpartsVO importantpartsVO = new ImportantpartsVO(zddwId);
		List<ImportantpartsVO> list = importantpartsDAO.doSearchListByVO(importantpartsVO);
		for(ImportantpartsVO vo : list){
			//删除重点部位主表数据
			vo.setDeleteFlag("Y");
			vo.setXgrid(xgrid);
			vo.setXgrmc(xgrmc);
			importantpartsDAO.doUpdateByVO(vo);
			//删除重点部位从表
			((ImportantpartsService) AopContext.currentProxy()).doDeleteZdbwCongByZdbwlx(vo);
			num++;
		}
		return num;
	}

	/*--根据重点部位类型删除从表及从从表  by li.xue 2018/8/14*/
	public void doDeleteZdbwCongByZdbwlx(ImportantpartsVO vo){
		if(vo.getZdbwlx() != null && !"".equals(vo.getZdbwlx())){
			switch(vo.getZdbwlx()){
				case "10":
					List<ImportantpartsJzlVO> jzlList = importantpartsDAO.doFindJzlByZdbwId(vo.getZdbwid());
					for(ImportantpartsJzlVO jzlVO : jzlList){
						importantpartsDAO.doDeleteByZdbwJzlIdJzlWxjz(jzlVO.getUuid());
					}
					importantpartsDAO.doDeleteByZdbwIdJzl(vo.getZdbwid());
					break;
				case "20":
					importantpartsDAO.doDeleteByZdbwIdZzl(vo.getZdbwid());
					break;
				case "30":
					List<ImportantpartsCglVO> cglList = importantpartsDAO.doFindCglByZdbwId(vo.getZdbwid());
					for(ImportantpartsCglVO cglVO : cglList){
						importantpartsDAO.doDeleteByZdbwCglIdCglCg(cglVO.getUuid());
					}
					importantpartsDAO.doDeleteByZdbwIdCgl(vo.getZdbwid());
					break;
			}
		}
	}
}