package com.syfri.digitalplan.model.basicinfo.firestationsource;

import java.io.Serializable;
import java.util.List;

public class XfdzTree implements Serializable{

	private static final long serialVersionUID = 1L;

	private String dzid;
	private String dzjc;
	private String dzbm;
	private List<XfdzTree> children;

	public XfdzTree() {
	}

	public XfdzTree(String dzid, String dzjc, String dzbm) {
		this.dzid = dzid;
		this.dzjc = dzjc;
		this.dzbm = dzbm;
	}

	public String getDzid() {
		return dzid;
	}

	public void setDzid(String dzid) {
		this.dzid = dzid;
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

	public List<XfdzTree> getChildren() {
		return children;
	}

	public void setChildren(List<XfdzTree> children) {
		this.children = children;
	}
}
