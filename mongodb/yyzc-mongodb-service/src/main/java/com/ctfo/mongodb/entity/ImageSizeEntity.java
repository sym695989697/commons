package com.ctfo.mongodb.entity;

public class ImageSizeEntity implements java.io.Serializable{

	private static final long serialVersionUID = -2269923415797628324L;

	/**
	 * 宽度
	 */
	private int minWidth = 0;
	/**
	 * 高度
	 */
	private int minHeight = 0;
	/**
	 * 是否添加水印
	 */
	private boolean minWater = false;
	/**
	 * 是否等比缩放
	 */
	private boolean minThumb = true;
	
	private int midWidth = 0;
	
	private int midHeight = 0;
	
	private boolean midWater = false;
	
	private boolean midThumb = true;
	
	private int maxWidth = 0;
	
	private int maxHeight = 0;
	
	private boolean maxWater = false;
	
	private boolean maxThumb = true;

	public int getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(int minWidth) {
		this.minWidth = minWidth;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}

	public boolean isMinWater() {
		return minWater;
	}

	public void setMinWater(boolean minWater) {
		this.minWater = minWater;
	}

	public boolean isMinThumb() {
		return minThumb;
	}

	public void setMinThumb(boolean minThumb) {
		this.minThumb = minThumb;
	}

	public int getMidWidth() {
		return midWidth;
	}

	public void setMidWidth(int midWidth) {
		this.midWidth = midWidth;
	}

	public int getMidHeight() {
		return midHeight;
	}

	public void setMidHeight(int midHeight) {
		this.midHeight = midHeight;
	}

	public boolean isMidWater() {
		return midWater;
	}

	public void setMidWater(boolean midWater) {
		this.midWater = midWater;
	}

	public boolean isMidThumb() {
		return midThumb;
	}

	public void setMidThumb(boolean midThumb) {
		this.midThumb = midThumb;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	public boolean isMaxWater() {
		return maxWater;
	}

	public void setMaxWater(boolean maxWater) {
		this.maxWater = maxWater;
	}

	public boolean isMaxThumb() {
		return maxThumb;
	}

	public void setMaxThumb(boolean maxThumb) {
		this.maxThumb = maxThumb;
	}
	
}
