package com.syfri.digitalplan.model.basicinfo.equipmentsource;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class EquipengineVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String zbid;	//装备ID
	private String clid;	//车辆ID
	private String clmc;	//车辆名称
	private String clzzs;	//车辆装载数
	private String bz;	//备注
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[10000000一体化]
	private String jdh;	//节点号
	private String sjc;	//时间戳

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

	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4
	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getZbid(){
		return zbid;
	}
	public void setZbid(String zbid){
		this.zbid = zbid;
	}
	public String getClid(){
		return clid;
	}
	public void setClid(String clid){
		this.clid = clid;
	}
	public String getClmc(){
		return clmc;
	}
	public void setClmc(String clmc){
		this.clmc = clmc;
	}
	public String getClzzs(){
		return clzzs;
	}
	public void setClzzs(String clzzs){
		this.clzzs = clzzs;
	}
	public String getBz(){
		return bz;
	}
	public void setBz(String bz){
		this.bz = bz;
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
}