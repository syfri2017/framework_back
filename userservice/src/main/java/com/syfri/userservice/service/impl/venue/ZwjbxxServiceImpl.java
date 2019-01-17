package com.syfri.userservice.service.impl.venue;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.venue.ZwjbxxDAO;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.service.venue.ZwjbxxService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("zwjbxxService")
public class ZwjbxxServiceImpl extends BaseServiceImpl<ZwjbxxVO> implements ZwjbxxService {

	@Autowired
	private ZwjbxxDAO zwjbxxDAO;

	@Override
	public ZwjbxxDAO getBaseDAO() {
		return zwjbxxDAO;
	}
	@Override
	public PageInfo<ZwjbxxVO> doSearchQyPage(ZwjbxxVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<ZwjbxxVO> list = zwjbxxDAO.doSearchListQyByVO(vo);
		PageInfo<ZwjbxxVO> page = new PageInfo<ZwjbxxVO>(list);
		return page;
	}

	public List doSearchListQyByVO(ZwjbxxVO vo) {
		return zwjbxxDAO.doSearchListQyByVO(vo);
	}

	/*--企业选择的展位数量从大到小进行排序  by li.xue 2018/12/29.--*/
	@Override
	public List<ZwjbxxVO> doFindQyZwNumDesc(ZwjbxxVO zwjbxxVO){
		return zwjbxxDAO.doFindQyZwNumDesc(zwjbxxVO);
	}
	//查询企业选择的展位list及价格信息 add by yushch 20190116
	@Override
	public List<ZwjbxxVO> doFindZwAndJgByVo(ZwjbxxVO zwjbxxVO){
		if(zwjbxxVO.getZwlb().equals("标准展位")){
			//查询企业选择的标准展位及价格信息
			return zwjbxxDAO.doFindBzzwAndJgByVo(zwjbxxVO);
		}else{
			//查询企业选择的室内光地展位及价格信息
			List<ZwjbxxVO> list = zwjbxxDAO.doFindSngdzwAndJgByVo(zwjbxxVO);
			//查询企业选择的OD展位及价格信息
			list.addAll(zwjbxxDAO.doFindOdAndJgByVo(zwjbxxVO));
			return list;
		}

	}
}