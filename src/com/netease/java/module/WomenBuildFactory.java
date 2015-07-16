package com.netease.java.module;

public class WomenBuildFactory implements PersonBuildFactory<String> {
	public Person build(String t) {
		Women women = new Women();
		women.setAge(t);
		return women;
	}

}
