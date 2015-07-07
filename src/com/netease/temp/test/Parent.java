package com.netease.temp.test;

public class Parent implements ParentInterface<FanImpl>{
	
	public String myName() {
		return "father";
	}

	@Override
	public String myName(FanImpl t) {
		System.out.println(t);
		t.getStr();
		return null;
	}
	public static void main(String[] args) {
		ParentInterface<FanImpl> pare = new Parent();
		pare.myName(new FanImpl());
	}
}	

class Children extends Parent{
	
	@Override
	public String myName() {
		return "son";
	}
}