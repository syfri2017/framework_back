package com.syfri.digitalplan.model.auxiliarydecision.danger;

import java.io.Serializable;
import com.syfri.baseapi.model.ValueObject;

/**
 * @Description: 化学危险品
 * @Param:
 * @Return:
 * @Author: dongbo
 * @Modified By:
 * @Date: 2018/4/20 16:52
 */
public class DangerVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String name;	//中文名
	private String englishName;	//英文名
	private String cas;	//CAS登记号
	private String rtecs;	//RTECS号
	private String un;	//UN编号
	private String dangerId;	//中国危险货物编号
	private String expression;	//分子式
	private String type;	//类型号
	private String flag;	//包装标志
	private String alias;	//别名
	private String gbId;	//国标号
	private String property;	//性状
	private String airDetermine;	//空气中允许极限及测定
	private String waterDetermine;	//水中允许极限及测定
	private String tabu;	//禁忌物/禁忌
	private String thesaurus;	//同义词
	private String symptom;	//危险性/症状
	private String firstaid;	//急救措施/灭火
	private String defendWay;	//防护措施
	private String dispose;	//处置措施
	private String store;	//储存
	private String leakWay;	//泄漏处理
	private String traffic;	//运输
	private String caution;	//特别警示
	private String bernProperty;	//燃烧、爆炸特性
	private String mainApplication;	//主要用途
	private String poisionProperty;	//毒性
	private String seprarate;	//隔离
	private String publicSafety;	//公众安全
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String remark;	//备注
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
	private String dmz;	//类型名
	private byte[] flagFile;	//包装标志
	private String photo64;	//Base64格式图片
	private String jdh;  //节点号

	public String getPhoto64() {
		return photo64;
	}

	public void setPhoto64(String photo64) {
		this.photo64 = photo64;
	}

	public byte[] getFlagFile() {
		return flagFile;
	}

	public void setFlagFile(byte[] flagFile) {
		this.flagFile = flagFile;
	}

	public String getDmz() {
		return dmz;
	}

	public void setDmz(String dmz) {
		this.dmz = dmz;
	}

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getEnglishName(){
		return englishName;
	}
	public void setEnglishName(String englishName){
		this.englishName = englishName;
	}
	public String getCas(){
		return cas;
	}
	public void setCas(String cas){
		this.cas = cas;
	}
	public String getRtecs(){
		return rtecs;
	}
	public void setRtecs(String rtecs){
		this.rtecs = rtecs;
	}
	public String getUn(){
		return un;
	}
	public void setUn(String un){
		this.un = un;
	}
	public String getDangerId(){
		return dangerId;
	}
	public void setDangerId(String dangerId){
		this.dangerId = dangerId;
	}
	public String getExpression(){
		return expression;
	}
	public void setExpression(String expression){
		this.expression = expression;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getFlag(){
		return flag;
	}
	public void setFlag(String flag){
		this.flag = flag;
	}
	public String getAlias(){
		return alias;
	}
	public void setAlias(String alias){
		this.alias = alias;
	}
	public String getGbId(){
		return gbId;
	}
	public void setGbId(String gbId){
		this.gbId = gbId;
	}
	public String getProperty(){
		return property;
	}
	public void setProperty(String property){
		this.property = property;
	}
	public String getAirDetermine(){
		return airDetermine;
	}
	public void setAirDetermine(String airDetermine){
		this.airDetermine = airDetermine;
	}
	public String getWaterDetermine(){
		return waterDetermine;
	}
	public void setWaterDetermine(String waterDetermine){
		this.waterDetermine = waterDetermine;
	}
	public String getTabu(){
		return tabu;
	}
	public void setTabu(String tabu){
		this.tabu = tabu;
	}
	public String getThesaurus(){
		return thesaurus;
	}
	public void setThesaurus(String thesaurus){
		this.thesaurus = thesaurus;
	}
	public String getSymptom(){
		return symptom;
	}
	public void setSymptom(String symptom){
		this.symptom = symptom;
	}
	public String getFirstaid(){
		return firstaid;
	}
	public void setFirstaid(String firstaid){
		this.firstaid = firstaid;
	}
	public String getDefendWay(){
		return defendWay;
	}
	public void setDefendWay(String defendWay){
		this.defendWay = defendWay;
	}
	public String getDispose(){
		return dispose;
	}
	public void setDispose(String dispose){
		this.dispose = dispose;
	}
	public String getStore(){
		return store;
	}
	public void setStore(String store){
		this.store = store;
	}
	public String getLeakWay(){
		return leakWay;
	}
	public void setLeakWay(String leakWay){
		this.leakWay = leakWay;
	}
	public String getTraffic(){
		return traffic;
	}
	public void setTraffic(String traffic){
		this.traffic = traffic;
	}
	public String getCaution(){
		return caution;
	}
	public void setCaution(String caution){
		this.caution = caution;
	}
	public String getBernProperty(){
		return bernProperty;
	}
	public void setBernProperty(String bernProperty){
		this.bernProperty = bernProperty;
	}
	public String getMainApplication(){
		return mainApplication;
	}
	public void setMainApplication(String mainApplication){
		this.mainApplication = mainApplication;
	}
	public String getPoisionProperty(){
		return poisionProperty;
	}
	public void setPoisionProperty(String poisionProperty){
		this.poisionProperty = poisionProperty;
	}
	public String getSeprarate(){
		return seprarate;
	}
	public void setSeprarate(String seprarate){
		this.seprarate = seprarate;
	}
	public String getPublicSafety(){
		return publicSafety;
	}
	public void setPublicSafety(String publicSafety){
		this.publicSafety = publicSafety;
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
	public String getRemark(){
		return remark;
	}
	public void setRemark(String remark){
		this.remark = remark;
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
	public String getJdh() {
		return jdh;
	}
	public void setJdh(String jdh) {
		this.jdh = jdh;
	}
}
