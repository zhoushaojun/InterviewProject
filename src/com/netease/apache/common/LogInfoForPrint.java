package com.netease.apache.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class LogInfoForPrint {
    private Map<String, String> param = Maps.newLinkedHashMap();
    public  Map<? super Object, ? super Object> paramNo = Maps.newLinkedHashMap();
    public  static List<? super Object> paList  =  new ArrayList<Object>();
    
    public LogInfoForPrint addParam(String key, String value){
        param.put(key, value);
        paList.add(this);
        LogInfoForPrint ii = (LogInfoForPrint)paList.get(0);
        return this;
    }
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
    public static void main(String[] args) {
        LogInfoForPrint logInfoForPrint = new LogInfoForPrint();
        logInfoForPrint.addParam("name", "zhou").addParam("age", "27");
        System.out.println(logInfoForPrint.toString());
        
        logInfoForPrint.paramNo.put("1", "zhou");
        logInfoForPrint.paramNo.put(1, 1.23);
        System.out.println(logInfoForPrint.paramNo.get("1"));
        System.out.println(logInfoForPrint.paramNo.get(1));
        
        paList.add(logInfoForPrint);
        paList.get(0);
    }
}
