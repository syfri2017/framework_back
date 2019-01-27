package com.syfri.userservice.model.system;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义当前登录用户
 */
public class CurrentUser implements Serializable{

	private static final long serialVersionUID = 1L;

	/*用户id.*/
	private String userid;

	/*用户名.*/
	private String username;

	/*用户类型.*/
	private String usertype;

	/*真实姓名.*/
	private String realname;

	/*用户类型*/
	private String deptid;

	/*角色.*/
	private List<RoleVO> roles;

	/*权限.*/
	private List<String> permissions;

	/*组织机构*/
	private OrganizationVO organizationVO;

	public CurrentUser() {
	}

	public CurrentUser(String userid, String username) {
		this.userid = userid;
		this.username = username;
	}

	public CurrentUser(String userid, String username, String realname, String usertype) {
		this.userid = userid;
		this.username = username;
		this.realname = realname;
		this.usertype = usertype;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public List<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	public OrganizationVO getOrganizationVO() {
		return organizationVO;
	}

	public void setOrganizationVO(OrganizationVO organizationVO) {
		this.organizationVO = organizationVO;
	}
}
