package com.syfri.digitalplan.service.digitalplan;


import com.syfri.baseapi.service.BaseService;
import com.syfri.digitalplan.model.digitalplan.DistributeVO;

import java.util.List;

public interface DistributeService  extends BaseService<DistributeVO> {

	/*向组织机构预案中间表批量插入数据*/
	int doInsertDistributeList(List<DistributeVO> distributeList);

	/*根据预案ID查询分发的总队*/
	List<DistributeVO> doFindFfdzByYaid(String yaid);
}