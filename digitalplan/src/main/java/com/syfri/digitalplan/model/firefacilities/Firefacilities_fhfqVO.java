package com.syfri.digitalplan.model.firefacilities;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class Firefacilities_fhfqVO extends FirefacilitiesVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//undefined
	private String xfssid;	//undefined
	private String qymj;	//undefined
	private String qywz;	//undefined
	private String fgss;	//undefined
	private String fgwz;	//undefined

	private String deleteFlag;	//undefined
	private String datasource;	//undefined

	private String jdh;	//undefined
	private String sjc;	//undefined
	private String reserve1;	//undefined
	private String reserve2;	//undefined
	private String reserve3;	//undefined
	private String reserve4;	//undefined

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
	public String getQymj(){
		return qymj;
	}
	public void setQymj(String qymj){
		this.qymj = qymj;
	}
	public String getQywz(){
		return qywz;
	}
	public void setQywz(String qywz){
		this.qywz = qywz;
	}
	public String getFgss(){
		return fgss;
	}
	public void setFgss(String fgss){
		this.fgss = fgss;
	}
	public String getFgwz(){
		return fgwz;
	}
	public void setFgwz(String fgwz){
		this.fgwz = fgwz;
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