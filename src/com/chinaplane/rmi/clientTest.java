package com.chinaplane.rmi;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

public class clientTest {
	public static void main(String[] args) {
		try {
			
			Hello hello = (Hello)Naming.lookup("rmi://localhost:12312/hello");
			System.out.println(hello.hello());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void test(){
		List<Integer> my = new ArrayList<Integer>();
		my.add(1);
		my.add(3);my.add(2);
		
		
		List<String> my2 = new ArrayList<String>();
		my2.add("1");
		my2.add("2");
		//my2.add("3");
		
		System.out.println(getsize(my));
		System.out.println(getsize(my2));
	}
	public static int getsize(List obj){
		//obj.add("e");
		return obj.size();
	}
}
