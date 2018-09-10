package com.syfri.digitalplan.model.jxcsplan;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class JxcsjzxxVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String jzid;	//建筑ID
	private String jzmc;	//建筑名称
	private String jzwz;	//建筑位置
	private String jzsyxz;	//建筑使用性质
	private String jzjg;	//建筑结构
	private String gnms;	//功能描述
	private String zdmj;	//占地面积
	private String jzmj;	//建筑面积
	private String dsgd;	//地上高度(m)
	private String dxgd;	//地下高度(m)
	private String dscs;	//地上层数
	private String dxcs;	//地下层数
	private String bnc;	//避难层
	private String xqxclx;	//辖区行车路线
	private String yjddsc;	//预计到达时长(min)
	private String bz;	//备注
	private String deleteFlag;	//删除标志
	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间
	private String datasource;	//数据来源[10000000一体化]
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4

	private String jzsyxzmc;	//建筑使用性质
	private String jzjgmc;	//建筑结构

	public String getJzid(){
		return jzid;
	}
	public void setJzid(String jzid){
		this.jzid = jzid;
	}
	public String getJzmc(){
		return jzmc;
	}
	public void setJzmc(String jzmc){
		this.jzmc = jzmc;
	}
	public String getJzwz(){
		return jzwz;
	}
	public void setJzwz(String jzwz){
		this.jzwz = jzwz;
	}
	public String getJzsyxz(){
		return jzsyxz;
	}
	public void setJzsyxz(String jzsyxz){
		this.jzsyxz = jzsyxz;
	}
	public String getJzjg(){
		return jzjg;
	}
	public void setJzjg(String jzjg){
		this.jzjg = jzjg;
	}
	public String getGnms(){
		return gnms;
	}
	public void setGnms(String gnms){
		this.gnms = gnms;
	}
	public String getZdmj(){
		return zdmj;
	}
	public void setZdmj(String zdmj){
		this.zdmj = zdmj;
	}
	public String getJzmj(){
		return jzmj;
	}
	public void setJzmj(String jzmj){
		this.jzmj = jzmj;
	}
	public String getDsgd(){
		return dsgd;
	}
	public void setDsgd(String dsgd){
		this.dsgd = dsgd;
	}
	public String getDxgd(){
		return dxgd;
	}
	public void setDxgd(String dxgd){
		this.dxgd = dxgd;
	}
	public String getDscs(){
		return dscs;
	}
	public void setDscs(String dscs){
		this.dscs = dscs;
	}
	public String getDxcs(){
		return dxcs;
	}
	public void setDxcs(String dxcs){
		this.dxcs = dxcs;
	}
	public String getBnc(){
		return bnc;
	}
	public void setBnc(String bnc){
		this.bnc = bnc;
	}
	public String getXqxclx(){
		return xqxclx;
	}
	public void setXqxclx(String xqxclx){
		this.xqxclx = xqxclx;
	}
	public String getYjddsc(){
		return yjddsc;
	}
	public void setYjddsc(String yjddsc){
		this.yjddsc = yjddsc;
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

	public String getJzsyxzmc() {
		return jzsyxzmc;
	}

	public void setJzsyxzmc(String jzsyxzmc) {
		this.jzsyxzmc = jzsyxzmc;
	}

	public String getJzjgmc() {
		return jzjgmc;
	}

	public void setJzjgmc(String jzjgmc) {
		this.jzjgmc = jzjgmc;
	}
}