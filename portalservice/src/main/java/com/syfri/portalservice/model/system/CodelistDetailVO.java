package com.syfri.portalservice.model.system;

import com.syfri.baseapi.model.ValueObject;

import java.io.Serializable;

public class CodelistDetailVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String pkid;	//主键
	private String codeValue;	//代码值
	private String codeName;	//代码名称
	private String codeid;	//代码集主表主键（父）
	private String codetype;  //代码集类型
	private String codetypeName;  //代码集类型名称
	private String deleteFlag;	//删除标志(默认'N')
	private String remark;	//备注
	private String createId;	//创建人ID
	private String createName;	//创建人
	private String createTime;	//创建时间
	private String alterId;	//修改人ID
	private String alterName;	//修改人
	private String alterTime;	//修改时间

	public CodelistDetailVO() {
	}

	public CodelistDetailVO(String codeValue, String remark) {
		this.codeValue = codeValue;
		this.remark = remark;
	}

	public String getPkid(){
		return pkid;
	}
	public void setPkid(String pkid){
		this.pkid = pkid;
	}
	public String getCodeValue(){
		return codeValue;
	}
	public void setCodeValue(String codeValue){
		this.codeValue = codeValue;
	}
	public String getCodeName(){
		return codeName;
	}
	public void setCodeName(String codeName){
		this.codeName = codeName;
	}
	public String getCodeid(){
		return codeid;
	}
	public void setCodeid(String codeid){
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
	public String getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	public String getRemark(){
		return remark;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getCreateId(){
		return createId;
	}
	public void setCreateId(String createId){
		this.createId = createId;
	}
	public String getCreateName(){
		return createName;
	}
	public void setCreateName(String createName){
		this.createName = createName;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getAlterId(){
		return alterId;
	}
	public void setAlterId(String alterId){
		this.alterId = alterId;
	}
	public String getAlterName(){
		return alterName;
	}
	public void setAlterName(String alterName){
		this.alterName = alterName;
	}
	public String getAlterTime(){
		return alterTime;
	}
	public void setAlterTime(String alterTime){
		this.alterTime = alterTime;
	}
}