package com.interview.sword.offer;
/**
 * 一个数组中 2个数 没有出现2次，其余均出现2次
 * 求出这两个数
 * @author zhoushaojun
 *
 */
public class GetDifferentNumInArray {

	private static int[] data = {1,2,2,1,5,6,7,5,6,7,12,13};
	
	public static void getDifferentNum(){
		int result = 0;
		for (int num : data ) {
			result ^= num;
		}	
		result = getFirstBit(result);
	
		int diffOne=0, diffTwo = 0;
		for (int num : data ) {
			 if(isBit(num, result)){
				 diffOne ^= num;
			 }else{
				 diffTwo ^= num;
			 }
		}
		System.out.println(diffOne);
		System.out.println(diffTwo);
	}
	
	public static int getFirstBit(int value){
		int num = 0;
		while(value != 0 && num < Integer.SIZE -1){
			if((value & 1) == 1) {
				break;
			}
			else {
				value = value >> 1;
				num++;
			}
		}
		return num;
	}
	public static boolean isBit(int value,int range){
		value = value >> range;
		int result = value & 1;
		if(result == 0) return false;
		else  return true;
	}
	
	public static void main(String[] args) {
		getDifferentNum();
		//System.out.println(16 >> 0);\
	}
}
