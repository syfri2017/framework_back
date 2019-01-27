package com.syfri.userservice.utils;

import com.syfri.userservice.model.system.*;
import com.syfri.userservice.service.system.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取当前登录用户
 * @author li.xue  2017/12/18
 */
public class CurrentUserUtil {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private OrganizationService organizationService;

	private static CurrentUserUtil currentUserUtil;

	@PostConstruct
	public void init(){
		currentUserUtil = this;
		currentUserUtil.userService = this.userService;
		currentUserUtil.roleService = this.roleService;
		currentUserUtil.resourceService = this.resourceService;
		currentUserUtil.permissionService = this.permissionService;
		currentUserUtil.organizationService = this.organizationService;
	}

	//获取当前用户
	public static CurrentUser getCurrentUser(){
		return (CurrentUser) SecurityUtils.getSubject().getPrincipal();
	}

	//获取当前用户ID
	public static String getCurrentUserId(){
		return getCurrentUser().getUserid();
	}

	//获取当前用户名
	public static String getCurrentUserName(){
		return getCurrentUser().getUsername();
	}

	//设置当前登录用户
	public static CurrentUser setCurrentUser(AccountVO accountVO){
		CurrentUser currentUser = new CurrentUser(accountVO.getUserid(), accountVO.getUsername(), accountVO.getRealname(), accountVO.getUsertype());

		//获取deptid
		UserVO userVO = currentUserUtil.userService.doFindById(accountVO.getUserid());
		currentUser.setDeptid(null != userVO ? userVO.getDeptid() : null);

		//获取角色字符串list
		List<RoleVO> roleList = currentUserUtil.roleService.doFindRoleByUserid(accountVO.getUserid());
		currentUser.setRoles(roleList);

		//获取权限字符串list
		List<String> permissions = new ArrayList();
		List<ResourceVO> resourceList = currentUserUtil.resourceService.doFindResourceByRoleList(roleList);
		List<PermissionVO> permissionList = currentUserUtil.permissionService.doFindPermissionByResourceList(resourceList);
		for(PermissionVO permission : permissionList){
			permissions.add(permission.getPermissionname());
		}
		currentUser.setPermissions(permissions);

		//获取组织机构
		currentUser.setOrganizationVO(currentUserUtil.organizationService.doFindOrganizationByUserid(accountVO.getUserid()));

		return currentUser;
	}
}
