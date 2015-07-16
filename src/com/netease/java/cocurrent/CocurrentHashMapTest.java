package com.netease.java.cocurrent;

import java.util.concurrent.ConcurrentHashMap;

public class CocurrentHashMapTest {

	private static ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();
	
	public static void mapTest(){
		while(true){
			System.out.println(hashMap.putIfAbsent("zhou", "wang"));
			break;
		}
		
	}
	public static void main(String[] args) {
		mapTest();
	}
}
