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
					System.err.println("is560");
				}
			}
			if (data[index] < data[maxIndex]) {
				tempvalue = data[index];
				data[index] = data[maxIndex];
				data[maxIndex] = tempvalue;
				index = maxIndex;
				// ����Ԫ��(��Ҫ��һ����ÿ�η�������ʱ�򽫡����ٵ����� ����������)
				// IndexΪ������ġ����кţ�����������������
				System.err.println("bug111_is550");
				System.out.println("bug222_is550");
				System.out.println("si505780push_is550");
				continue;

			} else {
				System.out.println("zhoushaojun_zsj");
				System.out.println("develpe_zsj");
				System.out.println("zhoushaojun_wh11");
				System.out.println("develpe_wh11");
				System.out.println("is550");
				break;
			}
			
		}
				
	}
	
	public static void main(String[] args) {
		System.out.println("branch firstsf");
	}
}