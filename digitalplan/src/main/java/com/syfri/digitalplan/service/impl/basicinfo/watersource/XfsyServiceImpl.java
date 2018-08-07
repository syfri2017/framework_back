package com.syfri.digitalplan.service.impl.basicinfo.watersource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.basicinfo.watersource.XfsyDAO;
import com.syfri.digitalplan.model.basicinfo.watersource.XfsyVO;
import com.syfri.digitalplan.service.basicinfo.watersource.XfsyService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("xfsyService")
public class XfsyServiceImpl extends BaseServiceImpl<XfsyVO> implements XfsyService {

	@Autowired
	private XfsyDAO xfsyDAO;

	@Override
	public XfsyDAO getBaseDAO() {
		return xfsyDAO;
	}

	@Override
	public XfsyVO doFindSyAndSxByVo(XfsyVO xfsyVO) {
		String sylx = xfsyVO.getSylx();
		XfsyVO vo = new XfsyVO();
		switch (sylx){
			case "01":
				vo = xfsyDAO.doFindSyAndXHSByVo(xfsyVO);
				break;
			case "02":
				vo = xfsyDAO.doFindSyAndXFSHByVo(xfsyVO);
				break;
			case "03":
				vo = xfsyDAO.doFindSyAndXFSCByVo(xfsyVO);
				break;
			case "04":
				vo = xfsyDAO.doFindSyAndTrsyqsdByVo(xfsyVO);
				break;
			default:
				vo = xfsyDAO.doFindSyAndSxByVo(xfsyVO);
		}
		return vo;
	}
	@Override
	public List doFindListByVO(XfsyVO xfsyVO) {
		String sylx = xfsyVO.getSylx();
		List<XfsyVO> list = new ArrayList<XfsyVO>();
		if(sylx == null || sylx == "")
			list = xfsyDAO.doFindListByVO(xfsyVO);
		else {
			switch (sylx){
				case "01":
					list = xfsyDAO.doFindXhsListByVO(xfsyVO);
					break;
				case "02":
					list = xfsyDAO.doFindXfshListByVO(xfsyVO);
					break;
				case "03":
					list = xfsyDAO.doFindXfscListByVO(xfsyVO);
					break;
				case "04":
					list = xfsyDAO.doFindTrsyqsdListByVO(xfsyVO);
					break;
				default:
					list = xfsyDAO.doFindListByVO(xfsyVO);
					break;
			}
		}

		return list;
	}

	//插入水源 by yushch 20180802
	@Override
	public XfsyVO doInsertByXfdzVO(XfsyVO xfsyVO) {
		if(!xfsyVO.getSylx().isEmpty()){
			switch (xfsyVO.getSylx()){
				case "01":
					xfsyDAO.doInsertXhsByVo(xfsyVO);
					xfsyVO.setSysxxxid(xfsyVO.getXhs_uuid());
					break;
			}
		}
		xfsyDAO.doInsertByVO(xfsyVO);
		return xfsyVO;
	}

	/*--修改消防水源 by yushch 20180803.--*/
	@Override
	public XfsyVO doUpdateByXfsyVO(XfsyVO xfsyVO){
		if(!xfsyVO.getSylx().isEmpty()){
			String sysxxxid = xfsyVO.getSysxxxid();
			switch(xfsyVO.getSylx()) {
				case "01":
					int count = xfsyDAO.doCountXhsBySxid(sysxxxid);
					if (count > 0)
						xfsyDAO.doUpdateXhsByVo(xfsyVO);
					else{
						String temp_id = getUUID();
						xfsyVO.setXhs_uuid(temp_id);
						xfsyVO.setSysxxxid(temp_id);
						xfsyDAO.doInsertXhsByVo(xfsyVO);
					}
					break;
				case "02":

					break;
				case "03":

					break;
				case "04":

					break;
			}
		}
		xfsyDAO.doUpdateByVO(xfsyVO);
		return xfsyVO;
	}

	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr=str.replace("-", "");
		return uuidStr;
	}

	//批量删除 by yushch 20180803
	/*--批量删除队站 by li.xue 2018/7/25*/
	@Override
	public int doDeleteBatch(List<XfsyVO> list){
		int deleteNums = 0;
		for(XfsyVO vo : list){
			//删除主表
			vo.setDeleteFlag("Y");
			xfsyDAO.doUpdateByVO(vo);
			//删除从表
			if(!vo.getSylx().isEmpty()){
				switch(vo.getSylx()){
					case "01":
						String uuid = vo.getSysxxxid();
						xfsyDAO.doDeleteXhsByUuid(uuid);
						break;
					case "02":

						break;
					case "03":

						break;
					case "04":

						break;
				}
			}
			deleteNums++;
		}
		return deleteNums;
	}

}