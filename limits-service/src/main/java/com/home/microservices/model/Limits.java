package com.home.microservices.model;

public class Limits {
	
	private int minimunValue;
	private int maximumValue;
	
	public Limits(int minimunValue, int maximumValue) {
		super();
		this.minimunValue = minimunValue;
		this.maximumValue = maximumValue;
	}
	
	public int getMinimunValue() {
		return minimunValue;
	}
	public void setMinimunValue(int minimunValue) {
		this.minimunValue = minimunValue;
	}
	public int getMaximumValue() {
		return maximumValue;
	}
	public void setMaximumValue(int maximumValue) {
		this.maximumValue = maximumValue;
	}

}
