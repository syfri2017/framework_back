package com.syfri.digitalplan.model.importantparts;

import java.io.Serializable;
import java.util.List;

import com.syfri.baseapi.model.ValueObject;
import com.syfri.digitalplan.model.buildingzoning.ChuguanVO;

public class ImportantpartsCglVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String zdbwid;	//重点部位ID
	private String zrj;	//总容积(m3)
	private String cgsl;	//储罐数量
	private String cgjg;	//储罐间隔
	private String ccjzms;	//存储介质描述
	private String jsfzr;	//技术负责人
	private String jsfzrdh;	//技术负责人电话
	private String plqkd;	//罐组毗邻情况(东)
	private String plqkn;	//罐组毗邻情况(南)
	private String plqkx;	//罐组毗邻情况(西)
	private String plqkb;	//罐组毗邻情况(北)
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4

	private List<ChuguanVO> cgList;   //储罐列表

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
	public String getZrj(){
		return zrj;
	}
	public void setZrj(String zrj){
		this.zrj = zrj;
	}
	public String getCgsl(){
		return cgsl;
	}
	public void setCgsl(String cgsl){
		this.cgsl = cgsl;
	}
	public String getCgjg(){
		return cgjg;
	}
	public void setCgjg(String cgjg){
		this.cgjg = cgjg;
	}
	public String getCcjzms(){
		return ccjzms;
	}
	public void setCcjzms(String ccjzms){
		this.ccjzms = ccjzms;
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
	public String getPlqkd(){
		return plqkd;
	}
	public void setPlqkd(String plqkd){
		this.plqkd = plqkd;
	}
	public String getPlqkn(){
		return plqkn;
	}
	public void setPlqkn(String plqkn){
		this.plqkn = plqkn;
	}
	public String getPlqkx(){
		return plqkx;
	}
	public void setPlqkx(String plqkx){
		this.plqkx = plqkx;
	}
	public String getPlqkb(){
		return plqkb;
	}
	public void setPlqkb(String plqkb){
		this.plqkb = plqkb;
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

	public List<ChuguanVO> getCgList() {
		return cgList;
	}
	public void setCgList(List<ChuguanVO> cgList) {
		this.cgList = cgList;
	}
}