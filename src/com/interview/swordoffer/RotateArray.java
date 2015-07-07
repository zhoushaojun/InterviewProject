package com.interview.swordoffer;
/**
 * 旋转数组 查找最小数字
 * 使用二分查找的核心代码
 * （1）第一个指针位于第一部分第一个，第二个指针位于第二部分最后一个。
 * 		随着运算进行，分别一定 第一个 第二个 指针
 * （2）当进行到 front end 差1个时候，end为最后的返回结果
 * 注意：front+1 = end 的时候为结束；mid 初始化为front,当数组没有旋转（旋转0个时候）直接返回最小的一个
 * @author zhoushaojun
 *
 */
public class RotateArray {
	private int[] data = { 3, 4, 5, 6, 7, 0, 1, 2 };

	public int rotateCore() {
		int front = 0;
		int end = data.length - 1;
		int mid = front;
		while (data[front] > data[end]) {
			if (end - front == 1) {
				mid = end;
				break;
			}
			mid = front + (end - front) / 2;
			if (data[mid] >= data[front]) {
				front = mid;
			} else if (data[mid] <= data[end]) {
				end = mid;
			}
		}

		return data[mid];
	}

	public static void main(String[] args) {
		RotateArray rotateArray = new RotateArray();
		System.out.println(rotateArray.rotateCore());
	}
}
