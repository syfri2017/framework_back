package com.syfri.exhibition.service.impl.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.exhibition.dao.prediction.QyjbxxDAO;
import com.syfri.exhibition.model.prediction.QyjbxxVO;
import com.syfri.exhibition.service.prediction.QyjbxxService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qyjbxxService")
public class QyjbxxServiceImpl extends BaseServiceImpl<QyjbxxVO> implements QyjbxxService {

	@Autowired
	private QyjbxxDAO qyjbxxDAO;

	@Override
	public QyjbxxDAO getBaseDAO() {
		return qyjbxxDAO;
	}

	/*--通过用户、企业查询展商信息 by li.xue 2018/10/0 11:13.--*/
	@Override
	public List<QyjbxxVO> doFindZsxxByQyjbxx(QyjbxxVO qyjbxxVO){
		return qyjbxxDAO.doFindZsxxByQyjbxx(qyjbxxVO);
	}
}