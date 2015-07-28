package com.netease.apache.common;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.functors.InstanceofPredicate;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class PredicateUsages {
	public static void predicateUsages(){
		
		Predicate instance = InstanceofPredicate.getInstance(String.class);
		Predicate notNull = NotNullPredicate.getInstance();
		Predicate selfPredicate = new Predicate() {
			
			public boolean evaluate(Object paramObject) {
				String para = (String)paramObject;
				return StringUtils.isAlphanumeric(para) && para.length() >= 10;
			}
		};
		
		String content = "ABCD1234!";
		Predicate lst = PredicateUtils.allPredicate(ImmutableList.of(instance, notNull,selfPredicate));
		System.out.println(lst.evaluate(content));
	}
	
	public static void main(String[] args) {
		predicateUsages();
	}
}
