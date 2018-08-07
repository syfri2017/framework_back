package com.syfri.digitalplan.model.buildingzoning;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.syfri.baseapi.model.ValueObject;

public class BuildingVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String jzid;	//建筑分区ID
	private String jzmc;	//建筑分区名称
	private String jzlx;	//建筑分区类型
	private String jzwz;	//建筑分区位置
	private String lon;	//经度
	private String lat;	//纬度
	private String xqxclx;	//辖区行车路线
	private String yjddsc;	//预计到达时长(min)
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
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间

	private BuildingVO buildingVO;

	public BuildingVO getBuildingVO() {
		return buildingVO;
	}

	public void setBuildingVO(BuildingVO buildingVO) {
		this.buildingVO = buildingVO;
	}

	private String jzlxmc;	//建筑分区类型名称

	private String jzl_uuid;	//主键
	private String jzl_jzid;	//建筑分区ID
	private String jzl_jzqk;	//建筑情况
	private String jzl_jzsyxz;	//建筑使用性质
	private String jzl_jzjg;	//建筑结构
	private String jzl_gnms;	//功能描述
	private String jzl_zdmj;	//占地面积
	private String jzl_jzmj;	//建筑面积
	private String jzl_dsgd;	//地上高度(m)
	private String jzl_dxgd;	//地下高度(m)
	private String jzl_dscs;	//地上层数
	private String jzl_dxcs;	//地下层数
	private String jzl_deleteFlag;	//删除标志
	private String jzl_datasource;	//数据来源[100000一体化]
	//private String jzl_bz;	//备注
	private String jzl_jdh;	//节点号
	private String jzl_sjc;	//时间戳
	private String jzl_reserve1;	//备用字段1
	private String jzl_reserve2;	//备用字段2
	private String jzl_reserve3;	//备用字段3
	private String jzl_reserve4;	//备用字段4

	private String jzl_jzqkmc;	//建筑情况名称
	private String jzl_jzsyxzmc;	//建筑使用性质名称
	private String jzl_jzjgmc;	//建筑结构名称
	private String jzl_dsgd_min;	//地上高度范围 最小值
	private String jzl_dsgd_max;	//地上高度范围 最大值

	private String zzl_uuid;	//主键
	private String zzl_jzid;	//建筑分区ID
	private String zzl_jzjg;	//建筑结构
	private String zzl_zdmj;	//占地面积
	private String zzl_zzzc;	//装置组成
	private String zzl_zzgd;	//装置高度(m)
	private String zzl_jsfzr;	//技术负责人
	private String zzl_jsfzrdh;	//技术负责人电话
	private String zzl_ylxx;	//原料信息
	private String zzl_cwxx;	//产物信息
	private String zzl_gylc;	//工艺流程
	private String zzl_cjrid;	//创建人ID
	private String zzl_cjrmc;	//创建人名称
	private String zzl_cjsj;	//创建时间
	private String zzl_xgrid;	//修改人ID
	private String zzl_xgrmc;	//修改人姓名
	private String zzl_deleteFlag;	//删除标志
	private String zzl_datasource;	//数据来源[100000一体化]
	//private String zzl_bz;	//备注
	private String zzl_jdh;	//节点号
	private String zzl_sjc;	//时间戳
	private String zzl_reserve1;	//备用字段1
	private String zzl_reserve2;	//备用字段2
	private String zzl_reserve3;	//备用字段3
	private String zzl_reserve4;	//备用字段4

	private String zzl_jzjgmc;	//建筑结构名称

	private String cgl_uuid;	//主键
	private String cgl_jzid;	//建筑分区ID
	private String cgl_zrj;	//总容积(m3)
	private String cgl_cgsl;	//储罐数量
	private String cgl_cgjg;	//储罐间隔
	private String cgl_ccjzms;	//存储介质描述
	private String cgl_jsfzr;	//技术负责人
	private String cgl_jsfzrdh;	//技术负责人电话
	private String cgl_plqkd;	//罐组毗邻情况(东)
	private String cgl_plqkn;	//罐组毗邻情况(南)
	private String cgl_plqkx;	//罐组毗邻情况(西)
	private String cgl_plqkb;	//罐组毗邻情况(北)
	private String cgl_deleteFlag;	//删除标志
	private String cgl_datasource;	//数据来源[100000一体化]
	//private String cgl_bz;	//备注
	private String cgl_jdh;	//节点号
	private String cgl_sjc;	//时间戳
	private String cgl_reserve1;	//备用字段1
	private String cgl_reserve2;	//备用字段2
	private String cgl_reserve3;	//备用字段3
	private String cgl_reserve4;	//备用字段4
	private List<ChuguanVO> ChuguanList;	//储罐list
	private String zddwid;	//重点单位id
	private Map<String, List> firefacilites;//消防设施
	private Map<String, Object> aqssss;//word安全疏散设施

	public Map<String, Object> getAqssss() {
		return aqssss;
	}

	public void setAqssss(Map<String, Object> aqssss) {
		this.aqssss = aqssss;
	}

	public String getJzid() {
		return jzid;
	}
	public void setJzid(String jzid) {
		this.jzid = jzid;
	}
	public String getJzmc() {
		return jzmc;
	}
	public void setJzmc(String jzmc) {
		this.jzmc = jzmc;
	}
	public String getJzlx() {
		return jzlx;
	}
	public void setJzlx(String jzlx) {
		this.jzlx = jzlx;
	}
	public String getJzwz() {
		return jzwz;
	}
	public void setJzwz(String jzwz) {
		this.jzwz = jzwz;
	}
	public String getLon(){
		return lon;
	}
	public void setLon(String lon){
		this.lon = lon;
	}
	public String getLat(){
		return lat;
	}
	public void setLat(String lat){
		this.lat = lat;
	}
	public String getXqxclx(){
		return xqxclx;
	}
	public void setXqxclx(String xqxclx){
		this.xqxclx = xqxclx;
	}
	public String getYjddsc(){
		return yjddsc;
	}
	public void setYjddsc(String yjddsc){
		this.yjddsc = yjddsc;
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

	public String getJzlxmc() {
		return jzlxmc;
	}
	public void setJzlxmc(String jzlxmc) {
		this.jzlxmc = jzlxmc;
	}

	public String getJzl_uuid() {
		return jzl_uuid;
	}
	public void setJzl_uuid(String jzl_uuid) {
		this.jzl_uuid = jzl_uuid;
	}
	public String getJzl_jzid() {
		return jzl_jzid;
	}
	public void setJzl_jzid(String jzl_jzid) {
		this.jzl_jzid = jzl_jzid;
	}
	public String getJzl_jzqk() {
		return jzl_jzqk;
	}
	public void setJzl_jzqk(String jzl_jzqk) {
		this.jzl_jzqk = jzl_jzqk;
	}
	public String getJzl_jzsyxz() {
		return jzl_jzsyxz;
	}
	public void setJzl_jzsyxz(String jzl_jzsyxz) {
		this.jzl_jzsyxz = jzl_jzsyxz;
	}
	public String getJzl_jzjg() {
		return jzl_jzjg;
	}
	public void setJzl_jzjg(String jzl_jzjg) {
		this.jzl_jzjg = jzl_jzjg;
	}
	public String getJzl_gnms() {
		return jzl_gnms;
	}
	public void setJzl_gnms(String jzl_gnms) {
		this.jzl_gnms = jzl_gnms;
	}
	public String getJzl_zdmj() {
		return jzl_zdmj;
	}
	public void setJzl_zdmj(String jzl_zdmj) {
		this.jzl_zdmj = jzl_zdmj;
	}
	public String getJzl_jzmj() {
		return jzl_jzmj;
	}
	public void setJzl_jzmj(String jzl_jzmj) {
		this.jzl_jzmj = jzl_jzmj;
	}
	public String getJzl_dsgd() {
		return jzl_dsgd;
	}
	public void setJzl_dsgd(String jzl_dsgd) {
		this.jzl_dsgd = jzl_dsgd;
	}
	public String getJzl_dxgd() {
		return jzl_dxgd;
	}
	public void setJzl_dxgd(String jzl_dxgd) {
		this.jzl_dxgd = jzl_dxgd;
	}
	public String getJzl_dscs() {
		return jzl_dscs;
	}
	public void setJzl_dscs(String jzl_dscs) {
		this.jzl_dscs = jzl_dscs;
	}
	public String getJzl_dxcs() {
		return jzl_dxcs;
	}
	public void setJzl_dxcs(String jzl_dxcs) {
		this.jzl_dxcs = jzl_dxcs;
	}
	public String getJzl_deleteFlag() {
		return jzl_deleteFlag;
	}
	public void setJzl_deleteFlag(String jzl_deleteFlag) {
		this.jzl_deleteFlag = jzl_deleteFlag;
	}
	public String getJzl_datasource() {
		return jzl_datasource;
	}
	public void setJzl_datasource(String jzl_datasource) {
		this.jzl_datasource = jzl_datasource;
	}
	public String getJzl_jdh() {
		return jzl_jdh;
	}
	public void setJzl_jdh(String jzl_jdh) {
		this.jzl_jdh = jzl_jdh;
	}
	public String getJzl_sjc() {
		return jzl_sjc;
	}
	public void setJzl_sjc(String jzl_sjc) {
		this.jzl_sjc = jzl_sjc;
	}
	public String getJzl_reserve1() {
		return jzl_reserve1;
	}
	public void setJzl_reserve1(String jzl_reserve1) {
		this.jzl_reserve1 = jzl_reserve1;
	}
	public String getJzl_reserve2() {
		return jzl_reserve2;
	}
	public void setJzl_reserve2(String jzl_reserve2) {
		this.jzl_reserve2 = jzl_reserve2;
	}
	public String getJzl_reserve3() {
		return jzl_reserve3;
	}
	public void setJzl_reserve3(String jzl_reserve3) {
		this.jzl_reserve3 = jzl_reserve3;
	}
	public String getJzl_reserve4() {
		return jzl_reserve4;
	}
	public void setJzl_reserve4(String jzl_reserve4) {
		this.jzl_reserve4 = jzl_reserve4;
	}

	public String getJzl_jzqkmc() {
		return jzl_jzqkmc;
	}
	public void setJzl_jzqkmc(String jzl_jzqkmc) {
		this.jzl_jzqkmc = jzl_jzqkmc;
	}
	public String getJzl_jzsyxzmc() {
		return jzl_jzsyxzmc;
	}
	public void setJzl_jzsyxzmc(String jzl_jzsyxzmc) {
		this.jzl_jzsyxzmc = jzl_jzsyxzmc;
	}
	public String getJzl_jzjgmc() {
		return jzl_jzjgmc;
	}
	public void setJzl_jzjgmc(String jzl_jzjgmc) {
		this.jzl_jzjgmc = jzl_jzjgmc;
	}
	public String getJzl_dsgd_min() {
		return jzl_dsgd_min;
	}
	public void setJzl_dsgd_min(String jzl_dsgd_min) {
		this.jzl_dsgd_min = jzl_dsgd_min;
	}
	public String getJzl_dsgd_max() {
		return jzl_dsgd_max;
	}
	public void setJzl_dsgd_max(String jzl_dsgd_max) {
		this.jzl_dsgd_max = jzl_dsgd_max;
	}

	public String getZzl_uuid() {
		return zzl_uuid;
	}
	public void setZzl_uuid(String zzl_uuid) {
		this.zzl_uuid = zzl_uuid;
	}
	public String getZzl_jzid() {
		return zzl_jzid;
	}
	public void setZzl_jzid(String zzl_jzid) {
		this.zzl_jzid = zzl_jzid;
	}
	public String getZzl_jzjg() {
		return zzl_jzjg;
	}
	public void setZzl_jzjg(String zzl_jzjg) {
		this.zzl_jzjg = zzl_jzjg;
	}
	public String getZzl_zdmj() {
		return zzl_zdmj;
	}
	public void setZzl_zdmj(String zzl_zdmj) {
		this.zzl_zdmj = zzl_zdmj;
	}
	public String getZzl_zzzc() { return zzl_zzzc; }
	public void setZzl_zzzc(String zzl_zzzc) { this.zzl_zzzc = zzl_zzzc; }
	public String getZzl_zzgd() {
		return zzl_zzgd;
	}
	public void setZzl_zzgd(String zzl_zzgd) {
		this.zzl_zzgd = zzl_zzgd;
	}
	public String getZzl_jsfzr() {
		return zzl_jsfzr;
	}
	public void setZzl_jsfzr(String zzl_jsfzr) {
		this.zzl_jsfzr = zzl_jsfzr;
	}
	public String getZzl_jsfzrdh() {
		return zzl_jsfzrdh;
	}
	public void setZzl_jsfzrdh(String zzl_jsfzrdh) {
		this.zzl_jsfzrdh = zzl_jsfzrdh;
	}
	public String getZzl_ylxx() { return zzl_ylxx; }
	public void setZzl_ylxx(String zzl_ylxx) { this.zzl_ylxx = zzl_ylxx; }
	public String getZzl_cwxx() { return zzl_cwxx; }
	public void setZzl_cwxx(String zzl_cwxx) { this.zzl_cwxx = zzl_cwxx; }
	public String getZzl_gylc() {
		return zzl_gylc;
	}
	public void setZzl_gylc(String zzl_gylc) {
		this.zzl_gylc = zzl_gylc;
	}
	public String getZzl_cjrid() {
		return zzl_cjrid;
	}
	public void setZzl_cjrid(String zzl_cjrid) {
		this.zzl_cjrid = zzl_cjrid;
	}
	public String getZzl_cjrmc() {
		return zzl_cjrmc;
	}
	public void setZzl_cjrmc(String zzl_cjrmc) {
		this.zzl_cjrmc = zzl_cjrmc;
	}
	public String getZzl_cjsj() {
		return zzl_cjsj;
	}
	public void setZzl_cjsj(String zzl_cjsj) {
		this.zzl_cjsj = zzl_cjsj;
	}
	public String getZzl_xgrid() {
		return zzl_xgrid;
	}
	public void setZzl_xgrid(String zzl_xgrid) {
		this.zzl_xgrid = zzl_xgrid;
	}
	public String getZzl_xgrmc() {
		return zzl_xgrmc;
	}
	public void setZzl_xgrmc(String zzl_xgrmc) {
		this.zzl_xgrmc = zzl_xgrmc;
	}

	public String getZzl_deleteFlag() {
		return zzl_deleteFlag;
	}
	public void setZzl_deleteFlag(String zzl_deleteFlag) {
		this.zzl_deleteFlag = zzl_deleteFlag;
	}
	public String getZzl_datasource() {
		return zzl_datasource;
	}
	public void setZzl_datasource(String zzl_datasource) {
		this.zzl_datasource = zzl_datasource;
	}
	public String getZzl_jdh() {
		return zzl_jdh;
	}
	public void setZzl_jdh(String zzl_jdh) {
		this.zzl_jdh = zzl_jdh;
	}
	public String getZzl_sjc() {
		return zzl_sjc;
	}
	public void setZzl_sjc(String zzl_sjc) {
		this.zzl_sjc = zzl_sjc;
	}
	public String getZzl_reserve1() {
		return zzl_reserve1;
	}
	public void setZzl_reserve1(String zzl_reserve1) {
		this.zzl_reserve1 = zzl_reserve1;
	}
	public String getZzl_reserve2() {
		return zzl_reserve2;
	}
	public void setZzl_reserve2(String zzl_reserve2) {
		this.zzl_reserve2 = zzl_reserve2;
	}
	public String getZzl_reserve3() {
		return zzl_reserve3;
	}
	public void setZzl_reserve3(String zzl_reserve3) {
		this.zzl_reserve3 = zzl_reserve3;
	}
	public String getZzl_reserve4() {
		return zzl_reserve4;
	}
	public void setZzl_reserve4(String zzl_reserve4) {
		this.zzl_reserve4 = zzl_reserve4;
	}

	public String getZzl_jzjgmc() {
		return zzl_jzjgmc;
	}
	public void setZzl_jzjgmc(String zzl_jzjgmc) {
		this.zzl_jzjgmc = zzl_jzjgmc;
	}

	public String getCgl_uuid() {
		return cgl_uuid;
	}
	public void setCgl_uuid(String cgl_uuid) {
		this.cgl_uuid = cgl_uuid;
	}

	public String getCgl_jzid() {
		return cgl_jzid;
	}
	public void setCgl_jzid(String cgl_jzid) {
		this.cgl_jzid = cgl_jzid;
	}
	public String getCgl_zrj() {
		return cgl_zrj;
	}
	public void setCgl_zrj(String cgl_zrj) {
		this.cgl_zrj = cgl_zrj;
	}
	public String getCgl_cgsl() {
		return cgl_cgsl;
	}
	public void setCgl_cgsl(String cgl_cgsl) {
		this.cgl_cgsl = cgl_cgsl;
	}
	public String getCgl_cgjg() {
		return cgl_cgjg;
	}
	public void setCgl_cgjg(String cgl_cgjg) {
		this.cgl_cgjg = cgl_cgjg;
	}
	public String getCgl_ccjzms() {
		return cgl_ccjzms;
	}
	public void setCgl_ccjzms(String cgl_ccjzms) {
		this.cgl_ccjzms = cgl_ccjzms;
	}
	public String getCgl_jsfzr() {
		return cgl_jsfzr;
	}
	public void setCgl_jsfzr(String cgl_jsfzr) {
		this.cgl_jsfzr = cgl_jsfzr;
	}
	public String getCgl_jsfzrdh() {
		return cgl_jsfzrdh;
	}
	public void setCgl_jsfzrdh(String cgl_jsfzrdh) {
		this.cgl_jsfzrdh = cgl_jsfzrdh;
	}
	public String getCgl_plqkd() {
		return cgl_plqkd;
	}
	public void setCgl_plqkd(String cgl_plqkd) {
		this.cgl_plqkd = cgl_plqkd;
	}
	public String getCgl_plqkn() {
		return cgl_plqkn;
	}
	public void setCgl_plqkn(String cgl_plqkn) {
		this.cgl_plqkn = cgl_plqkn;
	}
	public String getCgl_plqkx() {
		return cgl_plqkx;
	}
	public void setCgl_plqkx(String cgl_plqkx) {
		this.cgl_plqkx = cgl_plqkx;
	}
	public String getCgl_plqkb() {
		return cgl_plqkb;
	}
	public void setCgl_plqkb(String cgl_plqkb) {
		this.cgl_plqkb = cgl_plqkb;
	}

	public String getCgl_deleteFlag() {
		return cgl_deleteFlag;
	}
	public void setCgl_deleteFlag(String cgl_deleteFlag) {
		this.cgl_deleteFlag = cgl_deleteFlag;
	}
	public String getCgl_datasource() {
		return cgl_datasource;
	}
	public void setCgl_datasource(String cgl_datasource) {
		this.cgl_datasource = cgl_datasource;
	}
	public String getCgl_jdh() {
		return cgl_jdh;
	}
	public void setCgl_jdh(String cgl_jdh) {
		this.cgl_jdh = cgl_jdh;
	}
	public String getCgl_sjc() {
		return cgl_sjc;
	}
	public void setCgl_sjc(String cgl_sjc) {
		this.cgl_sjc = cgl_sjc;
	}
	public String getCgl_reserve1() {
		return cgl_reserve1;
	}
	public void setCgl_reserve1(String cgl_reserve1) {
		this.cgl_reserve1 = cgl_reserve1;
	}
	public String getCgl_reserve2() {
		return cgl_reserve2;
	}
	public void setCgl_reserve2(String cgl_reserve2) {
		this.cgl_reserve2 = cgl_reserve2;
	}
	public String getCgl_reserve3() {
		return cgl_reserve3;
	}
	public void setCgl_reserve3(String cgl_reserve3) {
		this.cgl_reserve3 = cgl_reserve3;
	}
	public String getCgl_reserve4() {
		return cgl_reserve4;
	}
	public void setCgl_reserve4(String cgl_reserve4) {
		this.cgl_reserve4 = cgl_reserve4;
	}
	public List<ChuguanVO> getChuguanList() {return ChuguanList; }
	public void setChuguanList(List<ChuguanVO> chuguanList) { ChuguanList = chuguanList; }

	public String getZddwid() {
		return zddwid;
	}
	public void setZddwid(String zddwid) {
		this.zddwid = zddwid;
	}

	public Map<String, List> getFirefacilites() {
		return firefacilites;
	}
	public void setFirefacilites(Map<String, List> firefacilites) {
		this.firefacilites = firefacilites;
	}
}