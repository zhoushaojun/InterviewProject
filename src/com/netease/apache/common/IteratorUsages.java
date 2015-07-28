package com.netease.apache.common;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.iterators.ArrayIterator;
import org.apache.commons.collections.iterators.FilterIterator;
import org.apache.commons.collections.iterators.LoopingIterator;
import org.apache.commons.collections.iterators.LoopingListIterator;
import org.apache.commons.lang3.StringUtils;

public class IteratorUsages {
	
	public static void iterator(){
		List<Issue> issues = Arrays.asList(ComparatorUsages.issues);
		
		ArrayIterator arrayIterator = new ArrayIterator(ComparatorUsages.issues, 0, 3);
		while(arrayIterator.hasNext()){
			System.out.println(arrayIterator.next());
		}
		
		System.out.println(StringUtils.center("loop", 40));
		
		LoopingIterator loopingIterator = new LoopingIterator(issues);
//		while(loopingIterator.hasNext()){
//			System.out.println(loopingIterator.next());
//		}
		
		LoopingListIterator loopingListIterator = new LoopingListIterator(issues);
		while(loopingListIterator.hasNext()){
			System.out.println(loopingListIterator.next());
		}
		
		
		FilterIterator filterIterator = new FilterIterator(loopingIterator, new Predicate() {
			
			public boolean evaluate(Object paramObject) {
				return ((Issue)paramObject).getSeverity().equals("Major");
			}
		});
//		while(filterIterator.hasNext()){
//			System.out.println(filterIterator.next());
//		}
		
	}
	public static void main(String[] args) {
		iterator();
	}
}
