package com.syfri.digitalplan.service.impl.basicinfo.firedrugsource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.basicinfo.firedrugsource.FiredrugDAO;
import com.syfri.digitalplan.model.basicinfo.firedrugsource.FiredrugVO;
import com.syfri.digitalplan.service.basicinfo.firedrugsource.FiredrugService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("firedrugService")
public class FiredrugServiceImpl extends BaseServiceImpl<FiredrugVO> implements FiredrugService {

	@Autowired
	private FiredrugDAO firedrugDAO;

	@Override
	public FiredrugDAO getBaseDAO() {
		return firedrugDAO;
	}

	/**
	 * @Description:条件查询：消防药剂
	 * @Param: [firedrugVO]
	 * @Return: java.util.List<com.syfri.digitalplan.model.basicinfo.firedrugsource.FiredrugVO>
	 * @Author: liurui
	 * @Modified By:
	 * @Date: 2018/4/20 16:55
	 */
	@Override
	public List<FiredrugVO> doFindlist(FiredrugVO firedrugVO){
		return firedrugDAO.doSearchByVO(firedrugVO);
	}

	public int doDeleteDrug(List<FiredrugVO> firedrugList) {
		int count = 0;
		if (firedrugList.size() > 0) {
			for (FiredrugVO dangerVO : firedrugList) {
				FiredrugVO vo = new FiredrugVO();
				vo.setUuid(dangerVO.getUuid());
				vo.setXgrid(dangerVO.getXgrid());
				vo.setXgrmc(dangerVO.getXgrmc());
				vo.setXgsj("1");
				vo.setDeleteFlag("Y");
				count = count + firedrugDAO.doUpdateByVO(vo);
			}
		}
		return count;
	}

	public int doUpdateDrug(FiredrugVO firedrugVO) {
		firedrugVO.setXgsj("1");
		int count = firedrugDAO.doUpdateByVO(firedrugVO);
		return count;
	}

}