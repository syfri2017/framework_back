package com.syfri.userservice.model.system;

import java.io.Serializable;
import java.util.List;

public class ResourceTree implements Serializable{

	private static final Long serialVersionUID = 1L;

	/*主键.*/
	private String resourceid;

	/*资源名称.*/
	private String resourcename;

	/*资源描述.*/
	private String resourceinfo;

	/*菜单URL.*/
	private String url;

	/*顺序.*/
	private Integer seqno;

	/*索引.*/
	private String index;

	/*图标.*/
	private String icon;

	/*资源类型.*/
	private String type;

	/*parentId.*/
	private String parentId;

	/*子资源.*/
	private List<ResourceTree> children;

	private String createName;
	private String createTime;	//创建时间
	private String alterName;	//修改人
	private String alterTime;	//修改时间

	public ResourceTree(String resourceid, String resourcename, String resourceinfo, String icon, String parentId, Integer seqno,String type, String createName,String createTime,String alterName,String alterTime) {
		this.resourceid = resourceid;
		this.resourcename = resourcename;
		this.url = resourcename;
		this.resourceinfo = resourceinfo;
		this.icon = icon;
		this.parentId = parentId;
		this.seqno = seqno;
		this.type = type;
		this.createName = createName;
		this.createTime = createTime;
		this.alterName = alterName;
		this.alterTime = alterTime;
	}

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getResourceinfo() {
		return resourceinfo;
	}

	public void setResourceinfo(String resourceinfo) {
		this.resourceinfo = resourceinfo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<ResourceTree> getChildren() {
		return children;
	}

	public void setChildren(List<ResourceTree> children) {
		this.children = children;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAlterName() {
		return alterName;
	}

	public void setAlterName(String alterName) {
		this.alterName = alterName;
	}

	public String getAlterTime() {
		return alterTime;
	}

	public void setAlterTime(String alterTime) {
		this.alterTime = alterTime;
	}
}
