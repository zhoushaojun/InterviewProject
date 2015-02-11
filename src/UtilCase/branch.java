package UtilCase;

public class branch {
	public void adjustHeap(int[] data, int index, int lenghth) {
		int tempvalue = 0;
		System.err.println("asadfghjkl");
		while (2 * index + 1 < lenghth) {
			int maxIndex = 2 * index + 1;
			if (2 * index + 2 < lenghth) {
				if (data[2 * index + 2] > data[2 * index + 1]) {
					maxIndex = 2 * index + 2;
				} else {
					System.err.println("is560..666");
					System.err.println("bug555");
				}
			}
			if (data[index] < data[maxIndex]) {
				tempvalue = data[index];
				data[index] = data[maxIndex];
				data[maxIndex] = tempvalue;
				index = maxIndex;
				// 添加元素(重要的一步，每次发生交换时候将　最少的两个 都加入数组)
				// Index为交换后的　序列号，左子树或者右子树
				System.err.println("bug111_is550");
				System.out.println("bug222_is550");
				System.out.println("si505780push_is550");

				System.err.println("bug111");
				System.out.println("bug222");
				System.out.println("si505780push");
				System.err.println("bug555_is550");
				continue;

			} else {
				System.out.println("zhoushaojun_zsj");
				System.out.println("develpe_zsj");
				System.out.println("zhoushaojun_wh11");
				System.out.println("develpe_wh11");
				System.out.println("is550_is550is550");
				System.out.println("13:08");
				System.out.println("13:09");
				break;
			}
			
		}
				
	}
	
	public static void main(String[] args) {
		System.out.println("branch firstsf");
	}
}
