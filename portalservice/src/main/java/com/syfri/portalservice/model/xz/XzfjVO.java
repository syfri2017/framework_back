package com.syfri.portalservice.model.xz;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class XzfjVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String xzid;	//下载ID
	private String fjmc;	//附件名称
	private String fjkzm;	//附件扩展名
	private String ms;	//附件描述
	private String src;	//附件路径
	private String language;	//国际化信息
	private String deleteFlag;	//删除标志
	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getXzid(){
		return xzid;
	}
	public void setXzid(String xzid){
		this.xzid = xzid;
	}
	public String getFjmc(){
		return fjmc;
	}
	public void setFjmc(String fjmc){
		this.fjmc = fjmc;
	}
	public String getFjkzm(){
		return fjkzm;
	}
	public void setFjkzm(String fjkzm){
		this.fjkzm = fjkzm;
	}
	public String getMs(){
		return ms;
	}
	public void setMs(String ms){
		this.ms = ms;
	}
	public String getSrc(){
		return src;
	}
	public void setSrc(String src){
		this.src = src;
	}
	public String getLanguage(){
		return language;
	}
	public void setLanguage(String language){
		this.language = language;
	}
	public String getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	public String getCjrid(){
		return cjrid;
	}
	public void setCjrid(String cjrid){
		this.cjrid = cjrid;
	}
	public String getCjrmc(){
		return cjrmc;
	}
	public void setCjrmc(String cjrmc){
		this.cjrmc = cjrmc;
	}
	public String getCjsj(){
		return cjsj;
	}
	public void setCjsj(String cjsj){
		this.cjsj = cjsj;
	}
	public String getXgrid(){
		return xgrid;
	}
	public void setXgrid(String xgrid){
		this.xgrid = xgrid;
	}
	public String getXgrmc(){
		return xgrmc;
	}
	public void setXgrmc(String xgrmc){
		this.xgrmc = xgrmc;
	}
	public String getXgsj(){
		return xgsj;
	}
	public void setXgsj(String xgsj){
		this.xgsj = xgsj;
	}
	public String getReserve1(){
		return reserve1;
	}
	public void setReserve1(String reserve1){
		this.reserve1 = reserve1;
	}
	public String getReserve2(){
		return reserve2;
	}
	public void setReserve2(String reserve2){
		this.reserve2 = reserve2;
	}
	public String getReserve3(){
		return reserve3;
	}
	public void setReserve3(String reserve3){
		this.reserve3 = reserve3;
	}
	public String getReserve4(){
		return reserve4;
	}
	public void setReserve4(String reserve4){
		this.reserve4 = reserve4;
	}
}