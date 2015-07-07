package com.interview.swordoffer;

/**
 * 查找 1-N 数字中包含1的数目 12223 当前数字 122 2 3 （2） 受到高 低影响 
 * (1)cur =0 high * factor
 * (2)cur =1 high * factor + low +1 
 * (3)cur >1 (high+1)*factor
 * 
 * @author zhoushaojun
 * 
 */
public class CalculateNumsOf1 {
	private static int data = 12223;

	public static int calculateCore() {
		int highNum = 0;
		int curNum = 0;
		int lowNUm = 0;
		int factor = 1;
		int sum = 0;
		while (data / factor != 0) {

			highNum = (data / factor) / 10;
			curNum = (data / factor) % 10;
			lowNUm = data - (data / factor) * factor;
			System.out.println("curNum : " + curNum);
			switch (curNum) {
			case 0:
				sum += highNum * factor;
				System.out.println("0 : " + highNum + " " + factor + " " + sum);
				break;

			case 1:
				sum += highNum * factor + lowNUm + 1;
				System.out.println("1 : " + highNum + " " + factor + " " + lowNUm + " " + sum);
				break;

			default:
				sum += (highNum + 1) * factor;
				System.out.println("2 : " + highNum + " " + factor + " " + sum);
				break;
			}
			factor *= 10;
		}
		System.out.println(sum);
		return sum;
	}

	public static void main(String[] args) {
		calculateCore();
	}
}
