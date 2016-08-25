package com.ctfo.mongodb.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public abstract class CtfoMongoBasicEntity implements Serializable {

	protected static final long serialVersionUID = 7352012449125584805L;
	
	@Id
	protected ObjectId id;
	
	public abstract String toString();

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

}
