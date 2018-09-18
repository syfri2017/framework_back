package com.syfri.digitalplan.dao.digitalplan;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.digitalplan.model.digitalplan.DistributeVO;

import java.util.List;

public interface DistributeDAO extends BaseDAO<DistributeVO> {

	/*向组织机构预案中间表批量插入数据*/
	void doInsertDistributeVO(DistributeVO distributeVO);
	/*根据预案ID删除记录.*/
	void doDeleteByYaid(String yaid);
	/*根据预案ID查询分发的总队*/
	List<DistributeVO> doFindFfdzByYaid(String yaid);
}