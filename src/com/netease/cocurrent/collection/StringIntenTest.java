package com.netease.cocurrent.collection;

import java.util.concurrent.locks.ReentrantLock;

public class StringIntenTest {
	public static void test(){
		String uid = "zhoushaojun123".intern();
		
		for (int i=0; i<10 ; i++) {
			if("zhoushaojun123".equals(new String("zhoushaojun123"))){
				System.out.println("true");
			}
		}
		ReentrantLock lock = new ReentrantLock();
	}
	public static void main(String[] args) {
		test();
	}
}
