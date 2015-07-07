package com.interview.swordoffer;

/**
 * ������ 2,3,5 Ϊ���ӵ����� Ϊ����. 
 * ����һ�����飬������ʼֵΪ1���������־�Ϊ 2,3,5�˳����ģ�������־�Ϊ������ 
 * ���� ������ ���� twoIndex threeIndex fiveIndex. 
 * ��ÿ�μ����һ����Сֵ����ֱ����2,3,5������ <=min �� �������Χ��
 * ÿ�μ�������㿪ʼ����� twoIndex threeIndex fiveIndex ��ʼ���㡣
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
