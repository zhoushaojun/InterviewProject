package com.netease.java.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternHandler {
	public static final Pattern DEFAULT_KEY_TAG_PATTERN = Pattern.compile("\\{(.*?)\\}");
	
	/**
	 *  matcher.find 确定是否存在匹配
	 *  matcher.match 查询这次是否匹配成功
	 *  matcher.mater 返回匹配结果
	 *  mather.group(0)返回全部匹配结果
	 *  mather.group(1)返回()->第一个括号匹配结果
	 *  
	 *  
	 */
	public static void test(){
		String key = "zhou+shao.jun?leng{wang.zhou}+zhou?{junkai}";
		Matcher matcher = DEFAULT_KEY_TAG_PATTERN.matcher(key);
		while(matcher.find()){
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group(0));
			System.out.println(matcher.group());
			
			System.out.println(matcher.group(1));
		}
		
	}
	public static void main(String[] args) {
		test();
	}
}
