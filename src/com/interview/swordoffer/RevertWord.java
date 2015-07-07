package com.interview.swordoffer;

/**
 * Source : abcdefgh Target : cdefghab
 * 
 * So first look at the target compare with source First , revert the target:
 * bahgfedc ba + hgfedc
 * 
 * 
 * @author zhoushaojun
 * 
 */
public class RevertWord {

	private static String str = "abcdefgh";

	public static String revertEntry() {
		int index = 2;
		char[] first = str.substring(0, index).toCharArray();
		char[] second = str.substring(index).toCharArray();
		StringBuilder builder = new StringBuilder();
		builder.append(revert(first));
		builder.append(revert(second));
		return revert(builder.toString().toCharArray());
	}

	public static String revert(char[] array) {
		if (null == array || array.length == 0)
			return null;
		int index = array.length / 2;
		int length = array.length - 1;
		char temp;
		for (int i = 0; i < index; i++) {
			temp = array[i];
			array[i] =  array[length - i];
			array[length - i] = temp;
		}
		return new String(array);
	}

	public static void main(String[] args) {
		System.out.println(RevertWord.revertEntry());
	}
}
