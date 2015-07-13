package com.interview.sword.offer;
/**
 * ��ת���� ������С����
 * ʹ�ö��ֲ��ҵĺ��Ĵ���
 * ��1����һ��ָ��λ�ڵ�һ���ֵ�һ�����ڶ���ָ��λ�ڵڶ��������һ����
 * 		����������У��ֱ�һ�� ��һ�� �ڶ��� ָ��
 * ��2�������е� front end ��1��ʱ��endΪ���ķ��ؽ��
 * ע�⣺front+1 = end ��ʱ��Ϊ������mid ��ʼ��Ϊfront,������û����ת����ת0��ʱ��ֱ�ӷ�����С��һ��
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
