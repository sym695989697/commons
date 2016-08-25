package com.sinoiov.yyzc.commons.config.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

@Entity(value="yyzc_parameters", noClassnameStored=true)
public class Parameter implements Serializable{
	
	private static final long serialVersionUID = 197337940727774329L;

	@Id
	private ObjectId id;
	
	@Indexed
	private String param_key;
	
	private Object param_value;
	
	private String system;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getParam_key() {
		return param_key;
	}

	public void setParam_key(String param_key) {
		this.param_key = param_key;
	}

	public Object getParam_value() {
		return param_value;
	}

	public void setParam_value(Object param_value) {
		this.param_value = param_value;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}
	
}
