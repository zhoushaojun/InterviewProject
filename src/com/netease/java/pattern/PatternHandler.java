package com.netease.java.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternHandler {
	public static final Pattern DEFAULT_KEY_TAG_PATTERN = Pattern.compile("\\{(.*?)\\}");
	
	/**
	 *  matcher.find ȷ���Ƿ����ƥ��
	 *  matcher.match ��ѯ����Ƿ�ƥ��ɹ�
	 *  matcher.mater ����ƥ����
	 *  mather.group(0)����ȫ��ƥ����
	 *  mather.group(1)����()->��һ������ƥ����
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
