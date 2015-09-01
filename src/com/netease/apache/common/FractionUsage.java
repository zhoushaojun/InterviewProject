package com.netease.apache.common;

import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.lang3.math.Fraction;

import com.google.common.collect.Maps;

public class FractionUsage {
    private static Fraction fraction = Fraction.getFraction(34, 101);
    
    public static void usage(){
        System.out.println(fraction.reduce());
        System.out.println(fraction.doubleValue());
    }
    public static void main(String[] args) {
        usage();
        
        Random random = new Random();
        TreeMap<String, Integer> dat = Maps.newTreeMap();
        for (int i = 0; i < 200000; i++) {
            int key = random.nextInt(10);
            if(dat.get(String.valueOf(key))!= null){
                int value =dat.get(String.valueOf(key));
                dat.put(String.valueOf(key), ++value);
            }else{
                dat.put(String.valueOf(key), 1);
            }
        }
        int count = 0;
        for (Entry<String, Integer> ele : dat.entrySet()) {
            System.out.println("key : " + ele.getKey() + " value : " + ele.getValue());
            count += ele.getValue();
        }
        System.out.println(count);
    }
}
