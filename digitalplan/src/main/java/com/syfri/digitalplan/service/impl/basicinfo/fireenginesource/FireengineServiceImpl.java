package com.syfri.digitalplan.service.impl.basicinfo.fireenginesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.basicinfo.fireenginesource.FireengineDAO;
import com.syfri.digitalplan.model.basicinfo.fireenginesource.FireengineVO;
import com.syfri.digitalplan.service.basicinfo.fireenginesource.FireengineService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("fireengineService")
public class FireengineServiceImpl extends BaseServiceImpl<FireengineVO> implements FireengineService {

	@Autowired
	private FireengineDAO fireengineDAO;

	@Override
	public FireengineDAO getBaseDAO() {
		return fireengineDAO;
	}
	/***
	 * @Description: 删除：车辆信息
	 * @Param: [voList]
	 * @Return: java.util.List<com.syfri.digitalplan.model.basicinfo.fireenginesource.FireengineVO>
	 * @Author: zhaijianchen
	 * @Modified By:
	 * @Date: 2018/7/24 09:10
	 */
	public int doDeleteFireengine(List<FireengineVO> fireengineList) {
		int count = 0;
		if (fireengineList.size() > 0) {
			for (FireengineVO fireengineVO : fireengineList) {
				FireengineVO vo = new FireengineVO();
				vo.setUuid(fireengineVO.getUuid());
				vo.setXgrid(fireengineVO.getXgrid());
				vo.setXgrmc(fireengineVO.getXgrmc());
				vo.setXgsj("1");
				vo.setDeleteFlag("Y");
				count = count + fireengineDAO.doUpdateByVO(vo);
			}
		}
		return count;
	}

	/**
	 * @Description: 车辆信息修改
	 * @Param: [fireengineVO]
	 * @Return: int
	 * @Author: zhaijianchen
	 * @Modified By:
	 * @Date: 2018/7/25 12:30
	 */
	public int doUpdateFireengine(FireengineVO fireengineVO) {
		fireengineVO.setXgsj("1");
		int count = fireengineDAO.doUpdateByVO(fireengineVO);
		return count;
	}





}