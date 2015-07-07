package com.netease.temp.test;

public interface ParentInterface<T extends FanInterface> {

	public String myName(T t);
}
