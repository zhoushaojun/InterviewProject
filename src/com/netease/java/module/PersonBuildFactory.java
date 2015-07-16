package com.netease.java.module;
/**
 * "人"构造器 工厂模式
 * 使用模板T，不同工厂接受不同的参数进行构造
 * 男人工厂 接受参数Long；女人工厂接受参数String 分别进行构造
 * 最后均已Person接口进行返回
 * 
 * ManBuildFactory WomenBuildFactory
 * 
 * @author zhoushaojun
 *
 * @param <T>
 */
public interface PersonBuildFactory<T> {
	
	public Person build(T t);

}
