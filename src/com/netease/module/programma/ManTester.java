package com.netease.module.programma;
/**
 * 
 * @author zhoushaojun
 *
 */
public class ManTester {
	
	@SuppressWarnings({ "unchecked" })
	public static void test(){
		// ȷ�� ����������
		PersonBuildFactory<Long> manBuildFactory = new ManBuildFactory();
		// ȷ����������
		StreamHandler streamHandler = new ManStreamHandler();
		String result = streamHandler.handlerProcess(manBuildFactory.build(188L));
		System.out.println(result);
	}
	public static void main(String[] args) {
		test();
	}
}
