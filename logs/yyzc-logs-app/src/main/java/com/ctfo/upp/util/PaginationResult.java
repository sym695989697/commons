package com.ctfo.upp.util;

import java.io.Serializable;
import java.util.Collection;


public class PaginationResult<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int pageSize = 10;
	
	private Collection<T> data;
	
	private int start;
	
	private int total;
	
	private String message;
	
	private Object dataObject;
		
	
	//@JSON(name = "Rows")  
	public Collection<T> getData() {
		return data;
	}
	public void setData(Collection<T> data) {
		this.data = data;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	//@JSON(name = "Total")  
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}	
	public int getPageSize() {
		return pageSize;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getDataObject() {
		return dataObject;
	}
	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}
	
	

}
