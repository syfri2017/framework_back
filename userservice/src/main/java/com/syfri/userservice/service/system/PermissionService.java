package com.syfri.userservice.service.system;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.system.PermissionVO;
import com.syfri.userservice.model.system.ResourceVO;

import java.util.List;

public interface PermissionService  extends BaseService<PermissionVO>{

	/*--根据资源列表获取权限列表.--*/
	List<PermissionVO> doFindPermissionByResourceList(List<ResourceVO> resourceList);

	/*--根据资源ID获取权限列表.--*/
	List<PermissionVO> doFindPermissionByResourceId(String resourceid);

	/*--新增；权限.--*/
	PermissionVO doInsertPermission(PermissionVO permissionVO);

	/*--修改：权限.--*/
	PermissionVO doUpdatePermission(PermissionVO permissionVO);

	/*--删除：权限.--*/
	int doDeletePermissions(List<PermissionVO> list);

	/*--获取所有的权限.--*/
	List<PermissionVO> doFindAll();
}