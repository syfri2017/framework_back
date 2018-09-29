package com.syfri.digitalplan.model.bigscreen.overview;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class DpVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String bname;	//数据项
	private String bvalue;	//数据值
	private String btype;	//数据类型
	private String sjc;	//时间戳
	private String deleteFlag;	//删除标志
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
	public String getBname(){
		return bname;
	}
	public void setBname(String bname){
		this.bname = bname;
	}
	public String getBvalue(){
		return bvalue;
	}
	public void setBvalue(String bvalue){
		this.bvalue = bvalue;
	}
	public String getBtype(){
		return btype;
	}
	public void setBtype(String btype){
		this.btype = btype;
	}
	public String getSjc(){
		return sjc;
	}
	public void setSjc(String sjc){
		this.sjc = sjc;
	}
	public String getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
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