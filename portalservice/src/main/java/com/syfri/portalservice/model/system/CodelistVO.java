package com.syfri.portalservice.model.system;

import com.syfri.baseapi.model.ValueObject;

import java.io.Serializable;

public class CodelistVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String codeid;	//主键
	private String codetype;	//代码类型
	private String codetypeName;	//代码类型名称
	private String deleteFlag;	//删除标志
	private String remark;	//备注
	private String language;	//国际化信息(默认zh_CN)
	private String createId;	//创建人ID
	private String createName;	//创建人
	private String createTime;	//创建时间
	private String createTimeBegin;
	private String createTimeEnd;
	private String alterId;	//修改人ID
	private String alterName;	//修改人
	private String alterTime;	//修改时间

	public String getCodeid() {
		return codeid;
	}

	public void setCodeid(String codeid) {
		this.codeid = codeid;
	}

	public String getCodetype() {
		return codetype;
	}

	public void setCodetype(String codetype) {
		this.codetype = codetype;
	}

	public String getCodetypeName() {
		return codetypeName;
	}

	public void setCodetypeName(String codetypeName) {
		this.codetypeName = codetypeName;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
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

	public String getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(String createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getAlterId() {
		return alterId;
	}

	public void setAlterId(String alterId) {
		this.alterId = alterId;
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