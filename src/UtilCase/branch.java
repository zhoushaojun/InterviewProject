package UtilCase;

public class branch {
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
				continue;

			} else {
				break;
			}

		}

	}
	
	public static void main(String[] args) {
		
	}
}
