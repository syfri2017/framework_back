package com.syfri.userservice.service.system;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.system.OrganizationTree;
import com.syfri.userservice.model.system.OrganizationVO;

import java.util.List;

public interface OrganizationService  extends BaseService<OrganizationVO>{

	/*根据用户ID查询其组织机构.*/
	OrganizationVO doFindOrganizationByUserid(String userid);

	/*获取所有总队*/
	List<OrganizationVO> getZongdui();

	/*--根据重点单位ID获取重点单位详情-*/
	OrganizationVO doFindDetailById(String uuid);

	/*--获取全部机构.--*/
	List<OrganizationTree> doFindAllOrganization();

	/*--根据用户获取组织机构树.--*/
	List<OrganizationTree> doFindJgTreeByUser(OrganizationVO organizationVO);
}