package com.syfri.digitalplan.model.basicinfo.fireenginesource;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class FireengineVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
//	private String pkid;
	private String clbm;	//车辆编码
	private String clmc;	//车辆名称
	private String ssdz;	//所属队站
	private String ssdzmc;	//所属队站名称
	private String xzqh;	//行政区划
	private String cllx;	//车辆类型
	private String cphm;	//车牌号码
	private String clzt;	//车辆状态
	private String sccj;	//生产厂家
	private String jglgd;	//举高类车辆高度(m)
	private String sbll;	//水泵流量(L/s)
	private String zsl;	//载水量(t)
	private String xfpll;	//消防炮流量(L/s)
	private String sbedyl;	//水泵额定压力(Mpa)
	private String czmhjlb;	//车载灭火剂类别
	private String czmhjl;	//车载灭火剂量(t)
	private String mhjhhb;	//灭火剂混合比
	private String gpsbh;	//GPS编号
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String bz;	//备注
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4
	private String gisX;	//GIS_X
	private String gisY;	//GIS_X
	private String xzqhmc;	//行政区划（名称）
	private String cllxmc;	//车辆类型（名称）
	private String clztmc;	//车辆状态（名称）
	private String czmhjlbmc;	//车载灭火剂类别（名称）

	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间

	private String gisX_min;	//GIS_X
	private String gisX_max;	//GIS_X
	private String gisY_min;	//GIS_Y
	private String gisY_max;	//GIS_Y
	private String sbll_min;
	private String sbll_max;
	private String zsl_min;
	private String zsl_max;

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
//	public String getPkid(){
//		return pkid;
//	}
//	public void setPkid(String pkid){
//		this.pkid = pkid;
//	}
	public String getClbm(){
		return clbm;
	}
	public void setClbm(String clbm){
		this.clbm = clbm;
	}
	public String getClmc(){
		return clmc;
	}
	public void setClmc(String clmc){
		this.clmc = clmc;
	}
	public String getSsdz(){
		return ssdz;
	}
	public void setSsdz(String ssdz){
		this.ssdz = ssdz;
	}
	public String getSsdzmc(){
		return ssdzmc;
	}
	public void setSsdzmc(String ssdzmc){
		this.ssdzmc = ssdzmc;
	}
	public String getXzqh(){
		return xzqh;
	}
	public void setXzqh(String xzqh){
		this.xzqh = xzqh;
	}
	public String getCllx(){
		return cllx;
	}
	public void setCllx(String cllx){
		this.cllx = cllx;
	}
	public String getCphm(){
		return cphm;
	}
	public void setCphm(String cphm){
		this.cphm = cphm;
	}
	public String getClzt(){
		return clzt;
	}
	public void setClzt(String clzt){
		this.clzt = clzt;
	}
	public String getSccj(){
		return sccj;
	}
	public void setSccj(String sccj){
		this.sccj = sccj;
	}
	public String getJglgd(){
		return jglgd;
	}
	public void setJglgd(String jglgd){
		this.jglgd = jglgd;
	}
	public String getSbll(){
		return sbll;
	}
	public void setSbll(String sbll){
		this.sbll = sbll;
	}
	public String getZsl(){
		return zsl;
	}
	public void setZsl(String zsl){
		this.zsl = zsl;
	}
	public String getXfpll(){
		return xfpll;
	}
	public void setXfpll(String xfpll){
		this.xfpll = xfpll;
	}
	public String getSbedyl(){
		return sbedyl;
	}
	public void setSbedyl(String sbedyl){
		this.sbedyl = sbedyl;
	}
	public String getCzmhjlb(){
		return czmhjlb;
	}
	public void setCzmhjlb(String czmhjlb){
		this.czmhjlb = czmhjlb;
	}
	public String getCzmhjl(){
		return czmhjl;
	}
	public void setCzmhjl(String czmhjl){
		this.czmhjl = czmhjl;
	}
	public String getMhjhhb(){
		return mhjhhb;
	}
	public void setMhjhhb(String mhjhhb){
		this.mhjhhb = mhjhhb;
	}
	public String getGpsbh(){
		return gpsbh;
	}
	public void setGpsbh(String gpsbh){
		this.gpsbh = gpsbh;
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
	public String getXzqhmc() {
		return xzqhmc;
	}
	public void setXzqhmc(String xzqhmc) {
		this.xzqhmc = xzqhmc;
	}
	public String getCllxmc() {
		return cllxmc;
	}
	public void setCllxmc(String cllxmc) {
		this.cllxmc = cllxmc;
	}
	public String getClztmc() {
		return clztmc;
	}
	public void setClztmc(String clztmc) {
		this.clztmc = clztmc;
	}
	public String getCzmhjlbmc() {
		return czmhjlbmc;
	}
	public void setCzmhjlbmc(String czmhjlbmc) {
		this.czmhjlbmc = czmhjlbmc;
	}

	public String getGisX_min() {
		return gisX_min;
	}
	public void setGisX_min(String gisX_min) {
		this.gisX_min = gisX_min;
	}
	public String getGisX_max() {
		return gisX_max;
	}
	public void setGisX_max(String gisX_max) {
		this.gisX_max = gisX_max;
	}
	public String getGisY_min() {
		return gisY_min;
	}
	public void setGisY_min(String gisY_min) {
		this.gisY_min = gisY_min;
	}
	public String getGisY_max() {
		return gisY_max;
	}
	public void setGisY_max(String gisY_max) {
		this.gisY_max = gisY_max;
	}
	public String getSbll_min() { return sbll_min; }
	public void setSbll_min(String sbll_min) { this.sbll_min = sbll_min; }
	public String getSbll_max() { return sbll_max; }
	public void setSbll_max(String sbll_max) { this.sbll_max = sbll_max; }
	public String getZsl_min() { return zsl_min; }
	public void setZsl_min(String zsl_min) { this.zsl_min = zsl_min; }
	public String getZsl_max() { return zsl_max; }
	public void setZsl_max(String zsl_max) { this.zsl_max = zsl_max; }

	public String getCjrid() {
		return cjrid;
	}
	public void setCjrid(String cjrid) {
		this.cjrid = cjrid;
	}
	public String getCjrmc() {
		return cjrmc;
	}
	public void setCjrmc(String cjrmc) {
		this.cjrmc = cjrmc;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getXgrid() {
		return xgrid;
	}
	public void setXgrid(String xgrid) {
		this.xgrid = xgrid;
	}
	public String getXgrmc() {
		return xgrmc;
	}
	public void setXgrmc(String xgrmc) {
		this.xgrmc = xgrmc;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}

}