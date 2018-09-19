package com.syfri.userservice.dao;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.OrganizationTree;
import com.syfri.userservice.model.OrganizationVO;

import java.util.List;

public interface OrganizationDAO extends BaseDAO<OrganizationVO>{

	/*根据用户ID查询其组织机构.*/
	OrganizationVO doFindOrganizationByUserid(String userid);

	/*获取所有总队*/
	List<OrganizationVO> getZongdui();

	/*--根据机构id获取机构详情.--*/
	OrganizationVO doFindDetailById(String uuid);

	/*--获取全部机构.--*/
	List<OrganizationVO> doFindAllOrganization();

	/*--根据上级机构ID查询组织机构列表 by li.xue.--*/
	List<OrganizationTree> doFindJgBySjjgid(String sjjgid);
}