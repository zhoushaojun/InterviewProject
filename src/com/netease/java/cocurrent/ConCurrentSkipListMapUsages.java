package com.netease.java.cocurrent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * (1)HashSet HashMap
 * 	  a:HashSet	
 * 				底层为HashMap value 放置为一个不变的对象->使用HashMap的Key
 * 	    	          使用 hashcode 判断在Hash中的下标， 然后在拉链中判断equal 判断是否相同元素
 * 	  		    HashSet 元素相同则改Value数值，Key不变；因此相同的元素在HashSet只能添加一次。
 * 	  b:HashMap  
 * 				则是 hashcode equal 进行元素判断，如果相同则更改Value覆盖
 * 
 * 	(2)ConcurrentSkipListSet ConcurrentSkipListMap线程安全 (TreeMap线程不安全)
 * 	  a: ConcurrentSkipListSet 
 * 							        底层为ConcurrentSkipListMap value 放置为一个不变的对象->使用ConcurrentSkipListMap的Key
 * 							        为排序的Set	，实现Comparable 1，0，-1。如果为0 则放置不进Set，原理使用Map的Key
 * 	  b: ConcurrentSkipListMap 
 * 						   	        排序Map,实现Comparable对Key排序。1，0，-1。如果为0则表示相同元素 覆盖Value
 * @author zhoushaojun 
 *
 */
public class ConCurrentSkipListMapUsages {

	private static ConcurrentSkipListMap<PersonUtil, String> map = new ConcurrentSkipListMap<PersonUtil, String>();
	private static ConcurrentSkipListSet<PersonUtil> set = new ConcurrentSkipListSet<PersonUtil>();
	private static TreeMap<PersonUtil, String> treeMap = Maps.newTreeMap();
	private static HashMap<PersonUtil, String> hashMap = Maps.newHashMap();
	private static HashSet<PersonUtil> hashSet = Sets.newHashSet();
	public static void usageMap(){
		
		PersonUtil p1 = new PersonUtil("zhoushaojun", 28);
		PersonUtil p2 = new PersonUtil("zhoushaojun2", 24);
		PersonUtil p3 = new PersonUtil("lengjing", 29);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		map.put(p1, "1");
		map.put(p2, "22");
		map.put(p3, "3");
		
		treeMap.put(p1, "1");
		treeMap.put(p2, "22");
		treeMap.put(p3, "3");
		
		hashMap.put(p1, "1");
		hashMap.put(p2, "22");
		hashMap.put(p3, "3");
		
		System.out.println(hashMap.size());
		//treeMap.putAll(hashMap);
//		Set<Entry<PersonUtil, String>> entries = treeMap.entrySet();
//		for (Entry<PersonUtil, String> entry : entries) {
//			System.out.println(entry.getKey().toString()+":"+entry.getValue());
//		}
		
//		System.out.println(hashSet.add(p1));
//		System.out.println(hashSet.add(p2));
//		System.out.println(hashSet.add(p3));
//		
		set.add(p1);
		set.add(p2);
		set.add(p3);
//		
		for (PersonUtil element : set) {
		System.out.println(element.toString());
		}
	}
	public static void main(String[] args) {
		usageMap();
	}
}

class PersonUtil implements Comparable<PersonUtil>{
	
	private String name;
	private int age;
	
	public PersonUtil(String nameOutter, int ageOuter) {
		this.name = nameOutter;
		this.age = ageOuter;
	}
	
	public int hashCode() {
		//return 0;
		return HashCodeBuilder.reflectionHashCode(this)+RandomUtils.nextInt();
	}
	public boolean equals(Object obj) {
		return this.name.equalsIgnoreCase(((PersonUtil)obj).name);
	}

	public int compareTo(PersonUtil o) {
		return this.age - o.age;
		//return this.age > o.age ? 1 : -1 ;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
	
		
	
}