package com.netease.projecttestutil;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ExtendSuperTest {
	
	public static void extendTest(ArrayList<? extends Parent> exList){
		Parent parent = exList.get(0);
		System.out.println(parent.myName());
	}
	
	public static void superTest(ArrayList<? super Parent> exList){
		exList.add(new Parent());
	}
	
	public static void main(String[] args) {
		ArrayList<Parent> data = new ArrayList<Parent>();
		superTest(data);
		extendTest(data);
	}
}
