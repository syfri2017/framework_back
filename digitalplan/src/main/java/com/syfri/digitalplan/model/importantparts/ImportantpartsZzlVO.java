package com.syfri.digitalplan.model.importantparts;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class ImportantpartsZzlVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String zdbwid;	//重点部位ID
	private String jzjg;	//建筑结构
	private String zdmj;	//占地面积(㎡)
	private String zzgd;	//装置高度(m)
	private String zzzc;	//装置组成
	private String jsfzr;	//技术负责人
	private String jsfzrdh;	//技术负责人电话
	private String ylxx;	//原料信息
	private String cwxx;	//产物信息
	private String gylc;	//工艺流程
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4

	private String jzjgmc;  //建筑结构名称

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getZdbwid(){
		return zdbwid;
	}
	public void setZdbwid(String zdbwid){
		this.zdbwid = zdbwid;
	}
	public String getJzjg(){
		return jzjg;
	}
	public void setJzjg(String jzjg){
		this.jzjg = jzjg;
	}
	public String getZdmj(){
		return zdmj;
	}
	public void setZdmj(String zdmj){
		this.zdmj = zdmj;
	}
	public String getZzgd(){
		return zzgd;
	}
	public void setZzgd(String zzgd){
		this.zzgd = zzgd;
	}
	public String getZzzc(){
		return zzzc;
	}
	public void setZzzc(String zzzc){
		this.zzzc = zzzc;
	}
	public String getJsfzr(){
		return jsfzr;
	}
	public void setJsfzr(String jsfzr){
		this.jsfzr = jsfzr;
	}
	public String getJsfzrdh(){
		return jsfzrdh;
	}
	public void setJsfzrdh(String jsfzrdh){
		this.jsfzrdh = jsfzrdh;
	}
	public String getYlxx(){
		return ylxx;
	}
	public void setYlxx(String ylxx){
		this.ylxx = ylxx;
	}
	public String getCwxx(){
		return cwxx;
	}
	public void setCwxx(String cwxx){
		this.cwxx = cwxx;
	}
	public String getGylc(){
		return gylc;
	}
	public void setGylc(String gylc){
		this.gylc = gylc;
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

	public String getJzjgmc() {
		return jzjgmc;
	}
	public void setJzjgmc(String jzjgmc) {
		this.jzjgmc = jzjgmc;
	}
}