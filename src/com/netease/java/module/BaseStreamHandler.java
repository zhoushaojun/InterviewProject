package com.netease.java.module;

public abstract class BaseStreamHandler <T extends Person> implements StreamHandler<T>{

	public String getHandlerName() {
		return this.getClass().getName();
	}
}
