package com.syfri.digitalplan.model.basicinfo.equipmentsource;

import java.io.Serializable;
import java.util.List;

import com.syfri.baseapi.model.ValueObject;

public class EquipmentVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String zbbm;	//装备编码
	private String zbmc;	//装备名称
	private String ssdz;	//所属队站
	private String ssdzmc;	//所属队站名称
	private String xzqh;	//行政区划CODE（到区县）
	private String zblx;	//装备类型ZBLX
	private String sccj;	//生产厂家
	private String zcbl;	//总储备量
	private String kysl;	//库存数量（可用）
	private String zzsl;	//装载数量
	private String shsl;	//维修数量（损坏）
	private String ztsl;	//在途数量
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String bz;	//备注
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4
	private String cjrid;	//创建人ID

	public String getCjrid() {
		return cjrid;
	}

	public void setCjrid(String cjrid) {
		this.cjrid = cjrid;
	}

	public String getCjrmc() {
		return cjrmc;
	}

	public void setCjrmc(String cjrmc) {
		this.cjrmc = cjrmc;
	}

	public String getCjsj() {
		return cjsj;
	}

	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}

	public String getXgrid() {
		return xgrid;
	}

	public void setXgrid(String xgrid) {
		this.xgrid = xgrid;
	}

	public String getXgrmc() {
		return xgrmc;
	}

	public void setXgrmc(String xgrmc) {
		this.xgrmc = xgrmc;
	}

	public String getXgsj() {
		return xgsj;
	}

	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}

	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间

	public List<EquipengineVO> getEquipengineVOList() {
		return equipengineVOList;
	}

	public void setEquipengineVOList(List<EquipengineVO> equipengineVOList) {
		this.equipengineVOList = equipengineVOList;
	}

	private List<EquipengineVO> equipengineVOList;

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getZbbm(){
		return zbbm;
	}
	public void setZbbm(String zbbm){
		this.zbbm = zbbm;
	}
	public String getZbmc(){
		return zbmc;
	}
	public void setZbmc(String zbmc){
		this.zbmc = zbmc;
	}
	public String getSsdz(){
		return ssdz;
	}
	public void setSsdz(String ssdz){
		this.ssdz = ssdz;
	}
	public String getSsdzmc(){
		return ssdzmc;
	}
	public void setSsdzmc(String ssdzmc){
		this.ssdzmc = ssdzmc;
	}
	public String getXzqh(){
		return xzqh;
	}
	public void setXzqh(String xzqh){
		this.xzqh = xzqh;
	}
	public String getZblx(){
		return zblx;
	}
	public void setZblx(String zblx){
		this.zblx = zblx;
	}
	public String getSccj(){
		return sccj;
	}
	public void setSccj(String sccj){
		this.sccj = sccj;
	}
	public String getZcbl(){
		return zcbl;
	}
	public void setZcbl(String zcbl){
		this.zcbl = zcbl;
	}
	public String getKysl(){
		return kysl;
	}
	public void setKysl(String kysl){
		this.kysl = kysl;
	}
	public String getZzsl(){
		return zzsl;
	}
	public void setZzsl(String zzsl){
		this.zzsl = zzsl;
	}
	public String getShsl(){
		return shsl;
	}
	public void setShsl(String shsl){
		this.shsl = shsl;
	}
	public String getZtsl(){
		return ztsl;
	}
	public void setZtsl(String ztsl){
		this.ztsl = ztsl;
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
	public String getBz(){
		return bz;
	}
	public void setBz(String bz){
		this.bz = bz;
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

	private String kysl_min;
	private String kysl_max;
	public String getKysl_min(){
		return kysl_min;
	}
	public void setKysl_min(String kysl_min){
		this.kysl_min = kysl_min;
	}
	public String getKysl_max(){
		return kysl_max;
	}
	public void setKysl_max(String kysl_max){
		this.kysl_max = kysl_max;
	}

	private String dzmc;	//队站名称
	private String xzqhmc;	//行政区划名称
	private String zblxmc;	//装备类型名称
	public String getDzmc(){
		return dzmc;
	}
	public void setDzmc(String dzmc){
		this.dzmc = dzmc;
	}
	public String getXzqhmc(){
		return xzqhmc;
	}
	public void setXzqhmc(String xzqhmc){
		this.xzqhmc = xzqhmc;
	}
	public String getZblxmc(){
		return zblxmc;
	}
	public void setZblxmc(String zblxmc){
		this.zblxmc = zblxmc;
	}
}