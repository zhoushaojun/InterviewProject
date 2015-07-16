package com.netease.java.module;

public class WomenStreamHandler extends BaseStreamHandler<Women> {
	
	public String handlerProcess(Women women) {
		String result = women.getName()+":"+women.getSex();
		return result;
	}

}
