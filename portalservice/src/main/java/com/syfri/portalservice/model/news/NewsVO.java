package com.syfri.portalservice.model.news;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import com.syfri.baseapi.model.ValueObject;

public class NewsVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String xwid;	//新闻ID
	private String xwbt;	//新闻标题
	private String xwbtEng;	//新闻标题英文
	private String xwnr;	//新闻内容
	private String xwnrEng;	//新闻内容英文
	private byte[] xwnrBlob;	//新闻内容大字段
	private byte[] xwnrEngBlob;	//新闻内容英文大字段
	private String xwsj;	//新闻时间
	private String xwlx;	//新闻类型
	private String gjc;	//关键词
	private String iszd;	//是否置顶
	private String isxs;	//是否显示[0]否，[1]是，默认1
	private String issy;	//是否显示在首页[0]否，[1]是，默认0
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
	private String xwjs;
	private String xwjsEng;


	public byte[] getXwnrBlob() {
		return xwnrBlob;
	}

	public void setXwnrBlob(byte[] xwnrBlob)  throws Exception{
		//this.xwnrBlob = xwnrBlob;
		if(xwnrBlob !=null){
			this.xwnr= new String(xwnrBlob,"gbk");
		}
	}

	public byte[] getXwnrEngBlob() {
		return xwnrEngBlob;
	}

	public void setXwnrEngBlob(byte[] xwnrEngBlob)  throws Exception{
		this.xwnrEngBlob = xwnrEngBlob;

		if(xwnrEngBlob !=null){
			this.xwnrEng= new String(xwnrEngBlob,"gbk");
		}

	}

	public String getXwnr(){
		return xwnr;
	}
	public void setXwnr(String xwnr) throws Exception {
		//this.xwnr = xwnr;
		if(this.xwnrBlob==null){
			this.xwnrBlob=xwnr.getBytes("gbk");
		}else{
			this.xwnr = xwnr;
		}
	}
	public String getXwnrEng(){
		return xwnrEng;
	}
	public void setXwnrEng(String xwnrEng) throws Exception{
		//this.xwnrEng = xwnrEng;
		if(this.xwnrEngBlob==null){
			this.xwnrEngBlob = xwnrEng.getBytes("gbk");
		}else{
			this.xwnrEng = xwnrEng;
		}
	}


	public String getXwjs() {
		return xwjs;
	}

	public void setXwjs(String xwjs) {
		this.xwjs = xwjs;
	}

	public String getXwjsEng() {
		return xwjsEng;
	}

	public void setXwjsEng(String xwjsEng) {
		this.xwjsEng = xwjsEng;
	}

	public String getXwid(){
		return xwid;
	}
	public void setXwid(String xwid){
		this.xwid = xwid;
	}
	public String getXwbt(){
		return xwbt;
	}
	public void setXwbt(String xwbt){
		this.xwbt = xwbt;
	}
	public String getXwbtEng(){
		return xwbtEng;
	}
	public void setXwbtEng(String xwbtEng){
		this.xwbtEng = xwbtEng;
	}

	public String getXwsj(){
		return xwsj;
	}
	public void setXwsj(String xwsj){
		this.xwsj = xwsj;
	}
	public String getXwlx(){
		return xwlx;
	}
	public void setXwlx(String xwlx){
		this.xwlx = xwlx;
	}
	public String getGjc(){
		return gjc;
	}
	public void setGjc(String gjc){
		this.gjc = gjc;
	}
	public String getIszd(){
		return iszd;
	}
	public void setIszd(String iszd){
		this.iszd = iszd;
	}
	public String getIsxs(){
		return isxs;
	}
	public void setIsxs(String isxs){
		this.isxs = isxs;
	}
	public String getIssy(){
		return issy;
	}
	public void setIssy(String issy){
		this.issy = issy;
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