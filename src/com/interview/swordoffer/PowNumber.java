package com.interview.swordoffer;

/**
 * ����ֵ ����ƽ�� ���㡣 ��1����ͨƽ������ һ��һ���ĳ����Լ� ���м��� ��2���Ľ����� ĳ����8�η��������4�η���ƽ��һ�μ���
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
