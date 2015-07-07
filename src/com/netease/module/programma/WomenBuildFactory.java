package com.netease.module.programma;

public class WomenBuildFactory implements PersonBuildFactory<String> {
	public Person build(String t) {
		Women women = new Women();
		women.setAge(t);
		return women;
	}

}
