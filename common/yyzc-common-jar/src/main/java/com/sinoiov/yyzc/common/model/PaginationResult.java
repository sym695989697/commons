package com.sinoiov.yyzc.common.model;

import java.io.Serializable;
import java.util.Collection;

public class PaginationResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageSize = 10;
	
	private Collection<T> data;
	
	private int start;
	
	private int total;
	
	private String message;
	
	private Object dataObject;
		
	
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
