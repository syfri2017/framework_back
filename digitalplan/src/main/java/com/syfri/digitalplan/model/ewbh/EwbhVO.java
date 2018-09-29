package com.syfri.digitalplan.model.ewbh;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class EwbhVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String zddwid;	//重点单位ID
	private String xzlj;	//下载路径
	private String wjm;	//文件名
	private String kzm;	//扩展名
	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人名称
	private String xgsj;	//修改时间
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源
	private String bz;	//备注
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备注1
	private String reserve2;	//备注2
	private String reserve3;	//备注3
	private String reserve4;	//备注4
	private byte[] bhnr;	//标绘内容JSON

	private String zddwmc;	//重点单位名称
	private String ewbhjson;

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getZddwid(){
		return zddwid;
	}
	public void setZddwid(String zddwid){
		this.zddwid = zddwid;
	}
	public String getXzlj(){
		return xzlj;
	}
	public void setXzlj(String xzlj){
		this.xzlj = xzlj;
	}
	public String getWjm(){
		return wjm;
	}
	public void setWjm(String wjm){
		this.wjm = wjm;
	}
	public String getKzm(){
		return kzm;
	}
	public void setKzm(String kzm){
		this.kzm = kzm;
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
	public String getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	public String getDatasource(){
		return datasource;
	}
	public void setDatasource(String datasource){
		this.datasource = datasource;
	}
	public String getBz(){
		return bz;
	}
	public void setBz(String bz){
		this.bz = bz;
	}
	public String getJdh(){
		return jdh;
	}
	public void setJdh(String jdh){
		this.jdh = jdh;
	}
	public String getSjc(){
		return sjc;
	}
	public void setSjc(String sjc){
		this.sjc = sjc;
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

	public byte[] getBhnr() {
		return bhnr;
	}

	public void setBhnr(byte[] bhnr) {
		this.bhnr = bhnr;
	}

	public String getEwbhjson() {
		return ewbhjson;
	}

	public void setEwbhjson(String ewbhjson) {
		this.ewbhjson = ewbhjson;
	}

	public String getZddwmc() {
		return zddwmc;
	}
	public void setZddwmc(String zddwmc) {
		this.zddwmc = zddwmc;
	}
}