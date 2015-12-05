package com.netease.google.guava;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;

public class Collection2Usage {

    public static void testCollections2() {
        // transform[1]
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<Boolean> result = Collections2.transform(names, Functions.forPredicate(Predicates.containsPattern("m")));
        for (Boolean boolean1 : result) {
            System.out.println(boolean1);
        }
        System.out.println("===========================================");
        
        // [2]transform[2]
        Function<String,Integer> f1 = new Function<String,Integer>(){  
            @Override  
            public Integer apply(String input) {  
                return input.length();  
            }  
        };  
       
        Function<Integer,Boolean> f2 = new Function<Integer,Boolean>(){  
            @Override  
            public Boolean apply(Integer input) {  
                return input % 2 == 0;  
            }  
        };  
       
        List<String> namess = Lists.newArrayList("John", "Jane", "Adam", "Tom");  
        Collection<Boolean> results = Collections2.transform(names, Functions.compose(f2, f1));
        for (Boolean boolean1 : results) {
            System.out.println(boolean1);
        }

        // [3]filter
        List<String> namesf = Lists.newArrayList("John", "Jane", "Adam", "Tom");  
        Collection<String> resultf = Collections2.filter(names, Predicates.containsPattern("a"));  
    }

    
    public static void iteratorTest(){
        Predicate<String> predicate = new Predicate<String>() {  
            @Override  
            public boolean apply(String input) {  
                return input.startsWith("A") || input.startsWith("T");  
            }  
        };  
       
        Function<String, Integer> func = new Function<String,Integer>(){  
            @Override  
            public Integer apply(String input) {  
                return input.length();  
            }  
        };  
       
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");  
        Collection<Integer> result = FluentIterable.from(names)  
                                                   .filter(predicate)  
                                                   .transform(func)  
                                                   .toList();  
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
    
    
    public static void main(String[] args) {
        iteratorTest();
    }
}
