package com.syfri.userservice.model.system;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class OrganizationVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//
	private String jgid;	//
	private String sjjgid;	//
	private String jgmc;	//
	private String jgjc;	//
	private String jgxzdm;	//
	private String jgdz;	//
	private String jgms;	//
	private String xzqh;	//
	private String yzbm;	//
	private String lxdh;	//
	private String czhm;	//
	private String lxr;	//
	private String ssym;	//
	private String zp;	//
	private String zqdwbz;	//
	private String bdLon;	//
	private String bdLat;	//
	private String gisX;	//
	private String gisY;	//
	private String gisH;	//
	private String glid;	//
	private String xqglid;	//
	private String jgtree;	//
	private String jgqz;	//
	private String xqmj;	//
	private String xqfw;	//
	private String jgcxzt;	//
	private String jgcxsj;	//
	private String cjrid;	//
	private String cjrmc;	//
	private String cjsj;	//
	private String xgrid;	//
	private String xgrmc;	//
	private String xgsj;	//
	private String deleteFlag;	//
	private String datasource;	//
	private String bz;	//
	private String jdh;	//
	private String sjc;	//
	private String reserve1;	//
	private String reserve2;	//
	private String reserve3;	//
	private String reserve4;

	private String jgxzmc; //机构性质名称
	private String xzqhmc; //行政区划名称

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getJgid(){
		return jgid;
	}
	public void setJgid(String jgid){
		this.jgid = jgid;
	}
	public String getSjjgid(){
		return sjjgid;
	}
	public void setSjjgid(String sjjgid){
		this.sjjgid = sjjgid;
	}
	public String getJgmc(){
		return jgmc;
	}
	public void setJgmc(String jgmc){
		this.jgmc = jgmc;
	}
	public String getJgjc(){
		return jgjc;
	}
	public void setJgjc(String jgjc){
		this.jgjc = jgjc;
	}
	public String getJgxzdm(){
		return jgxzdm;
	}
	public void setJgxzdm(String jgxzdm){
		this.jgxzdm = jgxzdm;
	}
	public String getJgdz(){
		return jgdz;
	}
	public void setJgdz(String jgdz){
		this.jgdz = jgdz;
	}
	public String getJgms(){
		return jgms;
	}
	public void setJgms(String jgms){
		this.jgms = jgms;
	}
	public String getXzqh(){
		return xzqh;
	}
	public void setXzqh(String xzqh){
		this.xzqh = xzqh;
	}
	public String getYzbm(){
		return yzbm;
	}
	public void setYzbm(String yzbm){
		this.yzbm = yzbm;
	}
	public String getLxdh(){
		return lxdh;
	}
	public void setLxdh(String lxdh){
		this.lxdh = lxdh;
	}
	public String getCzhm(){
		return czhm;
	}
	public void setCzhm(String czhm){
		this.czhm = czhm;
	}
	public String getLxr(){
		return lxr;
	}
	public void setLxr(String lxr){
		this.lxr = lxr;
	}
	public String getSsym(){
		return ssym;
	}
	public void setSsym(String ssym){
		this.ssym = ssym;
	}
	public String getZp(){
		return zp;
	}
	public void setZp(String zp){
		this.zp = zp;
	}
	public String getZqdwbz(){
		return zqdwbz;
	}
	public void setZqdwbz(String zqdwbz){
		this.zqdwbz = zqdwbz;
	}
	public String getBdLon(){
		return bdLon;
	}
	public void setBdLon(String bdLon){
		this.bdLon = bdLon;
	}
	public String getBdLat(){
		return bdLat;
	}
	public void setBdLat(String bdLat){
		this.bdLat = bdLat;
	}
	public String getGisX(){
		return gisX;
	}
	public void setGisX(String gisX){
		this.gisX = gisX;
	}
	public String getGisY(){
		return gisY;
	}
	public void setGisY(String gisY){
		this.gisY = gisY;
	}
	public String getGisH(){
		return gisH;
	}
	public void setGisH(String gisH){
		this.gisH = gisH;
	}
	public String getGlid(){
		return glid;
	}
	public void setGlid(String glid){
		this.glid = glid;
	}
	public String getXqglid(){
		return xqglid;
	}
	public void setXqglid(String xqglid){
		this.xqglid = xqglid;
	}
	public String getJgtree(){
		return jgtree;
	}
	public void setJgtree(String jgtree){
		this.jgtree = jgtree;
	}
	public String getJgqz(){
		return jgqz;
	}
	public void setJgqz(String jgqz){
		this.jgqz = jgqz;
	}
	public String getXqmj(){
		return xqmj;
	}
	public void setXqmj(String xqmj){
		this.xqmj = xqmj;
	}
	public String getXqfw(){
		return xqfw;
	}
	public void setXqfw(String xqfw){
		this.xqfw = xqfw;
	}
	public String getJgcxzt(){
		return jgcxzt;
	}
	public void setJgcxzt(String jgcxzt){
		this.jgcxzt = jgcxzt;
	}
	public String getJgcxsj(){
		return jgcxsj;
	}
	public void setJgcxsj(String jgcxsj){
		this.jgcxsj = jgcxsj;
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

	public String getJgxzmc() {
		return jgxzmc;
	}
	public void setJgxzmc(String jgxzmc) {
		this.jgxzmc = jgxzmc;
	}
	public String getXzqhmc() {
		return xzqhmc;
	}
	public void setXzqhmc(String xzqhmc) {
		this.xzqhmc = xzqhmc;
	}
}