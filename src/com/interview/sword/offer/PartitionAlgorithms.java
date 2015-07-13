package com.interview.sword.offer;
/**
 * 二分查找法，在有序数组中进行查找
 * @author zhoushaojun
 *
 */
public class PartitionAlgorithms {
	private static int[] data = { 1, 3, 4, 5, 6, 7, 8, 9, 10 };
	public static String string;
	public static int zhou;
	public static float e;

	public static int partitionCore(int start, int end, int goal) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (data[mid] == goal)
			return mid;
		else if (data[mid] > goal)
			return partitionCore(start, mid - 1, goal);
		else {
			return partitionCore(mid + 1, end, goal);
		}
	}

	public static int partitionCore(int goal){
		int start = 0;
		int end = data.length -1;
		int mid = 0;
		while(start <= end){
			mid = (start + end)/2;
			if(data[mid] == goal) return mid;
			else if(data[mid] > goal) end = mid -1;
			else start = mid+ 1;
		}
		return -1;
	} 
	public static void main(String[] args) {
		System.out.println(partitionCore(0, data.length-1, 8));
		System.out.println(partitionCore(8));
	}
}
