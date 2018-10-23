package com.syfri.userservice.model.system;

import java.io.Serializable;
import java.util.List;

public class MenuTree implements Serializable {

	private static final Long serialVersionUID = 1L;

	/*菜单ID.*/
	private String menuid;

	/*菜单URL.*/
	private String url;

	/*菜单名称.*/
	private String menuName;

	/*索引.*/
	private String index;

	/*图标.*/
	private String icon;

	/*parentId.*/
	private String parentId;

	/*子菜单.*/
	private List<MenuTree> children;

	public MenuTree() {
	}

	public MenuTree(String menuid, String url, String menuName, String icon, String parentId) {
		this.menuid = menuid;
		this.url = url;
		this.menuName = menuName;
		this.icon = icon;
		this.parentId = parentId;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<MenuTree> getChildren() {
		return children;
	}

	public void setChildren(List<MenuTree> children) {
		this.children = children;
	}
}
