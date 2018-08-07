package com.syfri.digitalplan.model.firefacilities;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class Firefacilities_xfsxt_xfbfVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String xfssid;	//消防设施ID
	private String ssjz;	//所属建（构）筑
	private String wz;	//位置
	private String xhssl;	//消火栓泵数量
	private String xhszdll;	//消火栓最大流量(L/s）
	private String plbsl;	//喷淋泵数量
	private String plbzdll;	//喷淋泵最大流量(L/s）
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String jdh;	//节点号
	private String sjc;	//时间戳
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
	public String getXfssid(){
		return xfssid;
	}
	public void setXfssid(String xfssid){
		this.xfssid = xfssid;
	}
	public String getSsjz(){
		return ssjz;
	}
	public void setSsjz(String ssjz){
		this.ssjz = ssjz;
	}
	public String getWz(){
		return wz;
	}
	public void setWz(String wz){
		this.wz = wz;
	}
	public String getXhssl(){
		return xhssl;
	}
	public void setXhssl(String xhssl){
		this.xhssl = xhssl;
	}
	public String getXhszdll(){
		return xhszdll;
	}
	public void setXhszdll(String xhszdll){
		this.xhszdll = xhszdll;
	}

	public String getPlbsl() {
		return plbsl;
	}

	public void setPlbsl(String plbsl) {
		this.plbsl = plbsl;
	}

	public String getPlbzdll() {
		return plbzdll;
	}
	public void setPlbzdll(String plbzdll) {
		this.plbzdll = plbzdll;
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