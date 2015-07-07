package com.interview.swordoffer;
/**
 * �ж�����������ĺ���������� �Ƿ����ĳ���������
 * ͨ�� ����if �����ж� ���еݹ�ѭ��
 * @author zhoushaojun
 *
 */
public class LastReadOfSortTree {
	private static int[] data = { 5, 7, 6, 9, 10, 3, 8 };

	public static boolean checkLastReadSortTree(int[] data, int start, int end) {

		if (null == data || data.length == 0) {
			return false;
		}
		System.out.println(start + " " + (end));
//	�����ж�start==end ��1��һ��;�������ݹ��ж�
//		if (start == end) {
//			return true;
//		}
		int pivot = data[end];
		int front = start;

		for (; front < end; front++) {
			if (data[front] > pivot)
				break;
		}
		int back = front;
		for (; back < end; back++) {
			if (data[back] < pivot)
				return false;
		}

		boolean left = true;
		if (front - 1 > 0 && front -1 > start) {
			left = checkLastReadSortTree(data, start, front - 1);
		}

		boolean right = true;
		if (end-1 >0 && end - 1 > front) {
			right = checkLastReadSortTree(data, front, end - 1);
		}

		return left && right;
	}

	public static void main(String[] args) {
		boolean result = checkLastReadSortTree(data, 0, data.length - 1);
		System.out.println(result);
	}
}
