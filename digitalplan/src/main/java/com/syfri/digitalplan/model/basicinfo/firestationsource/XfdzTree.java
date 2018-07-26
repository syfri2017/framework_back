package com.syfri.digitalplan.model.basicinfo.firestationsource;

import java.util.List;

public class XfdzTree {
	private String dzid;
	private String dzjc;
	private List<XfdzTree> children;

	public XfdzTree() {
	}

	public XfdzTree(String dzid, String dzjc) {
		this.dzid = dzid;
		this.dzjc = dzjc;
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

	public List<XfdzTree> getChildren() {
		return children;
	}

	public void setChildren(List<XfdzTree> children) {
		this.children = children;
	}
}
