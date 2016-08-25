package com.sinoiov.yyzc.commons.config.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.CappedAt;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.utils.IndexDirection;

@Entity(value="log_yyzc_param_operation", noClassnameStored=true, cap=@CappedAt(1024*1024*1000))
public class ParameterOperLogs implements Serializable{

	private static final long serialVersionUID = -41639079711241651L;
	
	@Id
	private ObjectId id;
	
	@Indexed
	private String param_key;
	
	private String system;
	
	private Object old_value;
	
	private Object new_value;
	
	@Indexed(value=IndexDirection.DESC)
	private String operateTime;
	
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

	public Object getOld_value() {
		return old_value;
	}

	public void setOld_value(Object old_value) {
		this.old_value = old_value;
	}

	public Object getNew_value() {
		return new_value;
	}

	public void setNew_value(Object new_value) {
		this.new_value = new_value;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}
	
}
