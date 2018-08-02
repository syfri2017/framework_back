package com.syfri.digitalplan.model.firefacilities;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class FirefacilitiesVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

//	private String xfssid;	//消防设施ID（主键）
//	private String fqid;	//建筑分区ID
//	private String xfssmc;	//消防设施名称
//	private String xfsslx;	//消防设施类型
//	private String iszddw;	//是否重点单位消防设施
//	private String zddwid;	//重点单位ID
//	private String cjrid;	//创建人ID
//	private String cjrmc;	//创建人名称
//	private String cjsj;	//创建时间
//	private String xgrid;	//修改人ID
//	private String xgrmc;	//修改人姓名
//	private String xgsj;	//修改时间
//	private String deleteFlag;	//删除标志
//	private String datasource;	//数据来源[100000一体化]
//	private String bz;	//备注
//	private String jdh;	//节点号
//	private String sjc;	//时间戳
//	private String reserve1;	//备用字段1
//	private String reserve2;	//备用字段2
//	private String reserve3;	//备用字段3
//	private String reserve4;	//备用字段4

//	public String getXfssid(){
//		return xfssid;
//	}
//	public void setXfssid(String xfssid){
//		this.xfssid = xfssid;
//	}
//	public String getFqid(){
//		return fqid;
//	}
//	public void setFqid(String fqid){
//		this.fqid = fqid;
//	}
//	public String getXfssmc(){
//		return xfssmc;
//	}
//	public void setXfssmc(String xfssmc){
//		this.xfssmc = xfssmc;
//	}
//	public String getXfsslx(){
//		return xfsslx;
//	}
//	public void setXfsslx(String xfsslx){
//		this.xfsslx = xfsslx;
//	}
//	public String getIszddw(){
//		return iszddw;
//	}
//	public void setIszddw(String iszddw){
//		this.iszddw = iszddw;
//	}
//	public String getZddwid(){
//		return zddwid;
//	}
//	public void setZddwid(String zddwid){
//		this.zddwid = zddwid;
//	}
//	public String getCjrid(){
//		return cjrid;
//	}
//	public void setCjrid(String cjrid){
//		this.cjrid = cjrid;
//	}
//	public String getCjrmc(){
//		return cjrmc;
//	}
//	public void setCjrmc(String cjrmc){
//		this.cjrmc = cjrmc;
//	}
//	public String getCjsj(){
//		return cjsj;
//	}
//	public void setCjsj(String cjsj){
//		this.cjsj = cjsj;
//	}
//	public String getXgrid(){
//		return xgrid;
//	}
//	public void setXgrid(String xgrid){
//		this.xgrid = xgrid;
//	}
//	public String getXgrmc(){
//		return xgrmc;
//	}
//	public void setXgrmc(String xgrmc){
//		this.xgrmc = xgrmc;
//	}
//	public String getXgsj(){
//		return xgsj;
//	}
//	public void setXgsj(String xgsj){
//		this.xgsj = xgsj;
//	}
//	public String getDeleteFlag(){
//		return deleteFlag;
//	}
//	public void setDeleteFlag(String deleteFlag){
//		this.deleteFlag = deleteFlag;
//	}
//	public String getDatasource(){
//		return datasource;
//	}
//	public void setDatasource(String datasource){
//		this.datasource = datasource;
//	}
//	public String getBz(){
//		return bz;
//	}
//	public void setBz(String bz){
//		this.bz = bz;
//	}
//	public String getJdh(){
//		return jdh;
//	}
//	public void setJdh(String jdh){
//		this.jdh = jdh;
//	}
//	public String getSjc(){
//		return sjc;
//	}
//	public void setSjc(String sjc){
//		this.sjc = sjc;
//	}
//	public String getReserve1(){
//		return reserve1;
//	}
//	public void setReserve1(String reserve1){
//		this.reserve1 = reserve1;
//	}
//	public String getReserve2(){
//		return reserve2;
//	}
//	public void setReserve2(String reserve2){
//		this.reserve2 = reserve2;
//	}
//	public String getReserve3(){
//		return reserve3;
//	}
//	public void setReserve3(String reserve3){
//		this.reserve3 = reserve3;
//	}
//	public String getReserve4(){
//		return reserve4;
//	}
//	public void setReserve4(String reserve4){
//		this.reserve4 = reserve4;
//	}

	private String jbxx_xfssid;	//消防设施ID（主键）
	private String jbxx_jzid;	//建筑分区ID
	private String jbxx_jzmc;	//建筑分区名称
	private String jbxx_xfssmc;	//消防设施名称
	private String jbxx_xfsslx;	//消防设施类型
	private String jbxx_xfsslxmc;	//消防设施类型名称
	private String jbxx_iszddw;	//是否重点单位消防设施
	private String jbxx_zddwid;	//重点单位ID
	private String jbxx_zddwmc;	//重点单位名称
	private String jbxx_deleteFlag;	//删除标志
	private String jbxx_datasource;	//数据来源[100000一体化]
	private String jbxx_bz;	//备注
	private String jbxx_jdh;	//节点号
	private String jbxx_sjc;	//时间戳
	private String jbxx_reserve1;	//备用字段1
	private String jbxx_reserve2;	//备用字段2
	private String jbxx_reserve3;	//备用字段3
	private String jbxx_reserve4;	//备用字段4

	public String getJbxx_xfssid() {
		return jbxx_xfssid;
	}

	public void setJbxx_xfssid(String jbxx_xfssid) {
		this.jbxx_xfssid = jbxx_xfssid;
	}

	public String getJbxx_jzid() {
		return jbxx_jzid;
	}

	public void setJbxx_jzid(String jbxx_jzid) {
		this.jbxx_jzid = jbxx_jzid;
	}

	public String getJbxx_jzmc() {
		return jbxx_jzmc;
	}

	public void setJbxx_jzmc(String jbxx_jzmc) {
		this.jbxx_jzmc = jbxx_jzmc;
	}

	public String getJbxx_xfssmc() {
		return jbxx_xfssmc;
	}

	public void setJbxx_xfssmc(String jbxx_xfssmc) {
		this.jbxx_xfssmc = jbxx_xfssmc;
	}

	public String getJbxx_xfsslx() {
		return jbxx_xfsslx;
	}

	public void setJbxx_xfsslx(String jbxx_xfsslx) {
		this.jbxx_xfsslx = jbxx_xfsslx;
	}

	public String getJbxx_xfsslxmc() {
		return jbxx_xfsslxmc;
	}

	public void setJbxx_xfsslxmc(String jbxx_xfsslxmc) {
		this.jbxx_xfsslxmc = jbxx_xfsslxmc;
	}

	public String getJbxx_iszddw() {
		return jbxx_iszddw;
	}

	public void setJbxx_iszddw(String jbxx_iszddw) {
		this.jbxx_iszddw = jbxx_iszddw;
	}

	public String getJbxx_zddwid() {
		return jbxx_zddwid;
	}

	public void setJbxx_zddwid(String jbxx_zddwid) {
		this.jbxx_zddwid = jbxx_zddwid;
	}

	public String getJbxx_zddwmc() {
		return jbxx_zddwmc;
	}

	public void setJbxx_zddwmc(String jbxx_zddwmc) {
		this.jbxx_zddwmc = jbxx_zddwmc;
	}

	public String getJbxx_deleteFlag() {
		return jbxx_deleteFlag;
	}

	public void setJbxx_deleteFlag(String jbxx_deleteFlag) {
		this.jbxx_deleteFlag = jbxx_deleteFlag;
	}

	public String getJbxx_datasource() {
		return jbxx_datasource;
	}

	public void setJbxx_datasource(String jbxx_datasource) {
		this.jbxx_datasource = jbxx_datasource;
	}

	public String getJbxx_bz() {
		return jbxx_bz;
	}

	public void setJbxx_bz(String jbxx_bz) {
		this.jbxx_bz = jbxx_bz;
	}

	public String getJbxx_jdh() {
		return jbxx_jdh;
	}

	public void setJbxx_jdh(String jbxx_jdh) {
		this.jbxx_jdh = jbxx_jdh;
	}

	public String getJbxx_sjc() {
		return jbxx_sjc;
	}

	public void setJbxx_sjc(String jbxx_sjc) {
		this.jbxx_sjc = jbxx_sjc;
	}

	public String getJbxx_reserve1() {
		return jbxx_reserve1;
	}

	public void setJbxx_reserve1(String jbxx_reserve1) {
		this.jbxx_reserve1 = jbxx_reserve1;
	}

	public String getJbxx_reserve2() {
		return jbxx_reserve2;
	}

	public void setJbxx_reserve2(String jbxx_reserve2) {
		this.jbxx_reserve2 = jbxx_reserve2;
	}

	public String getJbxx_reserve3() {
		return jbxx_reserve3;
	}

	public void setJbxx_reserve3(String jbxx_reserve3) {
		this.jbxx_reserve3 = jbxx_reserve3;
	}

	public String getJbxx_reserve4() {
		return jbxx_reserve4;
	}

	public void setJbxx_reserve4(String jbxx_reserve4) {
		this.jbxx_reserve4 = jbxx_reserve4;
	}
}