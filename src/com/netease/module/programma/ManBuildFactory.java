package com.netease.module.programma;

public class ManBuildFactory implements PersonBuildFactory<Long>{
	
	public Person build(Long t) {
		Man man = new Man();
		man.setHeight(t);
		return man;
	}

}
