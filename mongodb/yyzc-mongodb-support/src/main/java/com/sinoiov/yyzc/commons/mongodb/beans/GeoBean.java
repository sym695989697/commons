package com.sinoiov.yyzc.commons.mongodb.beans;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.utils.IndexDirection;

public class GeoBean implements Serializable{
	
	private static final long serialVersionUID = -6586865239079259616L;

	private String type;
	
	@Indexed(IndexDirection.GEO2D)
	private double[] coordinates;
	
	public GeoBean(double x, double y){
		this.type = "Point";
		this.coordinates = new double[]{x, y};
	}

	public GeoBean(){
		
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}
}