package com.netease.java.module;

/**
 * ���� �ӿ�--������--ʵ���� 
 * �ӿ����� T extends
 * ���������� T extentds ͬʱ���ݸ��ӿ� T
 * ����ʵ���ֱ࣬�Ӷ����˳������T���Ӷ�ȷ���� �ӿڵ�T 
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
