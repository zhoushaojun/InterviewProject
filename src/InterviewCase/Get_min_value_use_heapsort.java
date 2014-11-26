package InterviewCase;

/**
 * ��СK��ֵ�������򷽷�
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
				// ���Ԫ��(��Ҫ��һ����ÿ�η�������ʱ�򽫡����ٵ����� ����������)
				// IndexΪ������ġ����кţ�����������������
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
	 * Index Ϊ ������� ���кţ������� ���� ��������
	 * Ŀ����Ҫ �������� ������ ͬʱ���뵽�����С� 
	 * ��Index/2 �ٽ��� Index*2+1 Index*2+2 ����������
	 * @param index
	 * @param length
	 * @param change
	 * @param data
	 */
	private void addValueEnter(int index, int length, boolean change, int[] data) {
		if (change) {
			// ����������
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
