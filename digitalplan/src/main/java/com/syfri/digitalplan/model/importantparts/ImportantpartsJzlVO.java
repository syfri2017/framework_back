package com.syfri.digitalplan.model.importantparts;

import java.io.Serializable;
import java.util.List;

import com.syfri.baseapi.model.ValueObject;
import com.syfri.digitalplan.model.buildingzoning.WeixianjiezhiVO;

public class ImportantpartsJzlVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String zdbwid;	//重点部位ID
	private String syxz;	//使用性质
	private String jzjg;	//建筑结构
	private String qymj;	//区域面积(㎡)
	private String gnms;	//功能描述
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4

	private String jzjgmc;    //建筑结构名称
	private String syxzmc;    //使用性质名称

	private List<WeixianjiezhiVO> wxjzList;    //危险介质列表

	private List<String> syxzList;    //使用性质List

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
	public String getSyxz(){
		return syxz;
	}
	public void setSyxz(String syxz){
		this.syxz = syxz;
	}
	public String getJzjg(){
		return jzjg;
	}
	public void setJzjg(String jzjg){
		this.jzjg = jzjg;
	}
	public String getQymj(){
		return qymj;
	}
	public void setQymj(String qymj){
		this.qymj = qymj;
	}
	public String getGnms(){
		return gnms;
	}
	public void setGnms(String gnms){
		this.gnms = gnms;
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
	public String getSyxzmc() {
		return syxzmc;
	}
	public void setSyxzmc(String syxzmc) {
		this.syxzmc = syxzmc;
	}

	public List<WeixianjiezhiVO> getWxjzList() {
		return wxjzList;
	}
	public void setWxjzList(List<WeixianjiezhiVO> wxjzList) {
		this.wxjzList = wxjzList;
	}

	public List<String> getSyxzList() {
		return syxzList;
	}
	public void setSyxzList(List<String> syxzList) {
		this.syxzList = syxzList;
	}
}