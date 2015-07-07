package com.netease.module.programma;

public class Man implements Person{
	
	private Long height;
	
	public String getName() {
		return "SuperMan";
	}
	
	public String getSex() {
		return "Man";
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	};
	

}
