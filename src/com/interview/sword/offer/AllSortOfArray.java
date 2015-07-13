package com.interview.sword.offer;
/**
 * 数组元素的全排列
 * （1）一个全局数组
 * （2）每次分成2部分 a | bcd  b|cd c|d 层层模式
 * （3）每次递归前互换 然后 递归运算 再次递归恢复
 * （4）每次递归开始start+1,无论其是否互换
 * 
 * @author zhoushaojun
 *
 *	全排列 是一个API，很多问题求多少种排列方法的都可以用到全排列。
 *  比如：A.8宫格皇后问题，不在同一行同一列以及同一对角线。
 *  	可以写出一种方法，然后全排列。最后检测 左右对角线，是否存在>=2的元素。
 *  	B.8个数字是否构成正方体，全部排列。然后对条件进行检测。
 */
public class AllSortOfArray {
	public static String[] data = {"a","b","c"};
	
	public static void calAllSort(int start,int length){
		if(start >= length ){
			StringBuilder builder = new StringBuilder();
			for (String str : data) {
				builder.append(str+" -> ");
			}
			System.out.println(builder.toString());
		}
		//System.out.println(start+" "+length);
		int originalStart = start;
		String temp;
		//这里 在递归前 进行 互换，每次进行递归完毕 进行互换。这样数组值保持顺序不变
		for(int i= start;i< length;i++){
			temp = data[originalStart];
			data[originalStart] = data[i];
			data[i] = temp;
		
			//这里非常重要，每次循环从 a | b c,从start+1 即从1开始，对于 b c 来讲都是 start+1
			calAllSort(start+1, length);
			
			temp = data[originalStart];
			data[originalStart] = data[i];
			data[i] = temp;
		}
	}
	public static void main(String[] args) {
		calAllSort(0, data.length);
		for (String string : data) {
			System.out.println(string);
			
		}
	}
}
