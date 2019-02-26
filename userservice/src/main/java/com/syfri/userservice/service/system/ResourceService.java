package com.syfri.userservice.service.system;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.system.*;

import java.util.List;

public interface ResourceService  extends BaseService<com.syfri.userservice.model.system.ResourceVO>{

	/*--根据用户角色列表查询查询用户资源.--*/
	List<ResourceVO> doFindResourceByRoleList(List<RoleVO> roleList);

	/*--查询：获取资源权限，如果resourceVO为null，则获取所有资源.--*/
	List<ResourceVO> doFindResourcePermissions(ResourceVO resourceVO);

	/*--新增：增加资源并为用户赋予权限.--*/
	ResourceVO doInsertResourcePermissions(ResourceVO resourceVO);

	/*--修改：修改资源并修改资源权限.--*/
	ResourceVO doUpdateResourcePermissions(ResourceVO resourceVO);

	/*--删除：删除资源同时删除其权限.--*/
	void doDeleteResourcePermissions(String resourceid);

	/*--向角色资源中间表中批量增加数据.--*/
	int insertResourcePermissionsBatch(String resourceid, List<PermissionVO> permissions,String userId,String userName);

	/*--根据角色列表构造资源树状结构.--*/
	List<ResourceTree> getMenuTree(List<RoleVO> roleList);

	/*--将ResourceVO对象转换成ResourceTree对象.--*/
	ResourceTree getResourceToTree(ResourceVO resourceVO);

	/*--根据角色ID获取树状资源.--*/
	List<ResourceTree> doFindResourceTree(String roleid);

	/*--根据角色ID获取其没有子的角色.--*/
	List<String> doFindChildren(String roleid);

	/*--根据父节点ID查询最大序号.--*/
	String getMaxSegno(String parentid);
}