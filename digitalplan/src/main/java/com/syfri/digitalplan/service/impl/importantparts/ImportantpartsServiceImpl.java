package com.syfri.digitalplan.service.impl.importantparts;

import com.syfri.digitalplan.model.buildingzoning.*;
import com.syfri.digitalplan.model.importantparts.ImportantpartsCglVO;
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
}