package com.netease.java.module;

public class Women implements Person {
	private String age;
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return "SuperWomen";
	};
	
	public String getSex() {
		return "Women";
	};

}
