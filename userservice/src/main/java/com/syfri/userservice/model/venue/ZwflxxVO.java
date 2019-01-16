package com.syfri.userservice.model.venue;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class ZwflxxVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String zwfl;	//展位分类
	private String kkfl;	//开口分类
	private String flmj;	//分类面积
	private String fljg;	//分类价格
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
	private String fljgEng;	//分类价格(美元)

	private String zwflmc;	//展位分类名称
	private String kkflmc;	//开口分类名称

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getZwfl(){
		return zwfl;
	}
	public void setZwfl(String zwfl){
		this.zwfl = zwfl;
	}
	public String getKkfl(){
		return kkfl;
	}
	public void setKkfl(String kkfl){
		this.kkfl = kkfl;
	}
	public String getFlmj(){
		return flmj;
	}
	public void setFlmj(String flmj){
		this.flmj = flmj;
	}
	public String getFljg(){
		return fljg;
	}
	public void setFljg(String fljg){
		this.fljg = fljg;
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

	public String getFljgEng() {
		return fljgEng;
	}

	public void setFljgEng(String fljgEng) {
		this.fljgEng = fljgEng;
	}

	public String getZwflmc() {
		return zwflmc;
	}

	public void setZwflmc(String zwflmc) {
		this.zwflmc = zwflmc;
	}

	public String getKkflmc() {
		return kkflmc;
	}

	public void setKkflmc(String kkflmc) {
		this.kkflmc = kkflmc;
	}
}