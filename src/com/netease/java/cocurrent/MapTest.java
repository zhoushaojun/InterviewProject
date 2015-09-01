package com.netease.java.cocurrent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;






import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class MapTest {
	private static LinkedHashMap<String, String> lHashMapPut = new LinkedHashMap<String, String>(1,0.75f, false);
	private static LinkedHashMap<String, String> lHashMapRead = new LinkedHashMap<String, String>(1,0.75f, true);
	
	public static void testGoogleCopyOf(){
		List<String> dataList = new ArrayList<String>();
		dataList.add("a");
		dataList.add("b");
		dataList.add("c");
		dataList.add("d");
		
		List<String> dataList2 = new ArrayList<String>();
		dataList2.add("a");
		dataList2.add("b");
		
		
		
	}
	public static void  lhashmapPutTest(){
		lHashMapPut.put("1", "a");
		lHashMapPut.put("2", "b");
		lHashMapPut.put("3", "c");
		
		lHashMapPut.get("1");
		
		readMap(lHashMapPut);
	}
	
	
	public static void  lhashmapReadTest(){
		lHashMapRead.put("1", "a");
		lHashMapRead.put("2", "b");
		lHashMapRead.put("3", "c");
		
		lHashMapRead.get("2");
		
		readMap(lHashMapRead);
		
	}
	
	public static void readMap(LinkedHashMap< String,String> map){
		Set<Entry<String, String>> keys = map.entrySet();
		for (Entry<String, String> entry : keys) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		//lhashmapPutTest();
		//lhashmapReadTest();
		testGoogleCopyOf();
		Object obj = new Long(100);
		System.out.println(obj.toString());
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	}
}
