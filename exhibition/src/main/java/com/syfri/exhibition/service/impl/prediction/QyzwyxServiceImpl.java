package com.syfri.exhibition.service.impl.prediction;

import com.syfri.exhibition.model.prediction.QyjbxxVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.exhibition.dao.prediction.QyzwyxDAO;
import com.syfri.exhibition.model.prediction.QyzwyxVO;
import com.syfri.exhibition.service.prediction.QyzwyxService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qyzwyxService")
public class QyzwyxServiceImpl extends BaseServiceImpl<QyzwyxVO> implements QyzwyxService {

	@Autowired
	private QyzwyxDAO qyzwyxDAO;

	@Override
	public QyzwyxDAO getBaseDAO() {
		return qyzwyxDAO;
	}
	/*
	 * @Description:
	 * @Param:
	 * @Return:
	 * @Author: zhaijianchen
	 * @Modified By:
	 * @Date: 2018/10/9 13:53
	 */
	/*--查询：统计分析数据.--*/
	@Override
	public List<QyzwyxVO> dofindtjfx(QyzwyxVO qyzwyxVO){
		return qyzwyxDAO.dofindtjfx(qyzwyxVO);
	}




}