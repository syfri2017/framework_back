package com.syfri.digitalplan.model.basicinfo.watersource;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class XfsyVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

    private String uuid;	//undefined
    private String sybm;	//undefined
    private String symc;	//undefined
    private String sydz;	//undefined
    private String sylx;	//undefined
    private String sysxxxid;	//undefined
    private String gxdz;	//undefined
    private String gxdzmc;	//undefined
    private String xzqh;	//undefined
    private String ssdw;	//undefined
    private String kyzt;	//undefined
    private String sygs;	//undefined
    private String gisX;	//undefined
    private String gisY;	//undefined
    private String gisH;	//undefined
    private String lon;	//undefined
    private String lat;	//undefined
    private String gsdw;	//undefined
    private String gsdwlxfs;	//undefined
    private String deleteFlag;	//undefined
    private String datasource;	//undefined
    private String bz;	//undefined
    private String jdh;	//undefined
    private String sjc;	//undefined
    private String reserve1;	//undefined
    private String reserve2;	//undefined
    private String reserve3;	//undefined
    private String reserve4;	//undefined
    private String cjrid;
    private String cjrmc;
    private String cjsj;
    private String xgrid;
    private String xgrmc;
    private String xgsj;

    private String sylxmc;  //水源类型名称
	private String xzqhmc;    //行政区域名称
	private String kyztmc;  //可用状态
    private String sygsmc;	//水源归属名称
	private String dzjc;  //队站简称
	private String dzbm; //队站编码
	private String gisX_min;	//GIS_X
	private String gisX_max;	//GIS_X
	private String gisY_min;	//GIS_Y
	private String gisY_max;	//GIS_Y

    //消火栓属性信息
    private String xhs_uuid;	//主键
    private String xhs_szxs;	//设置形式
    private String xhs_gwylfw;
    private String xhs_gwxs;
    private String xhs_gwzj;
    private String xhs_gwyllx;
    private String xhs_jkxs;
    private String xhs_jkkj;
    private String xhs_zdll;
    private String xhs_deleteFlag;	//删除标志
    private String xhs_datasource;	//数据来源[100000一体化]
    private String xhs_jdh;	//节点号
    private String xhs_sjc;	//时间戳
    private String xhs_reserve1;	//备用字段1
    private String xhs_reserve2;	//备用字段2
    private String xhs_reserve3;	//备用字段3
    private String xhs_reserve4;	//备用字段4

	private String xhs_szxsmc; //设置形式名称
	private String xhs_gwxsmc;  //管网形式名称
	private String xhs_jkxsmc;  //接口形式名称
    private String xhs_gwyllxmc; //管网压力类型名称

    //消防水池属性信息
    private String xfsc_uuid;	//主键
    private String xfsc_sybgc;	//水源标高差
    private String xfsc_csl;	//储水量
    private String xfsc_jsll;	//进水流量
    private String xfsc_qszdll;	//取水最大流量(L/S)
    private String xfsc_gwxs;	//管网形式
    private String xfsc_tcwz;	//停车位置
    private String xfsc_tsqscls;	//停车数量
    private String xfsc_deleteFlag;	//删除标志
    private String xfsc_datasource;	//数据来源[100000一体化]
    private String xfsc_jdh;	//节点号
    private String xfsc_sjc;	//时间戳
    private String xfsc_reserve1;	//备用字段1
    private String xfsc_reserve2;	//备用字段2
    private String xfsc_reserve3;	//备用字段3
    private String xfsc_reserve4;	//备用字段4
    private String xfsc_bssj;	//补水时间

	private String xfsc_gwxsmc;	//管网形式名称

    //消防水鹤属性信息
    private String xfsh_uuid;	//主键
    private String xfsh_gwzj;	//管网直径
    private String xfsh_gwyl;	//管网压力
    private String xfsh_cskgd;	//出水口高度
    private String xfsh_zdll;	//最大流量
    private String xfsh_deleteFlag;	//删除标志
    private String xfsh_datasource;	//数据来源[100000一体化]
    private String xfsh_jdh;	//节点号
    private String xfsh_sjc;	//时间戳
    private String xfsh_reserve1;	//备用字段1
    private String xfsh_reserve2;	//备用字段2
    private String xfsh_reserve3;	//备用字段3
    private String xfsh_reserve4;	//备用字段4


    //天然水源取水点属性信息
    private String trsyqsd_uuid;	//主键
    private String trsyqsd_sybgc;	//水源标高差(m)
    private String trsyqsd_tcwz;	//停车位置
    private String trsyqsd_tsqscls;	//同时取水车辆数
    private String trsyqsd_qsxs;	//取水形式
    private String trsyqsd_trsyid;	//天然水源ID
    private String trsyqsd_deleteFlag;	//删除标志
    private String trsyqsd_datasource;	//数据来源
    private String trsyqsd_jdh;	//节点号
    private String trsyqsd_sjc;	//时间戳
    private String trsyqsd_reserve1;	//备用字段1
    private String trsyqsd_reserve2;	//备用字段2
    private String trsyqsd_reserve3;	//备用字段3
    private String trsyqsd_reserve4;	//备用字段4

    private String trsyqsd_qsxsmc;	//取水形式名称

    //天然水源属性信息
    private String trsy_uuid;	//主键
    private String trsy_trsylx;	//天然水源类型
    private String trsy_sz;	//水质
    private String trsy_szms;	//水质描述
    private String trsy_ywksq;	//有无枯水期
    private String trsy_ksqsj;	//枯水期时间
    private String trsy_ywqsd;//有无取水点
    private String trsy_deleteFlag;	//删除标志
    private String trsy_datasource;	//数据来源[100000一体化]
    private String trsy_jdh;	//节点号
    private String trsy_sjc;	//时间戳
    private String trsy_reserve1;	//备用字段1
    private String trsy_reserve2;	//备用字段2
    private String trsy_reserve3;	//备用字段3
    private String trsy_reserve4;	//备用字段4

	private String trsy_trsylxmc;	//天然水源类型名称
	private String trsy_szmc;	//水质名称
	private String trsy_ywksqmc;	//有无枯水期名称

    public String getUuid(){
        return uuid;
    }
    public void setUuid(String uuid){
        this.uuid = uuid;
    }
    public String getSybm(){
        return sybm;
    }
    public void setSybm(String sybm){
        this.sybm = sybm;
    }
    public String getSymc(){
        return symc;
    }
    public void setSymc(String symc){
        this.symc = symc;
    }
    public String getSydz(){
        return sydz;
    }
    public void setSydz(String sydz){
        this.sydz = sydz;
    }
    public String getSylx(){
        return sylx;
    }
    public void setSylx(String sylx){
        this.sylx = sylx;
    }
    public String getSysxxxid(){
        return sysxxxid;
    }
    public void setSysxxxid(String sysxxxid){
        this.sysxxxid = sysxxxid;
    }
    public String getGxdz(){
        return gxdz;
    }
    public void setGxdz(String gxdz){
        this.gxdz = gxdz;
    }
    public String getGxdzmc(){
        return gxdzmc;
    }
    public void setGxdzmc(String gxdzmc){
        this.gxdzmc = gxdzmc;
    }
    public String getXzqh(){
        return xzqh;
    }
    public void setXzqh(String xzqh){
        this.xzqh = xzqh;
    }
    public String getSsdw(){
        return ssdw;
    }
    public void setSsdw(String ssdw){
        this.ssdw = ssdw;
    }
    public String getKyzt(){
        return kyzt;
    }
    public void setKyzt(String kyzt){
        this.kyzt = kyzt;
    }
    public String getSygs(){
        return sygs;
    }
    public void setSygs(String sygs){
        this.sygs = sygs;
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
    public String getGisH(){
        return gisH;
    }
    public void setGisH(String gisH){
        this.gisH = gisH;
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
    public String getGsdw(){
        return gsdw;
    }
    public void setGsdw(String gsdw){
        this.gsdw = gsdw;
    }
    public String getGsdwlxfs(){
        return gsdwlxfs;
    }
    public void setGsdwlxfs(String gsdwlxfs){
        this.gsdwlxfs = gsdwlxfs;
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

    public String getSygsmc() {
        return sygsmc;
    }
    public void setSygsmc(String sygsmc) {
        this.sygsmc = sygsmc;
    }

    public String getXhs_uuid() {
        return xhs_uuid;
    }
    public void setXhs_uuid(String xhs_uuid) {
        this.xhs_uuid = xhs_uuid;
    }
    public String getXhs_szxs() {
        return xhs_szxs;
    }
    public void setXhs_szxs(String xhs_szxs) {
        this.xhs_szxs = xhs_szxs;
    }
    public String getXhs_gwylfw() {
        return xhs_gwylfw;
    }
    public void setXhs_gwylfw(String xhs_gwylfw) {
        this.xhs_gwylfw = xhs_gwylfw;
    }
    public String getXhs_gwxs() {
        return xhs_gwxs;
    }
    public void setXhs_gwxs(String xhs_gwxs) {
        this.xhs_gwxs = xhs_gwxs;
    }
    public String getXhs_gwzj() {
        return xhs_gwzj;
    }
    public void setXhs_gwzj(String xhs_gwzj) {
        this.xhs_gwzj = xhs_gwzj;
    }
    public String getXhs_gwyllx() {
        return xhs_gwyllx;
    }
    public void setXhs_gwyllx(String xhs_gwyllx) {
        this.xhs_gwyllx = xhs_gwyllx;
    }
    public String getXhs_jkxs() {
        return xhs_jkxs;
    }
    public void setXhs_jkxs(String xhs_jkxs) {
        this.xhs_jkxs = xhs_jkxs;
    }
    public String getXhs_jkkj() {
        return xhs_jkkj;
    }
    public void setXhs_jkkj(String xhs_jkkj) {
        this.xhs_jkkj = xhs_jkkj;
    }
    public String getXhs_zdll() {
        return xhs_zdll;
    }
    public void setXhs_zdll(String xhs_zdll) {
        this.xhs_zdll = xhs_zdll;
    }
    public String getXhs_deleteFlag() {
        return xhs_deleteFlag;
    }
    public void setXhs_deleteFlag(String xhs_deleteFlag) {
        this.xhs_deleteFlag = xhs_deleteFlag;
    }
    public String getXhs_datasource() {
        return xhs_datasource;
    }
    public void setXhs_datasource(String xhs_datasource) {
        this.xhs_datasource = xhs_datasource;
    }
    public String getXhs_jdh() {
        return xhs_jdh;
    }
    public void setXhs_jdh(String xhs_jdh) {
        this.xhs_jdh = xhs_jdh;
    }
    public String getXhs_sjc() {
        return xhs_sjc;
    }
    public void setXhs_sjc(String xhs_sjc) {
        this.xhs_sjc = xhs_sjc;
    }
    public String getXhs_reserve1() {
        return xhs_reserve1;
    }
    public void setXhs_reserve1(String xhs_reserve1) {
        this.xhs_reserve1 = xhs_reserve1;
    }
    public String getXhs_reserve2() {
        return xhs_reserve2;
    }
    public void setXhs_reserve2(String xhs_reserve2) {
        this.xhs_reserve2 = xhs_reserve2;
    }
    public String getXhs_reserve3() {
        return xhs_reserve3;
    }
    public void setXhs_reserve3(String xhs_reserve3) {
        this.xhs_reserve3 = xhs_reserve3;
    }
    public String getXhs_reserve4() {
        return xhs_reserve4;
    }
    public void setXhs_reserve4(String xhs_reserve4) {
        this.xhs_reserve4 = xhs_reserve4;
    }
    public String getXhs_gwyllxmc() {
        return xhs_gwyllxmc;
    }
    public void setXhs_gwyllxmc(String xhs_gwyllxmc) {
        this.xhs_gwyllxmc = xhs_gwyllxmc;
    }

    public String getXfsc_uuid() {
        return xfsc_uuid;
    }
    public void setXfsc_uuid(String xfsc_uuid) {
        this.xfsc_uuid = xfsc_uuid;
    }
    public String getXfsc_sybgc() {
        return xfsc_sybgc;
    }
    public void setXfsc_sybgc(String xfsc_sybgc) {
        this.xfsc_sybgc = xfsc_sybgc;
    }
    public String getXfsc_csl() {
        return xfsc_csl;
    }
    public void setXfsc_csl(String xfsc_csl) {
        this.xfsc_csl = xfsc_csl;
    }
    public String getXfsc_jsll() {
        return xfsc_jsll;
    }
    public void setXfsc_jsll(String xfsc_jsll) {
        this.xfsc_jsll = xfsc_jsll;
    }
    public String getXfsc_qszdll() {
        return xfsc_qszdll;
    }
    public void setXfsc_qszdll(String xfsc_qszdll) {
        this.xfsc_qszdll = xfsc_qszdll;
    }
    public String getXfsc_gwxs() {
        return xfsc_gwxs;
    }
    public void setXfsc_gwxs(String xfsc_gwxs) {
        this.xfsc_gwxs = xfsc_gwxs;
    }
    public String getXfsc_tcwz() {
        return xfsc_tcwz;
    }
    public void setXfsc_tcwz(String xfsc_tcwz) {
        this.xfsc_tcwz = xfsc_tcwz;
    }
    public String getXfsc_tsqscls() {
        return xfsc_tsqscls;
    }
    public void setXfsc_tsqscls(String xfsc_tsqscls) {
        this.xfsc_tsqscls = xfsc_tsqscls;
    }
    public String getXfsc_deleteFlag() {
        return xfsc_deleteFlag;
    }
    public void setXfsc_deleteFlag(String xfsc_deleteFlag) {
        this.xfsc_deleteFlag = xfsc_deleteFlag;
    }
    public String getXfsc_datasource() {
        return xfsc_datasource;
    }
    public void setXfsc_datasource(String xfsc_datasource) {
        this.xfsc_datasource = xfsc_datasource;
    }
    public String getXfsc_jdh() {
        return xfsc_jdh;
    }
    public void setXfsc_jdh(String xfsc_jdh) {
        this.xfsc_jdh = xfsc_jdh;
    }
    public String getXfsc_sjc() {
        return xfsc_sjc;
    }
    public void setXfsc_sjc(String xfsc_sjc) {
        this.xfsc_sjc = xfsc_sjc;
    }
    public String getXfsc_reserve1() {
        return xfsc_reserve1;
    }
    public void setXfsc_reserve1(String xfsc_reserve1) {
        this.xfsc_reserve1 = xfsc_reserve1;
    }
    public String getXfsc_reserve2() {
        return xfsc_reserve2;
    }
    public void setXfsc_reserve2(String xfsc_reserve2) {
        this.xfsc_reserve2 = xfsc_reserve2;
    }
    public String getXfsc_reserve3() {
        return xfsc_reserve3;
    }
    public void setXfsc_reserve3(String xfsc_reserve3) {
        this.xfsc_reserve3 = xfsc_reserve3;
    }
    public String getXfsc_reserve4() {
        return xfsc_reserve4;
    }
    public void setXfsc_reserve4(String xfsc_reserve4) {
        this.xfsc_reserve4 = xfsc_reserve4;
    }
    public String getXfsc_bssj() {
        return xfsc_bssj;
    }
    public void setXfsc_bssj(String xfsc_bssj) {
        this.xfsc_bssj = xfsc_bssj;
    }

    public String getXfsh_uuid() {
        return xfsh_uuid;
    }
    public void setXfsh_uuid(String xfsh_uuid) {
        this.xfsh_uuid = xfsh_uuid;
    }
    public String getXfsh_gwyl() {
        return xfsh_gwyl;
    }
    public void setXfsh_gwyl(String xfsh_gwyl) {
        this.xfsh_gwyl = xfsh_gwyl;
    }
    public String getXfsh_deleteFlag() {
        return xfsh_deleteFlag;
    }
    public void setXfsh_deleteFlag(String xfsh_deleteFlag) {
        this.xfsh_deleteFlag = xfsh_deleteFlag;
    }
    public String getXfsh_datasource() {
        return xfsh_datasource;
    }
    public void setXfsh_datasource(String xfsh_datasource) {
        this.xfsh_datasource = xfsh_datasource;
    }
    public String getXfsh_jdh() {
        return xfsh_jdh;
    }
    public void setXfsh_jdh(String xfsh_jdh) {
        this.xfsh_jdh = xfsh_jdh;
    }
    public String getXfsh_sjc() {
        return xfsh_sjc;
    }
    public void setXfsh_sjc(String xfsh_sjc) {
        this.xfsh_sjc = xfsh_sjc;
    }
    public String getXfsh_reserve1() {
        return xfsh_reserve1;
    }
    public void setXfsh_reserve1(String xfsh_reserve1) {
        this.xfsh_reserve1 = xfsh_reserve1;
    }
    public String getXfsh_reserve2() {
        return xfsh_reserve2;
    }
    public void setXfsh_reserve2(String xfsh_reserve2) {
        this.xfsh_reserve2 = xfsh_reserve2;
    }
    public String getXfsh_reserve3() {
        return xfsh_reserve3;
    }
    public void setXfsh_reserve3(String xfsh_reserve3) {
        this.xfsh_reserve3 = xfsh_reserve3;
    }
    public String getXfsh_reserve4() {
        return xfsh_reserve4;
    }
    public void setXfsh_reserve4(String xfsh_reserve4) {
        this.xfsh_reserve4 = xfsh_reserve4;
    }
    public String getXfsh_gwzj() {
        return xfsh_gwzj;
    }
    public void setXfsh_gwzj(String xfsh_gwzj) {
        this.xfsh_gwzj = xfsh_gwzj;
    }
    public String getXfsh_cskgd() {
        return xfsh_cskgd;
    }
    public void setXfsh_cskgd(String xfsh_cskgd) {
        this.xfsh_cskgd = xfsh_cskgd;
    }
    public String getXfsh_zdll() {
        return xfsh_zdll;
    }
    public void setXfsh_zdll(String xfsh_zdll) {
        this.xfsh_zdll = xfsh_zdll;
    }

    public String getTrsyqsd_uuid() {
        return trsyqsd_uuid;
    }
    public void setTrsyqsd_uuid(String trsyqsd_uuid) {
        this.trsyqsd_uuid = trsyqsd_uuid;
    }
    public String getTrsyqsd_sybgc() {
        return trsyqsd_sybgc;
    }
    public void setTrsyqsd_sybgc(String trsyqsd_sybgc) {
        this.trsyqsd_sybgc = trsyqsd_sybgc;
    }
    public String getTrsyqsd_tcwz() {
        return trsyqsd_tcwz;
    }
    public void setTrsyqsd_tcwz(String trsyqsd_tcwz) {
        this.trsyqsd_tcwz = trsyqsd_tcwz;
    }
    public String getTrsyqsd_tsqscls() {
        return trsyqsd_tsqscls;
    }
    public void setTrsyqsd_tsqscls(String trsyqsd_tsqscls) {
        this.trsyqsd_tsqscls = trsyqsd_tsqscls;
    }
    public String getTrsyqsd_qsxs() {
        return trsyqsd_qsxs;
    }
    public void setTrsyqsd_qsxs(String trsyqsd_qsxs) {
        this.trsyqsd_qsxs = trsyqsd_qsxs;
    }
    public String getTrsyqsd_trsyid() {
        return trsyqsd_trsyid;
    }
    public void setTrsyqsd_trsyid(String trsyqsd_trsyid) {
        this.trsyqsd_trsyid = trsyqsd_trsyid;
    }
    public String getTrsyqsd_deleteFlag() {
        return trsyqsd_deleteFlag;
    }
    public void setTrsyqsd_deleteFlag(String trsyqsd_deleteFlag) {
        this.trsyqsd_deleteFlag = trsyqsd_deleteFlag;
    }
    public String getTrsyqsd_datasource() {
        return trsyqsd_datasource;
    }
    public void setTrsyqsd_datasource(String trsyqsd_datasource) {
        this.trsyqsd_datasource = trsyqsd_datasource;
    }
    public String getTrsyqsd_jdh() {
        return trsyqsd_jdh;
    }
    public void setTrsyqsd_jdh(String trsyqsd_jdh) {
        this.trsyqsd_jdh = trsyqsd_jdh;
    }
    public String getTrsyqsd_sjc() {
        return trsyqsd_sjc;
    }
    public void setTrsyqsd_sjc(String trsyqsd_sjc) {
        this.trsyqsd_sjc = trsyqsd_sjc;
    }
    public String getTrsyqsd_reserve1() {
        return trsyqsd_reserve1;
    }
    public void setTrsyqsd_reserve1(String trsyqsd_reserve1) {
        this.trsyqsd_reserve1 = trsyqsd_reserve1;
    }
    public String getTrsyqsd_reserve2() {
        return trsyqsd_reserve2;
    }
    public void setTrsyqsd_reserve2(String trsyqsd_reserve2) {
        this.trsyqsd_reserve2 = trsyqsd_reserve2;
    }
    public String getTrsyqsd_reserve3() {
        return trsyqsd_reserve3;
    }
    public void setTrsyqsd_reserve3(String trsyqsd_reserve3) {
        this.trsyqsd_reserve3 = trsyqsd_reserve3;
    }
    public String getTrsyqsd_reserve4() {
        return trsyqsd_reserve4;
    }
    public void setTrsyqsd_reserve4(String trsyqsd_reserve4) {
        this.trsyqsd_reserve4 = trsyqsd_reserve4;
    }

    public String getTrsy_uuid() {
        return trsy_uuid;
    }
    public void setTrsy_uuid(String trsy_uuid) {
        this.trsy_uuid = trsy_uuid;
    }
    public String getTrsy_trsylx() {
        return trsy_trsylx;
    }
    public void setTrsy_trsylx(String trsy_trsylx) {
        this.trsy_trsylx = trsy_trsylx;
    }
    public String getTrsy_sz() {
        return trsy_sz;
    }
    public void setTrsy_sz(String trsy_sz) {
        this.trsy_sz = trsy_sz;
    }
    public String getTrsy_ywksq() {
        return trsy_ywksq;
    }
    public void setTrsy_ywksq(String trsy_ywksq) {
        this.trsy_ywksq = trsy_ywksq;
    }
    public String getTrsy_szms() {
        return trsy_szms;
    }
    public void setTrsy_szms(String trsy_szms) {
        this.trsy_szms = trsy_szms;
    }
    public String getTrsy_ksqsj() {
        return trsy_ksqsj;
    }
    public void setTrsy_ksqsj(String trsy_ksqsj) {
        this.trsy_ksqsj = trsy_ksqsj;
    }
    public String getTrsy_ywqsd() {
        return trsy_ywqsd;
    }
    public void setTrsy_ywqsd(String trsy_ywqsd) {
        this.trsy_ywqsd = trsy_ywqsd;
    }
    public String getTrsy_deleteFlag() {
        return trsy_deleteFlag;
    }
    public void setTrsy_deleteFlag(String trsy_deleteFlag) {
        this.trsy_deleteFlag = trsy_deleteFlag;
    }
    public String getTrsy_datasource() {
        return trsy_datasource;
    }
    public void setTrsy_datasource(String trsy_datasource) {
        this.trsy_datasource = trsy_datasource;
    }
    public String getTrsy_jdh() {
        return trsy_jdh;
    }
    public void setTrsy_jdh(String trsy_jdh) {
        this.trsy_jdh = trsy_jdh;
    }
    public String getTrsy_sjc() {
        return trsy_sjc;
    }
    public void setTrsy_sjc(String trsy_sjc) {
        this.trsy_sjc = trsy_sjc;
    }
    public String getTrsy_reserve1() {
        return trsy_reserve1;
    }
    public void setTrsy_reserve1(String trsy_reserve1) {
        this.trsy_reserve1 = trsy_reserve1;
    }
    public String getTrsy_reserve2() {
        return trsy_reserve2;
    }
    public void setTrsy_reserve2(String trsy_reserve2) {
        this.trsy_reserve2 = trsy_reserve2;
    }
    public String getTrsy_reserve3() {
        return trsy_reserve3;
    }
    public void setTrsy_reserve3(String trsy_reserve3) {
        this.trsy_reserve3 = trsy_reserve3;
    }
    public String getTrsy_reserve4() {
        return trsy_reserve4;
    }
    public void setTrsy_reserve4(String trsy_reserve4) {
        this.trsy_reserve4 = trsy_reserve4;
    }

	public String getSylxmc() {
		return sylxmc;
	}
	public void setSylxmc(String sylxmc) {
		this.sylxmc = sylxmc;
	}
    public String getXzqhmc() {
        return xzqhmc;
    }
    public void setXzqhmc(String xzqhmc) {
        this.xzqhmc = xzqhmc;
    }
    public String getXhs_szxsmc() {
		return xhs_szxsmc;
	}
	public void setXhs_szxsmc(String xhs_szxsmc) {
		this.xhs_szxsmc = xhs_szxsmc;
	}
	public String getXhs_gwxsmc() {
		return xhs_gwxsmc;
	}
	public void setXhs_gwxsmc(String xhs_gwxsmc) {
		this.xhs_gwxsmc = xhs_gwxsmc;
	}
	public String getXhs_jkxsmc() {
		return xhs_jkxsmc;
	}
	public void setXhs_jkxsmc(String xhs_jkxsmc) {
		this.xhs_jkxsmc = xhs_jkxsmc;
	}
	public String getXfsc_gwxsmc() {
		return xfsc_gwxsmc;
	}
	public void setXfsc_gwxsmc(String xfsc_gwxsmc) {
		this.xfsc_gwxsmc = xfsc_gwxsmc;
	}

    public String getTrsyqsd_qsxsmc() {
        return trsyqsd_qsxsmc;
    }
    public void setTrsyqsd_qsxsmc(String trsyqsd_qsxsmc) {
        this.trsyqsd_qsxsmc = trsyqsd_qsxsmc;
    }
    public String getTrsy_trsylxmc() {
		return trsy_trsylxmc;
	}
	public void setTrsy_trsylxmc(String trsy_trsylxmc) {
		this.trsy_trsylxmc = trsy_trsylxmc;
	}
	public String getTrsy_szmc() {
		return trsy_szmc;
	}
	public void setTrsy_szmc(String trsy_szmc) {
		this.trsy_szmc = trsy_szmc;
	}
	public String getTrsy_ywksqmc() {
		return trsy_ywksqmc;
	}
	public void setTrsy_ywksqmc(String trsy_ywksqmc) {
		this.trsy_ywksqmc = trsy_ywksqmc;
	}

	public String getKyztmc() {
		return kyztmc;
	}
	public void setKyztmc(String kyztmc) {
		this.kyztmc = kyztmc;
	}

	public String getDzjc() {
		return dzjc;
	}
	public void setDzjc(String dzjc) {
		this.dzjc = dzjc;
	}
	public String getDzbm() {
		return dzbm;
	}
	public void setDzbm(String dzbm) {
		this.dzbm = dzbm;
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
}