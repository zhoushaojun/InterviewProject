package com.netease.apache.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.FixedOrderComparator;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class ComparatorUsages {

	public static Issue[] issues = null;
	static {
		System.out.println(StringUtils.center(" demoComparator ", 40, "="));
		issues = new Issue[] { 
				new Issue(15102, "Major", "John"),
				new Issue(15103, "Minor", "Agnes"), 
				new Issue(15104, "Critical", "Bill"),
				new Issue(15105, "Major", "John"),
				new Issue(15106, "Major", "John"),
				new Issue(15107, "Critical", "John"),
				new Issue(15108, "Major", "Agnes"),
				new Issue(15109, "Minor", "Julie"),
				new Issue(15110, "Major", "Mary"),
				new Issue(15111, "Enhancement", "Bill"),
				new Issue(15112, "Minor", "Julie"),
				new Issue(15113, "Major", "Julie") 
		};
	}

	public static void demoComparator() {
		String[] severity = new String[]{ "Critical" , "Major" , "Minor" , "Enhancement" };
		Comparator<?> fixComparator = new FixedOrderComparator(severity);
		
		ComparatorChain comparatorChain = new ComparatorChain();
		comparatorChain.addComparator(new BeanComparator("owner"));
		comparatorChain.addComparator(new BeanComparator("severity", fixComparator));
		comparatorChain.addComparator(new BeanComparator("id"));
		
		List<Issue> issueList = Lists.newArrayList(issues);
		Collections.sort(issueList, comparatorChain);
		//Arrays.sort(issues, comparatorChain);
		
		for (Issue issue : issueList) {
			System.out.println(issue.toString());
		}
	}

	public static void main(String[] args) {
		demoComparator();
	}
	
}
