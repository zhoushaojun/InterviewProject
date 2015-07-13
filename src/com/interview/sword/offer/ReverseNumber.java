package com.interview.sword.offer;

/**
 * 利用二元归并 排序方法，从小到大排序。 在生成的两部分进行比较：前半部分 大于 后半部分 某个值，那么 从后部分这个值开始到 后部分起点。均可构成逆序数
 * 后半部分 大于 前半部分 某个值， 那么这个值 直接入库。无法构成逆序数。
 * 
 * @author zhoushaojun
 * 
 */
public class ReverseNumber {
	private static int[] data = { 7, 5, 6, 4 };

	public static void reverseEntry(int start, int end) {
		if (start >= end)
			return;
		int mid = (end - start) / 2 + start;
		reverseEntry(start, mid);
		reverseEntry(mid + 1, end);
		reverseCore(start, mid, end);
	}

	private static void reverseCore(int start, int mid, int end) {
		int length = end - start + 1;
		int[] temp = new int[length];
		length--;
		int firstStart = start;
		int firstEnd = mid;
		int secondStart = mid + 1;
		int secondEnd = end;
		int tempEnd = 0;
		/**
		 * logic: 前半部分 大于 后半部分 某个值，那么 从这个值开始到 起点。均可构成逆序数 后半部分 大于 前半部分 某个值， 那么这个值
		 * 直接入库。无法构成逆序数。
		 */
		while (firstEnd >= firstStart && secondEnd >= secondStart) {
			if (data[firstEnd] > data[secondEnd]) {
				tempEnd = secondEnd;
				for (int i = tempEnd; i >= secondStart; i--) {
					printf(data[firstEnd], data[i]);
				}
				temp[length--] = data[firstEnd];
				firstEnd--;
			} else {
				temp[length--] = data[secondEnd];
				secondEnd--;
			}
		}
		while (firstEnd >= firstStart) {
			temp[length--] = data[firstEnd--];
		}
		while (secondEnd >= secondStart) {
			temp[length--] = data[secondEnd--];
		}
		System.arraycopy(temp, 0, data, start, temp.length);

	}

	private static void printf(int a, int b) {
		System.out.println("reverse number : " + a + " " + b);
	}

	public static void main(String[] args) {
		//reverseEntry(0, 3);
		int a= Integer.MAX_VALUE/2;
		int b = Integer.MAX_VALUE/2+3;
		int c= a+b;
		System.out.println(c);
		System.err.println(Integer.MAX_VALUE);
	}
}
