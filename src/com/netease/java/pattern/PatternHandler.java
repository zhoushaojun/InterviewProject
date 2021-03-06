package com.netease.java.pattern;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.IntRange;
import org.apache.commons.lang3.StringUtils;
import org.springside.modules.utils.Exceptions;


public class PatternHandler {
	//正则表达式()为了提取 gruop 内容，如果想匹配括号 \\(,\\)
	public static final Pattern DEFAULT_KEY_TAG_PATTERN = Pattern.compile("\\{(\\(.*?\\))\\}");
	// 匹配 <html></html>之间内容  ^为否的意思
	public static final Pattern htmlPattern = Pattern.compile("<[^>]+>(.*?)</[^>]+>");
	
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
		String key = "zhou+shao.jun?leng{(wang.zhou)}+zhou?{(junkai)}";
		Matcher matcher = DEFAULT_KEY_TAG_PATTERN.matcher(key);
		while(matcher.find()){
			//System.out.println(matcher.groupCount());
			//System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			
			//System.out.println(matcher.group(1));
		}
		
	}
	
	public static void testHtml(){
		String key = "<zhou>bei</zhou><leng>jing</leng>";
		Matcher matcher = htmlPattern.matcher(key);
		while(matcher.find()){
			System.out.println(matcher.group(1));	
		}
	    IntRange intRange = new IntRange(0, 752634);
	    System.out.println(intRange.containsInteger(752635));
	    
	    System.out.println(StringUtils.join(new Object[]{"a","b","c"},"#"));
	}
	
	public static void testMatchResult(){
	    String str = "124666154";
	    Pattern pattern = Pattern.compile("\\w+");
	    Matcher matcher = pattern.matcher(str);
	    System.out.println(matcher.matches());
	    while(matcher.find()){
            System.out.println(matcher.group());   
        }
	}
	
	public static void StringUtilTest(){
	    String str = "1-2-4";
	    //String[] arrys = StringUtils.split(str, "-|");
	    String[] arrys = StringUtils.splitByWholeSeparator(str,"");
	    for (String string : arrys) {
            System.out.println(string);
        }
	    
	}
	
	public static void main(String[] args) {
		//testHtml();
		//test();
//		String  result = "";
//		result = 0 == 0? "1" :"2";
//		System.out.println(result);
//		
//		long size = 0L;
//		System.out.println(size == 0);
	    testMatchResult();
		String str = "1234";
		System.out.println(str.replaceAll("(\\d)", "\\{1\\}a"));

	}
}

