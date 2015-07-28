package com.netease.apache.common;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.SwitchTransformer;
import org.apache.commons.lang3.StringUtils;

public class TransformUsages {
	
	public static void transform(){
		
		
		Predicate predicate = new Predicate() {
			
			@Override
			public boolean evaluate(Object paramObject) {
				Issue issue = (Issue)paramObject;
				if(null != issue && StringUtils.isAlphanumeric(issue.getSeverity())){
					return true;
				}
				return false;
			}
		};
		
		Predicate[] predicates = new Predicate[]{predicate};
		
		Transformer transformer = new Transformer() {
			
			public Object transform(Object paramObject) {
				Issue issue = (Issue)paramObject;
				return new Issue(1, "zhoushaojun", issue.getOwner());
			}
		};
		
		Transformer[] transformers = new Transformer[]{transformer};
		
		Transformer lstTransformer = new SwitchTransformer(predicates, transformers, null);
		
		Collection result = CollectionUtils.collect(Arrays.asList(ComparatorUsages.issues), lstTransformer);
		
		Iterator<Issue> iterator = result.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
		
	}
	public static void main(String[] args) {
		transform();
	}
	
}
