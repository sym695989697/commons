package com.sinoiov.yyzc.common.model;

import java.io.Serializable;

public class Rule implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String field;
	private String op;
	private String value;
	private String type;
	private String ruleOp;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRuleOp() {
		return ruleOp;
	}

	public void setRuleOp(String ruleOp) {
		this.ruleOp = ruleOp;
	}
}
