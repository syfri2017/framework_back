package com.syfri.digitalplan.model.importantparts;

import java.io.Serializable;
import java.util.List;

import com.syfri.baseapi.model.ValueObject;
import com.syfri.digitalplan.model.buildingzoning.WeixianjiezhiVO;
import com.syfri.digitalplan.model.buildingzoning.ChuguanVO;

public class ImportantpartsVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	//重点部位基本信息
	private String zdbwid;	//重点部位ID（主键）
	private String zddwid;	//重点单位ID
	private String zdbwlx;	//重点部位类型
	private String zdbwmc;	//重点部位名称
	private String zdbwwz;	//重点部位位置
	private String wxxfx;	//危险性分析
	private String zysx;	//注意事项
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String bz;	//备注
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4

	private String zdbwlxmc;	//重点部位类型名称

	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间

	private ImportantpartsJzlVO jzl;    //重点部位-建筑类
	private ImportantpartsZzlVO zzl;    //重点部位-装置类
	private ImportantpartsCglVO cgl;    //重点部位-储罐类

	public String getZdbwid(){ return zdbwid; }
	public void setZdbwid(String zdbwid){ this.zdbwid = zdbwid; }
	public String getZddwid(){ return zddwid; }
	public void setZddwid(String zddwid){ this.zddwid = zddwid; }
	public String getZdbwlx(){ return zdbwlx; }
	public void setZdbwlx(String zdbwlx){ this.zdbwlx = zdbwlx; }
	public String getZdbwmc(){ return zdbwmc; }
	public void setZdbwmc(String zdbwmc){ this.zdbwmc = zdbwmc; }
	public String getZdbwwz(){ return zdbwwz; }
	public void setZdbwwz(String zdbwwz){ this.zdbwwz = zdbwwz; }
	public String getWxxfx(){ return wxxfx; }
	public void setWxxfx(String wxxfx){ this.wxxfx = wxxfx; }
	public String getZysx(){ return zysx; }
	public void setZysx(String zysx){ this.zysx = zysx; }
	public String getDeleteFlag(){ return deleteFlag; }
	public void setDeleteFlag(String deleteFlag){ this.deleteFlag = deleteFlag; }
	public String getDatasource(){ return datasource; }
	public void setDatasource(String datasource){ this.datasource = datasource; }
	public String getBz(){ return bz; }
	public void setBz(String bz){ this.bz = bz; }
	public String getJdh(){ return jdh; }
	public void setJdh(String jdh){ this.jdh = jdh; }
	public String getSjc(){ return sjc; }
	public void setSjc(String sjc){ this.sjc = sjc; }
	public String getReserve1(){ return reserve1; }
	public void setReserve1(String reserve1){ this.reserve1 = reserve1; }
	public String getReserve2(){ return reserve2; }
	public void setReserve2(String reserve2){ this.reserve2 = reserve2; }
	public String getReserve3(){ return reserve3; }
	public void setReserve3(String reserve3){ this.reserve3 = reserve3; }
	public String getReserve4(){ return reserve4; }
	public void setReserve4(String reserve4){ this.reserve4 = reserve4; }
	public String getZdbwlxmc() { return zdbwlxmc; }
	public void setZdbwlxmc(String zdbwlxmc) { this.zdbwlxmc = zdbwlxmc; }

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

	public ImportantpartsJzlVO getJzl() {
		return jzl;
	}
	public void setJzl(ImportantpartsJzlVO jzl) {
		this.jzl = jzl;
	}
	public ImportantpartsZzlVO getZzl() {
		return zzl;
	}
	public void setZzl(ImportantpartsZzlVO zzl) {
		this.zzl = zzl;
	}
	public ImportantpartsCglVO getCgl() {
		return cgl;
	}
	public void setCgl(ImportantpartsCglVO cgl) {
		this.cgl = cgl;
	}

}