package com.netease.temp.test;

public class ThreadLocalTest {
	
	public static void localTest(){
		ThreadLocal<String> local = new ThreadLocal<String>(){
			
			@Override
			protected String initialValue() {
				return "zhousdf";
			}
		};
		
		///local.set("zhou");
		System.out.println(local.get());
	}
	public static void main(String[] args) {
		localTest();
		System.out.println(new ThreadLocalTest().getClass().getName());
	}
}
