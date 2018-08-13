package com.syfri.digitalplan.service.impl.planobject;

import com.syfri.digitalplan.model.firefacilities.FirefacilitiesVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsJzlVO;
import com.syfri.digitalplan.model.importantparts.ImportantpartsVO;
import com.syfri.digitalplan.model.planobject.ImportantunitsBuildingVO;
import com.syfri.digitalplan.model.planobject.XiaofangliliangVO;
import com.syfri.digitalplan.service.buildingzoning.BuildingService;
import com.syfri.digitalplan.service.importantparts.ImportantpartsService;
import com.syfri.digitalplan.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.planobject.ImportantunitsDAO;
import com.syfri.digitalplan.dao.buildingzoning.BuildingDAO;
import com.syfri.digitalplan.model.planobject.ImportantunitsVO;
import com.syfri.digitalplan.model.buildingzoning.BuildingVO;
import com.syfri.digitalplan.service.planobject.ImportantunitsService;
import com.syfri.digitalplan.service.firefacilities.FirefacilitiesService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("importantunitsService")
public class ImportantunitsServiceImpl extends BaseServiceImpl<ImportantunitsVO> implements ImportantunitsService {

	@Autowired
	private ImportantunitsDAO importantunitsDAO;
	@Autowired
	private BuildingDAO buildingDAO;
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private FirefacilitiesService firefacilitiesService;
	@Autowired
	private ImportantpartsService importantpartsService;

	@Override
	public ImportantunitsDAO getBaseDAO() {
		return importantunitsDAO;
	}

	//通过重点单位 查询包含消防队伍详情
	@Override
	public List<XiaofangliliangVO> doFindXfllListByZddwId(String zddwId) {
		return this.importantunitsDAO.doFindXfllListByZddwId(zddwId);
	}

	//通过重点单位 查询包含分区详情
	@Override
	public List<BuildingVO> doFindBuildingDetailsByVo(ImportantunitsVO vo) {
		List<BuildingVO> resultList = new ArrayList<>();
		String zddwid = vo.getUuid();
		//根据重点单位id查询包含建筑id和建筑类型列表
		List<BuildingVO> list = this.buildingDAO.doFindJzidJzlxListByZddwid(zddwid);
		for(BuildingVO buildingVO : list){
			//根据建筑id和建筑类型查询建筑详情
			BuildingVO resultVO = this.buildingService.doFindFqDetailByVo(buildingVO);
			resultList.add(resultVO);
		}
		return resultList;
	}

	@Override
	public Map<String, List> doFindFireFacilitiesDetailsByVo(ImportantunitsVO vo) {
		Map<String,List> resultMap = new HashMap<String,List>();
		String zddwid = vo.getUuid();
		List<BuildingVO> list = this.buildingDAO.doFindJzidJzlxListByZddwid(zddwid);
		for(BuildingVO buildingVO : list){
			String jzid = buildingVO.getJzid();
			FirefacilitiesVO firefacilitiesVO = new FirefacilitiesVO();
			firefacilitiesVO.setJbxx_jzid(jzid);
			Map<String, List> eachMap = new HashMap<String,List>();
			eachMap = this.firefacilitiesService.doFindlist(firefacilitiesVO);
			resultMap.putAll(eachMap);
		}
		return resultMap;
	}

	/***
	 * @Description: 通过重点单位 查询包含分区详情和消防设施
	 * @Param: [vo]
	 * @Return: java.util.List<com.syfri.digitalplan.model.buildingzoning.BuildingVO>
	 * @Author: liurui
	 * @Modified By:
	 * @Date: 2018/6/5 9:55
	 */
	public List<BuildingVO> doFindBuildingDetailsAndFirefacilitiesByVo(ImportantunitsVO vo) {
		List<BuildingVO> resultList = new ArrayList<>();
		String zddwid = vo.getUuid();
			List<BuildingVO> list = this.buildingDAO.doFindJzidJzlxListByZddwid(zddwid);
			for(BuildingVO buildingVO : list){
				String jzid = buildingVO.getJzid();
				BuildingVO resultVO = this.buildingService.doFindFqDetailByVo(buildingVO);

				FirefacilitiesVO firefacilitiesVO = new FirefacilitiesVO();
				firefacilitiesVO.setJbxx_jzid(jzid);
				Map<String, List> firefacilites = this.firefacilitiesService.doFindlist(firefacilitiesVO);
				resultVO.setFirefacilites(firefacilites);
				resultList.add(resultVO);
			}
		return resultList;
	}

	/**
	 * author lxy
	 * @param vo
	 * @return
	 */
	public List<ImportantunitsVO> doSearchZddwListByVO(ImportantunitsVO vo){
		return importantunitsDAO.doSearchZddwListByVO(vo);
	}

	/*--校验重点单位名称是否存在 by li.xue 2018/8/13.--*/
	@Override
	public int doCheckName(String dwmc){
		return importantunitsDAO.doCheckName(dwmc);
	}

	/*--新增重点单位 by li.xue 2018/8/13.--*/
	@Override
	public ImportantunitsVO doInsertByVOAll(ImportantunitsVO vo){
		//重点单位主表
		importantunitsDAO.doInsertByVO(vo);
		String zddwid = vo.getUuid();
		String jdh = vo.getJdh();

		//重点单位消防力量从表
		for(XiaofangliliangVO xfllVO : vo.getXfllList()){
			xfllVO.setZddwid(zddwid);
			xfllVO.setJdh(jdh);
			importantunitsDAO.doInsertByVOXfll(xfllVO);
		}

		//重点单位建筑信息关系表从表
		for(ImportantunitsBuildingVO jzxxVO : vo.getJzxxList()){
			jzxxVO.setZddwid(zddwid);
			jzxxVO.setJdh(jdh);
			importantunitsDAO.doInsertByVOJzxx(jzxxVO);
		}

		//重点部位
		importantpartsService.doInsertZdbwByList(vo.getZdbwList(), zddwid, jdh);
		return vo;
	}

	/*--修改重点单位 by li.xue 2018/8/13.--*/
	@Override
	public ImportantunitsVO doUpdateByVOAll(ImportantunitsVO vo){
		return vo;
	}

	/*--批量删除重点单位 by li.xue 2018/8/13.--*/
	@Override
	public int doDeleteBatch(List<ImportantunitsVO> list){
		return 0;
	}

	/*--判断建筑信息从表执行新增还是修改 by li.xue 2018/8/13.--*/
	@Override
	public int doExeInsertOrUpdateJzxx(ImportantunitsVO vo){
		return 0;
	}

	/*--判断消防力量从表执行新增还是修改 by li.xue 2018/8/13.--*/
	@Override
	public int doExeInsertOrUpdateXfll(ImportantunitsVO vo){
		return 0;
	}

	/*--判断重点部位从表执行新增还是修改 by li.xue 2018/8/13.--*/
	@Override
	public int doExeInsertOrUpdateZdbw(ImportantunitsVO vo){
		return 0;
	}

	/*--判断重点部位-建筑类-危险介质从表执行新增还是修改 by li.xue 2018/8/13.--*/
	@Override
	public int doExeInsertOrUpdateZdbwJzlWxjz(ImportantunitsVO vo){
		return 0;
	}

	/*--判断重点部位-储罐类-储罐从表执行新增还是修改 by li.xue 2018/8/13.--*/
	@Override
	public int doExeInsertOrUpdateZdbwCglCg(ImportantunitsVO vo){
		return 0;
	}
}