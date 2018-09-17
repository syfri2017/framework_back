package com.syfri.digitalplan.service.impl.importantparts;

import com.syfri.digitalplan.model.buildingzoning.*;
import com.syfri.digitalplan.model.importantparts.ImportantpartsCglVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsJzlVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsZzlVO;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.importantparts.ImportantpartsDAO;
import com.syfri.digitalplan.dao.buildingzoning.BuildingDAO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsVO;
import com.syfri.digitalplan.service.importantparts.ImportantpartsService;
import org.springframework.util.StringUtils;

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
			if(!StringUtils.isEmpty(vo.getZdbwlx())){
				switch(vo.getZdbwlx()){
					case "10":
						List<ImportantpartsJzlVO> jzlList = importantpartsDAO.doFindJzlByZdbwId(vo.getZdbwid());
						if(jzlList.size()>0) {
							ImportantpartsJzlVO jzlVO = jzlList.get(0);
							//建筑使用性质
							if (!StringUtils.isEmpty(jzlVO.getSyxz())) {
								List<String> syxzList = new ArrayList<>();
								syxzList.add(jzlVO.getSyxz().substring(0, 1) + "000");
								syxzList.add(jzlVO.getSyxz());
								jzlVO.setSyxzList(syxzList);
							}
							//危险介质
							List<WeixianjiezhiVO> wxjzList = importantpartsDAO.doFindWxjzByJzlId(jzlVO.getUuid());
							jzlVO.setWxjzList(wxjzList);
							vo.setJzl(jzlVO);
						}
						break;
					case "20":
						List<ImportantpartsZzlVO> zzlList = importantpartsDAO.doFindZzlByZdbwId(vo.getZdbwid());
						if(zzlList.size()>0){
							vo.setZzl(zzlList.get(0));
						}
						break;
					case "30":
						List<ImportantpartsCglVO> cglList = importantpartsDAO.doFindCglByZdbwId(vo.getZdbwid());
						if(cglList.size()>0){
							ImportantpartsCglVO cglVO = cglList.get(0);
							//储罐
							List<ChuguanVO> cgList = importantpartsDAO.doFindCgByCglId(cglVO.getUuid());
							cglVO.setCgList(cgList);
							vo.setCgl(cglVO);
						}
						break;
				}
			}
		}
		return list;
	}

	/*--新增重点部位 by li.xue 2018/8/13*/
	public int doInsertZdbwByList(List<ImportantpartsVO> list, String zddwId, String jdh, String datasource){
		int num = 0;
		for(ImportantpartsVO zdbwVO : list){
			zdbwVO.setZddwid(zddwId);
			zdbwVO.setJdh(jdh);
			zdbwVO.setDatasource(datasource);
			importantpartsDAO.doInsertByVO(zdbwVO);
			String zdbwid = zdbwVO.getZdbwid();
			((ImportantpartsService) AopContext.currentProxy()).doInsertZdbwCongByVO(zdbwVO, zdbwid, jdh, datasource);
			num++;
		}
		return num;
	}

	/*--修改重点部位 by li.xue 2018/8/13*/
	public void doUpdateZdbwByList(List<ImportantpartsVO> list, String zddwId, String jdh, String datasource){
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
				((ImportantpartsService) AopContext.currentProxy()).doDeleteZdbwCongByVO(voOld);
			}
		}
		//新增或修改新重点部位
		for(ImportantpartsVO voNew : list){
			if(!StringUtils.isEmpty(voNew.getZdbwid())){
				ImportantpartsVO voOld = importantpartsDAO.doFindById(voNew.getZdbwid());
				//修改主表
				importantpartsDAO.doUpdateByVO(voNew);
				//修改从表
				if(StringUtils.isEmpty(voNew.getZdbwlx())){
					((ImportantpartsService) AopContext.currentProxy()).doDeleteZdbwCongByVO(voNew);
				}else{
					if(voNew.getZdbwlx().equals(voOld.getZdbwlx())){
						switch(voNew.getZdbwlx()){
							case "10":
								//使用性质
								if(voNew.getJzl().getSyxzList().size()>0){
									voNew.getJzl().setSyxz(voNew.getJzl().getSyxzList().get(voNew.getJzl().getSyxzList().size()-1));
								}
								if(importantpartsDAO.doCountJzlByZdbwId(voNew.getZdbwid())>0){
									importantpartsDAO.doUpdateByVOJzl(voNew.getJzl());
								}else{
									importantpartsDAO.doInsertByVOJzl(voNew.getJzl());
								}

								//危险介质
								List<WeixianjiezhiVO> wxjzOld = importantpartsDAO.doFindWxjzByJzlId(voNew.getJzl().getUuid());
								List<WeixianjiezhiVO> wxjzNew = voNew.getJzl().getWxjzList();
								//删除危险介质旧有，新没有的
								for(WeixianjiezhiVO wxjzVOOld : wxjzOld){
									Boolean wxjzFlag = true;
									for(WeixianjiezhiVO wxjzVONew : wxjzNew){
										if(wxjzVOOld.getUuid().equals(wxjzVONew.getUuid()) && !StringUtils.isEmpty(wxjzVONew.getUuid())){
											wxjzFlag = false;
										}
									}
									if(wxjzFlag){
										importantpartsDAO.doDeleteWxjzById(wxjzVOOld.getUuid());
									}
								}
								for(WeixianjiezhiVO wxjzVONew : wxjzNew){
									if(StringUtils.isEmpty(wxjzVONew.getUuid())){
										wxjzVONew.setBwid(voNew.getJzl().getUuid());
										wxjzVONew.setJdh(jdh);
										wxjzVONew.setDatasource(datasource);
										importantpartsDAO.doInsertByVOJzlWxjz(wxjzVONew);
									}else{
										importantpartsDAO.doUpdateByVOJzlWxjz(wxjzVONew);
									}
								}
								break;
							case "20":
								if(importantpartsDAO.doCountZzlByZdbwId(voNew.getZdbwid())>0){
									importantpartsDAO.doUpdateByVOZzl(voNew.getZzl());
								}else{
									importantpartsDAO.doInsertByVOZzl(voNew.getZzl());
								}
								break;
							case "30":
								if(importantpartsDAO.doCountCglByZdbwId(voNew.getZdbwid())>0){
									importantpartsDAO.doUpdateByVOCgl(voNew.getCgl());
								}else{
									importantpartsDAO.doInsertByVOCgl(voNew.getCgl());
								}

								//储罐
								List<ChuguanVO> cgOld = importantpartsDAO.doFindCgByCglId(voNew.getCgl().getUuid());
								List<ChuguanVO> cgNew = voNew.getCgl().getCgList();
								for(ChuguanVO cgVOOld : cgOld){
									Boolean cgFlag = true;
									for(ChuguanVO cgVONew : cgNew){
										if(cgVOOld.getUuid().equals(cgVONew.getUuid()) && !StringUtils.isEmpty(cgVONew.getUuid())){
											cgFlag = false;
										}
									}
									if(cgFlag){
										importantpartsDAO.doDeleteCgById(cgVOOld.getUuid());
									}
								}
								for(ChuguanVO cgVONew : cgNew){
									if(StringUtils.isEmpty(cgVONew.getUuid())){
										cgVONew.setPkid(voNew.getCgl().getUuid());
										cgVONew.setJdh(jdh);
										cgVONew.setDatasource(datasource);
										importantpartsDAO.doInsertByVOCglCg(cgVONew);
									}else{
										importantpartsDAO.doUpdateByVOCglCg(cgVONew);
									}
								}
								break;
						}
					}else{
						//删除旧类型重点部位从表
						((ImportantpartsService) AopContext.currentProxy()).doDeleteZdbwCongByVO(voOld);
						//新增新类型重点部位从表
						((ImportantpartsService) AopContext.currentProxy()).doInsertZdbwCongByVO(voNew, voNew.getZdbwid(), jdh, datasource);
					}
				}
			}else{
				List<ImportantpartsVO> listNew = new ArrayList<>();
				listNew.add(voNew);
				((ImportantpartsService) AopContext.currentProxy()).doInsertZdbwByList(listNew, zddwId, jdh, datasource);
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
			((ImportantpartsService) AopContext.currentProxy()).doDeleteZdbwCongByVO(vo);
			num++;
		}
		return num;
	}

	/*--根据不同重点部位类型删除从表及从从表  by li.xue 2018/8/14*/
	public void doDeleteZdbwCongByVO(ImportantpartsVO vo){
		if(!StringUtils.isEmpty(vo.getZdbwlx())){
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

	/*--根据重点部位类型新增从表及从从表  by li.xue 2018/8/15*/
	public void doInsertZdbwCongByVO(ImportantpartsVO zdbwVO, String zdbwid, String jdh, String datasource){
		if(!StringUtils.isEmpty(zdbwVO.getZdbwlx())){
			switch(zdbwVO.getZdbwlx()){
				case "10":
					ImportantpartsJzlVO jzl = zdbwVO.getJzl();
					jzl.setZdbwid(zdbwid);
					jzl.setJdh(jdh);
					jzl.setDatasource(datasource);
					//使用性质
					if(jzl.getSyxzList().size()>0){
						jzl.setSyxz(jzl.getSyxzList().get(jzl.getSyxzList().size()-1));
					}
					importantpartsDAO.doInsertByVOJzl(jzl);
					String jzlId = jzl.getUuid();
					for(WeixianjiezhiVO wxjzVO : jzl.getWxjzList()){
						wxjzVO.setBwid(jzlId);
						wxjzVO.setJdh(jdh);
						wxjzVO.setDatasource(datasource);
						importantpartsDAO.doInsertByVOJzlWxjz(wxjzVO);
					}
					break;
				case "20":
					ImportantpartsZzlVO zzl = zdbwVO.getZzl();
					zzl.setZdbwid(zdbwid);
					zzl.setJdh(jdh);
					zzl.setDatasource(datasource);
					importantpartsDAO.doInsertByVOZzl(zzl);
					break;
				case "30":
					ImportantpartsCglVO cgl = zdbwVO.getCgl();
					cgl.setZdbwid(zdbwid);
					cgl.setJdh(jdh);
					cgl.setDatasource(datasource);
					importantpartsDAO.doInsertByVOCgl(cgl);
					String cglId = cgl.getUuid();
					for(ChuguanVO cgVO : cgl.getCgList()){
						cgVO.setPkid(cglId);
						cgVO.setJdh(jdh);
						cgVO.setDatasource(datasource);
						importantpartsDAO.doInsertByVOCglCg(cgVO);
					}
					break;
			}
		}
	}
}