package com.netease.java.cocurrent;

import java.util.concurrent.ConcurrentHashMap;

public class CocurrentHashMapTest {

	private static ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();
	
	public static void mapTest(){
		//hashMap.put("zhou", "wang");
		while(true){
			if(hashMap.putIfAbsent("zhou", "wang") == null){
				System.out.println("putIfAbsent break");
				break;
			}else {
				boolean result = hashMap.replace("zhou", "wang","lengjing");
				if(result){
					System.out.println("replace break");
					break;
				}
			}
		}
		System.out.println(hashMap.get("zhou"));
	}
	public static void main(String[] args) {
		mapTest();
	}
}
