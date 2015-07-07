package com.netease.module.programma;
/**
 * 
 * @author zhoushaojun
 *
 */
public class ManTester {
	
	@SuppressWarnings({ "unchecked" })
	public static void test(){
		// 确定 工厂生产器
		PersonBuildFactory<Long> manBuildFactory = new ManBuildFactory();
		// 确定流处理器
		StreamHandler streamHandler = new ManStreamHandler();
		String result = streamHandler.handlerProcess(manBuildFactory.build(188L));
		System.out.println(result);
	}
	public static void main(String[] args) {
		test();
	}
}
