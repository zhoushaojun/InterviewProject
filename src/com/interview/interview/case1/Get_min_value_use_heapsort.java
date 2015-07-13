package com.interview.interview.case1;

/**
 * 最小K个值，堆排序方法
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import javax.naming.spi.DirStateFactory.Result;

public class Get_min_value_use_heapsort {

	private int[] data = { 6, 1, 8, 2, 3, 9, 10, 12 };

	TreeSet<Integer> result = new TreeSet<Integer>(new Comparator<Integer>() {

		public int compare(Integer o1, Integer o2) {

			if (o1 < o2)
				return -1;
			if (o1 == o2)
				return 0;
			else
				return 1;
		}

	});

	// ////////////////////////////////////////////InterViewExtent///////////////////////////////////////////////////

	public void adjustHeap(int[] data, int index, int lenghth) {
		int tempvalue = 0;
		while (2 * index + 1 < lenghth) {
			int maxIndex = 2 * index + 1;
			if (2 * index + 2 < lenghth) {
				if (data[2 * index + 2] > data[2 * index + 1]) {
					maxIndex = 2 * index + 2;
				} else {
				}
			}
			if (data[index] < data[maxIndex]) {
				tempvalue = data[index];
				data[index] = data[maxIndex];
				data[maxIndex] = tempvalue;
				index = maxIndex;
				// 添加元素(重要的一步，每次发生交换时候将　最少的两个 都加入数组)
				// Index为交换后的　序列号，左子树或者右子树
				this.addValueEnter(index, lenghth, true, data);
				continue;

			} else {
				break;
			}

		}

	}

	public void createHeap() {

		result.add(Integer.MAX_VALUE);
		result.add(Integer.MAX_VALUE - 1);
		result.add(Integer.MAX_VALUE - 2);
		result.add(Integer.MAX_VALUE - 3);
		int size = data.length;
		for (int i = size / 2 - 1; i >= 0; i--) {

			adjustHeap(data, i, size);
		}
		int tempvalue = 0;
		// for(int i =size -1; i >= 0; i--){
		// tempvalue = data[i];
		// data[i] = data[0];
		// data[0] = tempvalue;
		// adjustHeap(data, 0, i);
		//
		// }

	}

	/**
	 * Index 为 交换后的 序列号，左子树 或者 右子树。 目标需要 将左子树 右子树 同时加入到数组中。 将Index/2 再进行
	 * Index*2+1 Index*2+2 放入数组中
	 * 
	 * @param index
	 * @param length
	 * @param change
	 * @param data
	 */
	private void addValueEnter(int index, int length, boolean change, int[] data) {
		if (change) {
			// 交换了数据
			System.out.println("Index " + index);
			index = index / 2;

		}
		if (2 * index + 1 < length) {
			this.addValue(data[2 * index + 1]);
		}
		if (2 * index + 2 < length) {
			this.addValue(data[2 * index + 2]);
		}
	}

	private void addValue(int value) {

		if (result.size() != 0 && value < result.last() && !result.contains(value)) {
			// System.out.println("zhou " + value + " " + result.last());
			Integer ints = result.last();
			result.remove(ints);
			result.add(value);
		}

	}

	// ///////////////////////////////////////////InterviewExtend
	// End///////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////heapSort///////////////////////////////////////////////////////////////////////?/
	public void adjustHeapInner(int[] data, int index, int lenghth) {
		int tempvalue = 0;
		while (2 * index + 1 < lenghth) {
			int maxIndex = 2 * index + 1;
			if (2 * index + 2 < lenghth) {
				if (data[2 * index + 2] > data[2 * index + 1])
					maxIndex = 2 * index + 2;
			}
			if (data[index] < data[maxIndex]) {
				tempvalue = data[index];
				data[index] = data[maxIndex];
				data[maxIndex] = tempvalue;
				index = maxIndex;
				continue;

			} else {
				break;
			}
		}
	}

	public void createHeapInner() {
		int size = data.length;
		for (int i = size / 2 - 1; i >= 0; i--) {

			adjustHeap(data, i, size);
		}
		int tempvalue = 0;
		for (int i = size - 1; i >= 0; i--) {
			tempvalue = data[i];
			data[i] = data[0];
			data[0] = tempvalue;
			adjustHeap(data, 0, i);
		}
	}

	// ////////////////////////////////////////////heapSortEnd/////////////////////////////////////
	public static void main(String[] args) {

		Get_min_value_use_heapsort min = new Get_min_value_use_heapsort();
		min.createHeap();

		Iterator<Integer> iterator = min.result.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		// min.createHeap();
		//
		// for(int v : min.data){
		//
		// System.out.println(v);
		// }

	}
}
