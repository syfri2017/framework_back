package com.syfri.digitalplan.model.basicinfo.firestationsource;

import java.io.Serializable;
import java.util.List;

import com.syfri.baseapi.model.ValueObject;

public class XfdzVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String dzid;	//队站ID
	private String sjdzid;	//上级队站ID
	private String dzlx;	//队站类型
	private String dzbm;	//队站编码
	private String dzmc;	//队站名称
	private String dzjc;	//队站简称
	private String dzdz;	//队站地址
	private String lon;	//百度精度
	private String lat;	//百度纬度
	private String xzqh;	//行政区划
	private String lxr;	//联系人
	private String lxdh;	//联系电话
	private String czhm;	//传真号码
	private String zqcls;	//执勤车辆数(台)
	private String zbqcs;	//装备器材数(个)
	private String mhjzl;	//灭火剂总量(t)
	private String gxsys;	//管辖水源数
	private String gxzddws;	//管辖重点单位数
	private String xqmj;	//辖区面积
	private String xqfw;	//辖区范围
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String bz;	//备注
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4
	private String gisX;	//GIS_X
	private String gisY;	//GIS_Y

	private String xzqhmc;	//行政区划CODE（到区县）
	private String dzlxmc;	//队站类型名称
	private String gisX_min;	//undefined
	private String gisX_max;	//undefined
	private String gisY_min;	//undefined
	private String gisY_max;	//undefined

	private ZongdVO zongdVO;    //总队信息
	private ZhidVO zhidVO;  //支队信息
	private DadVO dadVO;  //大队信息
	private ZhongdVO zhongdVO;  //中队信息
	private QtxfdwVO qtxfdwVO;  //其他消防队伍信息

	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间

	public String getDzid(){
		return dzid;
	}
	public void setDzid(String dzid){
		this.dzid = dzid;
	}
	public String getSjdzid(){
		return sjdzid;
	}
	public void setSjdzid(String sjdzid){
		this.sjdzid = sjdzid;
	}
	public String getDzlx(){
		return dzlx;
	}
	public void setDzlx(String dzlx){
		this.dzlx = dzlx;
	}
	public String getDzbm(){
		return dzbm;
	}
	public void setDzbm(String dzbm){
		this.dzbm = dzbm;
	}
	public String getDzmc(){
		return dzmc;
	}
	public void setDzmc(String dzmc){
		this.dzmc = dzmc;
	}
	public String getDzjc(){
		return dzjc;
	}
	public void setDzjc(String dzjc){
		this.dzjc = dzjc;
	}
	public String getDzdz(){
		return dzdz;
	}
	public void setDzdz(String dzdz){
		this.dzdz = dzdz;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getXzqh(){
		return xzqh;
	}
	public void setXzqh(String xzqh){
		this.xzqh = xzqh;
	}
	public String getLxr(){
		return lxr;
	}
	public void setLxr(String lxr){
		this.lxr = lxr;
	}
	public String getLxdh(){
		return lxdh;
	}
	public void setLxdh(String lxdh){
		this.lxdh = lxdh;
	}
	public String getCzhm(){
		return czhm;
	}
	public void setCzhm(String czhm){
		this.czhm = czhm;
	}
	public String getZqcls(){
		return zqcls;
	}
	public void setZqcls(String zqcls){
		this.zqcls = zqcls;
	}
	public String getZbqcs() {
		return zbqcs;
	}
	public void setZbqcs(String zbqcs) {
		this.zbqcs = zbqcs;
	}
	public String getMhjzl() {
		return mhjzl;
	}
	public void setMhjzl(String mhjzl) {
		this.mhjzl = mhjzl;
	}
	public String getGxsys() {
		return gxsys;
	}
	public void setGxsys(String gxsys) {
		this.gxsys = gxsys;
	}
	public String getGxzddws() {
		return gxzddws;
	}
	public void setGxzddws(String gxzddws) {
		this.gxzddws = gxzddws;
	}
	public String getXqmj(){
		return xqmj;
	}
	public void setXqmj(String xqmj){
		this.xqmj = xqmj;
	}
	public String getXqfw(){
		return xqfw;
	}
	public void setXqfw(String xqfw){
		this.xqfw = xqfw;
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

	public String getXzqhmc() {
		return xzqhmc;
	}
	public void setXzqhmc(String xzqhmc) {
		this.xzqhmc = xzqhmc;
	}
	public String getDzlxmc() {
		return dzlxmc;
	}
	public void setDzlxmc(String dzlxmc) {
		this.dzlxmc = dzlxmc;
	}
	public String getGisX(){
		return gisX;
	}
	public void setGisX(String gisX){
		this.gisX = gisX;
	}
	public String getGisY(){
		return gisY;
	}
	public void setGisY(String gisY){
		this.gisY = gisY;
	}

	public String getGisX_min() {
		return gisX_min;
	}
	public void setGisX_min(String gisX_min) {
		this.gisX_min = gisX_min;
	}
	public String getGisX_max() {
		return gisX_max;
	}
	public void setGisX_max(String gisX_max) {
		this.gisX_max = gisX_max;
	}
	public String getGisY_min() {
		return gisY_min;
	}
	public void setGisY_min(String gisY_min) {
		this.gisY_min = gisY_min;
	}
	public String getGisY_max() {
		return gisY_max;
	}
	public void setGisY_max(String gisY_max) {
		this.gisY_max = gisY_max;
	}

	public ZongdVO getZongdVO() {
		return zongdVO;
	}
	public void setZongdVO(ZongdVO zongdVO) {
		this.zongdVO = zongdVO;
	}
	public ZhidVO getZhidVO() {
		return zhidVO;
	}
	public void setZhidVO(ZhidVO zhidVO) {
		this.zhidVO = zhidVO;
	}
	public DadVO getDadVO() {
		return dadVO;
	}
	public void setDadVO(DadVO dadVO) {
		this.dadVO = dadVO;
	}
	public ZhongdVO getZhongdVO() {
		return zhongdVO;
	}
	public void setZhongdVO(ZhongdVO zhongdVO) {
		this.zhongdVO = zhongdVO;
	}
	public QtxfdwVO getQtxfdwVO() {
		return qtxfdwVO;
	}
	public void setQtxfdwVO(QtxfdwVO qtxfdwVO) {
		this.qtxfdwVO = qtxfdwVO;
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
}