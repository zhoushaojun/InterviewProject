package com.interview.swordoffer;

/**
 * ������ӡ������Ŀû���ᵽ��ֵ���Ʊ���n����ʱ����Ҫע��������⡣
 *  Ps��(a+b)/2 Ӧ�û��� a+ (abs(a-b))/2;
 * 
 * ע�⣺   char ֮������ '6'-'0'= 6(int) 
 * 		�����Ҫint ת��Ϊchar , char(int+'0')
 * 
 * @author zhoushaojun
 * 
 */
public class BigNumberPrint {
	private static int size = 6;
	private static char[] data = new char[size];
	static {
		for (int i = 0; i < size; i++) {
			data[i] = '0';
		}
	}

	public static void bigCoreAddOne() throws Exception {
		int length = data.length;
		int sum = 0;
		int takeOver = 0;

		for (int i = length - 1; i >= 0; i--) {
			sum = (data[i] - '0') + takeOver;
			if (i == length - 1) {
				sum++;
			}
			if (sum == 10) {
				if (i == 0) {
					System.out.println("Overflow");
					throw new Exception();
				}
				data[i] = '0';
				takeOver = 1;
				continue;
			} else {
				data[i] = (char) (sum + '0');
				break;
			}
		}
		printf();
	}

	private static void printf() {
		StringBuilder builder = new StringBuilder();
		for (char e : data) {
			// if (e != '0') {
			builder.append(e);
			// }
		}
		System.out.println(builder.toString().trim());
	}

	public static void main(String[] args) {
	/*	try {
			for (int i = 0; i < 100000000; i++) {
				bigCoreAddOne();
			}
		} catch (Exception e) {
			System.out.println("over");
		}
		System.out.println(Integer.MAX_VALUE);
		*/
	 BigNumberCursive.bigCursive(0);
	}
}

/**
 * ͨ�� �ݹ鷽ʽ���� ���д�����ӡ�� ʵ�ʣ�Ϊȫ����ģʽ��
 *  ��1������һ��Ԫ�ؾ������ظ� ȫ���� �ο� AllSortOfArray.java �ļ�
 *		 ͨ����ǰԪ�غ�һ�������ݹ飬��ǰԪ�������ÿ��Ԫ�ؽ��������ڵݹ�󽻻��������ݹ����ǵ�ǰԪ�� index+1
 *  ��2������Ԫ�ؿ����ظ���ͨ��ÿһ��Ԫ��10֮�ڽ���ѭ�����ݹ�����ǵ�ǰindex+1
 * 
 * @author zhoushaojun
 * 
 */
class BigNumberCursive {
	private static int length = 6;
	private static char[] data = new char[6];

	static {
		for (int i = 0; i < length; i++) {
			data[i] = '0';
		}
	}

	public static void bigCursive(int index) {
		if (index == length) {
			printf();
			return;
		}
		for (int i = 0; i < 10; i++) {
			data[index] = (char)(i+'0');
			bigCursive(index+1);
		}

	}
	private static void printf() {
		StringBuilder builder = new StringBuilder();
		for (char e : data) {
			builder.append(e);
		}
		System.out.println(builder.toString().trim());
	}

}
