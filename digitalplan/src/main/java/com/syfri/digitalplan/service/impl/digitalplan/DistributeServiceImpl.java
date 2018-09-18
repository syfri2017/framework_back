package com.syfri.digitalplan.service.impl.digitalplan;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.digitalplan.DistributeDAO;
import com.syfri.digitalplan.model.digitalplan.DistributeVO;
import com.syfri.digitalplan.service.digitalplan.DistributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("distributeService")
public class DistributeServiceImpl extends BaseServiceImpl<DistributeVO> implements DistributeService {

	@Autowired
	private DistributeDAO distributeDAO;

	@Override
	public DistributeDAO getBaseDAO() {
		return distributeDAO;
	}

	/*向组织机构预案中间表批量插入数据*/
	@Override
	public int doInsertDistributeList(List<DistributeVO> distributeList){
		//删除原来的预案分发数据
		int i = 0;
		if(distributeList!=null && distributeList.size()>0){
			distributeDAO.doDeleteByYaid(distributeList.get(0).getYaid());
			for(DistributeVO vo : distributeList){
				distributeDAO.doInsertDistributeVO(vo);
				i++;
			}
		}
		return i;
	}

	/*根据预案ID查询分发的总队*/
	@Override
	public List<DistributeVO> doFindFfdzByYaid(String yaid){
		return distributeDAO.doFindFfdzByYaid(yaid);
	}
}