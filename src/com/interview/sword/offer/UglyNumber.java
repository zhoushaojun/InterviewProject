package com.interview.sword.offer;

/**
 * 丑数： 2,3,5 为因子的数字 为丑数. 
 * 定义一个数组，数组起始值为1。所有数字均为 2,3,5乘出来的，因此数字均为丑数。 
 * 这里 有三个 索引 twoIndex threeIndex fiveIndex. 
 * 当每次计算出一个最小值，则分别计算2,3,5索引在 <=min 的 索引最大范围。
 * 每次计算从最大点开始计算从 twoIndex threeIndex fiveIndex 开始计算。
 * 
 * @author zhoushaojun
 * 
 */
public class UglyNumber {

	private final int lastIndex = 15;
	private int[] data = new int[lastIndex];

	private int twoIndex = 0;
	private int threeIndex = 0;
	private int fiveIndex = 0;
	private int number = 1;

	public void uglyNumberCore() {
		data[0] = 1;
		int min;
		while (number < lastIndex) {
			min = getMinValue(data[twoIndex] * 2, data[threeIndex] * 3, data[fiveIndex] * 5);
			
			data[number++] = min;

			while (data[twoIndex] * 2 <= min)
				twoIndex++;
			while (data[threeIndex] * 3 <= min)
				threeIndex++;
			while (data[fiveIndex] * 5 <= min)
				fiveIndex++;
			System.out.println(min +" two : "+twoIndex +" three "+threeIndex + " five "+fiveIndex);
		}
		printf();

	}

	private void printf() {
		StringBuilder builder = new StringBuilder();
		for (int t : data) {
			builder.append(t + " ");
		}
		System.out.println(builder.toString());

	}

	private int getMinValue(int num1, int num2, int num3) {
		int min = num1 < num2 ? num1 : num2;
		return min < num3 ? min : num3;
	}

	public static void main(String[] args) {
		UglyNumber uglyNumber = new UglyNumber();
		uglyNumber.uglyNumberCore();
	}
}
