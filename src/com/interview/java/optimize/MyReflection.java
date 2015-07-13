package com.interview.java.optimize;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflection {

	private String pStr = "zhoushaojun";
	private String getMyStr(){
		return "lengjing";
	}
	public static void main(String[] args) throws Exception, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		MyReflection myReflection = new MyReflection();
		//Get Field
		Class test = Class.forName("JavaOptimize.MyReflection");
		Field field = test.getDeclaredField("pStr");
		field.setAccessible(true);
		System.out.println(field.get(myReflection));
		
		//Get Method
		test = Class.forName("JavaOptimize.MyReflection");
		Method method = test.getDeclaredMethod("getMyStr",null);
		method.setAccessible(true);
		String string = (String)method.invoke(myReflection, null);
		System.out.println(string);
		
	}
}
