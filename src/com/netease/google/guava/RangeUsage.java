package com.netease.google.guava;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Functions;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;

public class RangeUsage {

    public static void range(){
        System.out.println(Range.open(1, 4).lowerEndpoint());
        System.out.println(Range.open(1, 4).upperEndpoint());
        System.out.println(Range.closed(3, 5).isConnected(Range.open(5, 10))); 
        System.out.println(Range.closed(0, 9).isConnected(Range.closed(3, 4)));
        System.out.println(Range.closed(0, 5).isConnected(Range.closed(3, 9))); 
        System.out.println(Range.openClosed(3, 5).isConnected(Range.open(5, 10))); 
        System.out.println(Range.closed(1, 5).isConnected(Range.closed(5, 10)));
    }
    public static void main(String[] args) {
        range();
    }
}
