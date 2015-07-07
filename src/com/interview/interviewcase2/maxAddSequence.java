package com.interview.interviewcase2;

import java.util.TreeSet;

/**
 * 数组中最长 递增子序列
 * 
 * @author zhoushaojun
 * 
 */
public class maxAddSequence {

	private int[] data = { 41, 1, 2, 42, 3, -7, -4, -8, 6, -4, 8 };

	public void getData() {

		int size = data.length;
		pathnode[] path = new pathnode[size];
		for (int i = 0; i < size; i++)
			path[i] = new pathnode();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (data[j] < data[i]) {
					if (path[j].value + 1 > path[i].value) {
						path[i].value = path[j].value + 1;
						path[i].prenode = j;
					}

				}
			}// for end
		}// for end

		int maxIndex = 0;
		int max = 0;
		for (int i = 0; i < size; i++) {
			if (path[i].value > max) {
				max = path[i].value;
				maxIndex = i;
			}
		}
		while (maxIndex != -1) {
			System.out.println(data[maxIndex]);
			maxIndex = path[maxIndex].prenode;
		}

	}

	public static void main(String[] args) {
		maxAddSequence addSequence = new maxAddSequence();
		addSequence.getData();
	}
}

class pathnode implements Comparable<pathnode> {

	public int value = 1;
	public int prenode = -1;

	public int compareTo(pathnode o) {
		if (this.value < o.value)
			return 1;
		else
			return -1;
	}

}
