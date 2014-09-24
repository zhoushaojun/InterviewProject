package SwordOffer;

/**
 * 查找连续子数组最大和
 * 
 * @author zhoushaojun
 * 
 */
public class FindSequenceArrayMaxSum {

	private static int[] data = { 1, -2, 3, 10, -4, 7, 2, -5 };

	public static int findCore() {
		int maxStart = 0, maxEnd = 0;
		int max = 0;
		int sum = 0;
		int size = data.length;

		for (int i = 0; i < size; i++) {

			sum += data[i];
			if (sum <= 0 && i != size - 1) {
				sum = 0;
				maxStart = i + 1;
				maxEnd = i + 1;
			} else if (sum > max) {
				max = sum;
				maxEnd = i;
				System.out.println(maxStart + " " + maxEnd + " " + max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(findCore());
	}
}
