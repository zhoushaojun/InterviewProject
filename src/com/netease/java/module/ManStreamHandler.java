package com.netease.java.module;

public class ManStreamHandler extends BaseStreamHandler<Man>{

	public String handlerProcess(Man man) {
		String result = man.getName()+":"+man.getSex()+":"+man.getHeight();
		return result;
	}
	

}
