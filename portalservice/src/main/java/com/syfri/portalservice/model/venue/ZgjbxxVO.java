package com.syfri.portalservice.model.venue;

import com.syfri.baseapi.model.ValueObject;

import java.io.Serializable;

public class ZgjbxxVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private byte[] zgtp;	//展馆图片
	private byte[] zgzwhb;	//展馆展位画布
	private byte[] zgzwhbtp;	//展馆展位画布图片
	private String zgtpStr;	//展馆图片
	private String zgzwhbStr;	//展馆展位画布
	private String zgzwhbtpStr;	//展馆展位画布图片

	private String zgmc;	//展馆名称
	private String zgtpdz;	//展馆图片地址（预留）
	private String deleteFlag;	//删除标志
	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4

	public byte[] getZgzwhbtp() {
		return zgzwhbtp;
	}

	public void setZgzwhbtp(byte[] zgzwhbtp) {
		//this.zgzwhbtp=zgzwhbtp;
		if(zgzwhbtp !=null){
			this.zgzwhbtpStr= new String(zgzwhbtp);
		}
	}

	public String getZgzwhbtpStr() {
		return zgzwhbtpStr;
	}

	public void setZgzwhbtpStr(String zgzwhbtpStr)  throws Exception{
		//this.zgzwhbtpStr = zgzwhbtpStr;
		if(this.zgzwhbtp==null){
			this.zgzwhbtp=zgzwhbtpStr.getBytes("UTF-8");
		}else{
			this.zgzwhbtpStr = zgzwhbtpStr;
		}
	}

	public String getZgtpStr() {
		return zgtpStr;
	}

	public void setZgtpStr(String zgtpStr) throws Exception{
		if(this.zgtp==null){
			//this.zgtp=zgtpStr.getBytes("GBK");
			this.zgtp=zgtpStr.getBytes("UTF-8");
		}else{
			this.zgtpStr = zgtpStr;
		}
	}

	public String getZgzwhbStr() {
		return zgzwhbStr;
	}

	public void setZgzwhbStr(String zgzwhbStr) throws Exception{
		if(this.zgzwhb==null){
			//this.zgzwhb=zgzwhbStr.getBytes("GBK");
			this.zgzwhb=zgzwhbStr.getBytes("UTF-8");
		}else{
			this.zgzwhbStr = zgzwhbStr;
		}
	}

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public byte[] getZgtp(){
		return zgtp;
	}
	public void setZgtp(byte[] zgtp){
		//this.zgtp = zgtp;
		if(zgtp !=null){
			this.zgtpStr= new String(zgtp);
		}
	}
	public byte[] getZgzwhb(){
		return zgzwhb;

	}
	public void setZgzwhb(byte[] zgzwhb){
		//this.zgzwhb = zgzwhb;
		this.zgzwhbStr= new String(zgzwhb);
	}
	public String getZgmc(){
		return zgmc;
	}
	public void setZgmc(String zgmc){
		this.zgmc = zgmc;
	}
	public String getZgtpdz(){
		return zgtpdz;
	}
	public void setZgtpdz(String zgtpdz){
		this.zgtpdz = zgtpdz;
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