package com.syfri.digitalplan.service.impl.importantparts;

import com.syfri.digitalplan.model.buildingzoning.*;
import com.syfri.digitalplan.model.importantparts.ImportantpartsCglVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsJzlVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsZzlVO;
import com.syfri.digitalplan.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.importantparts.ImportantpartsDAO;
import com.syfri.digitalplan.dao.buildingzoning.BuildingDAO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsVO;
import com.syfri.digitalplan.service.importantparts.ImportantpartsService;

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
	public int doUpdateZdbwByList(List<ImportantpartsVO> list, String zddwId, String jdh){
		int num = 0;
		return num;
	}

	/*--通过重点单位ID删除重点部位 by li.xue 2018/8/13*/
	public int doDeleteZdbwByZddwId(String zddwId){
		int num = 0;
		return num;
	}
}