package com.interview.sword.offer;

/**
 * 对数值 进行平方 计算。 （1）普通平方计算 一个一个的乘以自己 进行计算 （2）改进方法 某数的8次方，计算出4次方在平方一次即可
 * 
 * @author zhoushaojun
 * 
 */
public class PowNumber {

	private static int floor = 2;
	private static int indices = -2;
	public static boolean globalError = false;

	public static double powCore(int number, int indice) {
		if (number == 0) {
			globalError = false;
			return 0;
		}
		boolean flag = indice < 0 ? true : false;
		indice = Math.abs(indice);
		double returnNum = 0.0;
		try {
			int result = powCursive(number, indice);
			returnNum = result;
			if (flag) {
				returnNum = 1.0 / result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			globalError = true;
			return 0;
		}
		return returnNum;
	}

	private static int powCursive(int number, int indice) {
		
		if(indice == 0) {
			return 1;
		}
		if(indice == 1){
			return number;
		}
		
		int result = powCursive(number, indice >> 1);
		result *= result;
		if((indice & 0x01) == 1){
			result *= number;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(powCore(floor, indices));
	}
}
