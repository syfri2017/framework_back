package com.syfri.userservice.model.system;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class MailVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String username;	//邮箱名称
	private String password;	//邮箱密码
	private String encoding;	//传输编码
	private String host;	//邮箱SMTP服务器
	private Integer port;	//端口
	private String protocol;	//QQ邮箱生成授权码：
	private String state;	//是否可用
	private String term;	//期限（有效日期）
	private String deleteFlag;	//删除标志
	private String createId;	//创建人ID
	private String createName;	//创建人
	private String createTime;	//创建时间
	private String alterId;	//修改人ID
	private String alterName;	//修改人
	private String alterTime;	//修改时间
	private String reserve1;	//备用1
	private String reserve2;	//备用2
	private String reserve3;	//备用3

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getEncoding(){
		return encoding;
	}
	public void setEncoding(String encoding){
		this.encoding = encoding;
	}
	public String getHost(){
		return host;
	}
	public void setHost(String host){
		this.host = host;
	}
	public Integer getPort(){
		return port;
	}
	public void setPort(Integer port){
		this.port = port;
	}
	public String getProtocol(){
		return protocol;
	}
	public void setProtocol(String protocol){
		this.protocol = protocol;
	}
	public String getStatue(){
		return state;
	}
	public void setStatue(String state){
		this.state = state;
	}
	public String getTerm(){
		return term;
	}
	public void setTerm(String term){
		this.term = term;
	}
	public String getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	public String getCreateId(){
		return createId;
	}
	public void setCreateId(String createId){
		this.createId = createId;
	}
	public String getCreateName(){
		return createName;
	}
	public void setCreateName(String createName){
		this.createName = createName;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}
	public String getAlterId(){
		return alterId;
	}
	public void setAlterId(String alterId){
		this.alterId = alterId;
	}
	public String getAlterName(){
		return alterName;
	}
	public void setAlterName(String alterName){
		this.alterName = alterName;
	}
	public String getAlterTime(){
		return alterTime;
	}
	public void setAlterTime(String alterTime){
		this.alterTime = alterTime;
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
}