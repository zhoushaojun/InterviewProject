package com.netease.java.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.collect.Maps;

public class UniqueRandom {

    public static String[] date = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y","z"};
    public static HashMap<String, String> hashMap = Maps.newHashMap();
    public static int count = 0;
    public static void test(){
        List<String> dataList = Arrays.asList(date);
        List<String> coList = new ArrayList<String>(dataList);
        int count = 0;
        StringBuilder builder = new StringBuilder();
        while(count <= 15){
            int index = RandomUtils.nextInt(coList.size()-1);
            builder.append(coList.get(index));
            //System.out.println(index);
            coList.remove(index);
           count++; 
        }
        
        if(hashMap.containsKey(builder.toString())){
            System.out.println("already contain");
        }else {
            hashMap.put(builder.toString(), builder.toString());
        }
        
    }
    
    
    public static void testrand(){
        String contentString = RandomStringUtils.randomAlphanumeric(8);
        System.out.println(contentString);
        if(hashMap.containsKey(contentString)){
            System.out.println("already contain "+contentString);
            count ++;
        }else {
            hashMap.put(contentString, contentString);
        }
        
    }
    
    public static void main(String[] args) {
        for ( ;;) {
            testrand();    
        }
        
    }
}
