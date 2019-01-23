package com.syfri.userservice.model.venue;

import java.io.Serializable;
import java.util.Date;

import com.syfri.baseapi.model.ValueObject;

public class ZwlogVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主健
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4
	private String yqyid;	//原企业ID
	private String zwuuid;	//展位主键
	private String zwh;	//展位号
	private String qyid;	//企业ID
	private String czlx;	//操作类型
	private String czrid;	//操作人ID
	private String czrmc;	//操作人姓名
	private Date czsj;	//操作时间
	private Date rzsj;	//日志时间
	private String ffmc;	//方法名称
	private String deleteFlag;	//删除标志
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private Date xgsj;	//修改时间

	private String rzsj_begin;	//日志时间开始时间
	private String rzsj_end;	//日志时间结束时间
	private String qymc;	//企业名称
	private String czsjStr;	//操作时间
	private String rzsjStr;	//日志时间

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
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
	public String getYqyid(){
		return yqyid;
	}
	public void setYqyid(String yqyid){
		this.yqyid = yqyid;
	}
	public String getZwuuid(){
		return zwuuid;
	}
	public void setZwuuid(String zwuuid){
		this.zwuuid = zwuuid;
	}
	public String getZwh(){
		return zwh;
	}
	public void setZwh(String zwh){
		this.zwh = zwh;
	}
	public String getQyid(){
		return qyid;
	}
	public void setQyid(String qyid){
		this.qyid = qyid;
	}
	public String getCzlx(){
		return czlx;
	}
	public void setCzlx(String czlx){
		this.czlx = czlx;
	}
	public String getCzrid(){
		return czrid;
	}
	public void setCzrid(String czrid){
		this.czrid = czrid;
	}
	public String getCzrmc(){
		return czrmc;
	}
	public void setCzrmc(String czrmc){
		this.czrmc = czrmc;
	}
	public Date getCzsj(){
		return czsj;
	}
	public void setCzsj(Date czsj){
		this.czsj = czsj;
	}
	public Date getRzsj(){
		return rzsj;
	}
	public void setRzsj(Date rzsj){
		this.rzsj = rzsj;
	}
	public String getFfmc(){
		return ffmc;
	}
	public void setFfmc(String ffmc){
		this.ffmc = ffmc;
	}
	public String getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
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
	public Date getXgsj(){
		return xgsj;
	}
	public void setXgsj(Date xgsj){
		this.xgsj = xgsj;
	}

	public String getRzsj_begin() {
		return rzsj_begin;
	}

	public void setRzsj_begin(String rzsj_begin) {
		this.rzsj_begin = rzsj_begin;
	}

	public String getRzsj_end() {
		return rzsj_end;
	}

	public void setRzsj_end(String rzsj_end) {
		this.rzsj_end = rzsj_end;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getCzsjStr() {
		return czsjStr;
	}

	public void setCzsjStr(String czsjStr) {
		this.czsjStr = czsjStr;
	}

	public String getRzsjStr() {
		return rzsjStr;
	}

	public void setRzsjStr(String rzsjStr) {
		this.rzsjStr = rzsjStr;
	}
}