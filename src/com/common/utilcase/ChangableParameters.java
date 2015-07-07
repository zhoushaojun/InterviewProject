package com.common.utilcase;
/**
 * 可变参数测试
 * @author zhoushaojun
 *
 */
public class ChangableParameters {

	public static void printf(String value, String... args){
		System.out.println(args.length);
		
		if(null != args){
			for (String string : args) {
				System.out.println(string);
			}
		}
	}
	
	public static void main(String[] args) {
		printf("");
		printf("1");
		printf("1", "ss");
		printf("1", new String[]{"2","3"});
		//可以创建 实例数组，创建好的实例数组均为空null
		ChangableParameters[] parameters = new ChangableParameters[10];
		for (ChangableParameters changableParameters : parameters) {
			System.out.println(changableParameters);
		}
	}
}
