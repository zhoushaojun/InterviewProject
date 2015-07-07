package com.netease.module.programma;

public class ManStreamHandler extends BaseStreamHandler<Man>{

	public String handlerProcess(Man man) {
		String result = man.getName()+":"+man.getSex()+":"+man.getHeight();
		return result;
	}
	

}
