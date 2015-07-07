package com.netease.module.programma;

/**
 * 采用 接口--抽象类--实体类 
 * 接口限制 T extends
 * 抽象类限制 T extentds 同时传递给接口 T
 * 具体实现类，直接定义了抽象类的T，从而确定了 接口的T 
 * 
 * BaseStreamHander -ManStreameHandler
 * 					-WomenStreamHandler
 * @author zhoushaojun
 *
 * @param <T>
 */

public interface StreamHandler<T extends Person> {
	
	public String handlerProcess(T t);
	
	public String getHandlerName();

}
