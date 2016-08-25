package com.ctfo.quartz.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Paginator<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int count =0;
	private List<T> data = new ArrayList<T>();
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}
	public List<T> getData(){
		return this.data;
	}
	public void setData(List<T> data){
		this.data = data;
	}
}
