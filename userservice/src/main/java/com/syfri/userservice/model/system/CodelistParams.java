package com.syfri.userservice.model.system;

import com.syfri.baseapi.model.ValueObject;

import java.io.Serializable;
import java.util.List;

public class CodelistParams extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String codetype;
	private List<Integer> list;

	public String getCodetype() { return codetype; }
	public void setCodetype(String codetype) { this.codetype = codetype; }
	public List<Integer> getList() { return list; }
	public void setList(List<Integer> list) { this.list = list; }
}