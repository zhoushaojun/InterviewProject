package com.netease.apache.common;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;

public class ClosureUsages {
	
	public static void closure(){
		
		Closure closure = new Closure() {
			
			public void execute(Object arg0) {
				Issue issue = (Issue)arg0;
				issue.setId(issue.getId()/100);
			}
		};
		List<Issue> isList = Arrays.asList(ComparatorUsages.issues);
		CollectionUtils.forAllDo(isList,closure);

		for (Issue issue : isList) {
			System.out.println(issue.toString());
		}
	}
	public static void main(String[] args) {
		closure();
	}
}
