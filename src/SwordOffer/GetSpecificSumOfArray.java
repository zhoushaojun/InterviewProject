package SwordOffer;

import java.util.ArrayList;
/**
 * (1)查询 在1-n 中 和为Sum的连续序列
 * @author zhoushaojun
 *
 */
public class GetSpecificSumOfArray {

	private static final int sum = 15;

	/**
	 * 查询 有序数组中 特定值，自己想的方法不好
	 */
	public void findSequenceNum() {
		int end = sum / 2;
		if (sum % 2 != 0) {
			end += 1;
		}

		int head = end - 1;
		int result = 0;
		ArrayList<Integer> data = new ArrayList<Integer>();
		while (end > 1) {
			// System.out.println("end :"+end);
			data.clear();
			result = 0;

			data.add(end);
			result += end;
			head = end - 1;
			while (head >= 1) {

				// System.out.println("head : "+head);
				result += head;
				data.add(head);
				if (result == sum) {
					printf(data);
					// System.out.println(end);
					break;
				} else if (result < sum) {
					head--;
					continue;
				} else if (result > sum) {
					break;
				}

			}
			end--;
		}

	}

	public void printf(ArrayList<Integer> data) {
		System.out.println("---");
		for (Integer integer : data) {
			System.out.println(integer);

		}
		System.out.println("---");
	}

	/**
	 * Attention:
	 * 			(1)Big case 
	 * 				big++;
					result += big;
	 	        (2)Small case
	 	    		result -= small;
					small ++;
	 */	
	public static void findSequenceNum2() {
		int border = sum / 2;
		if(sum % 2 != 0){
			border += 1;
		}
		int small = 1;
		int big = 2;
		int result = small + big;
		while(big <= border && small < big){
			if(result < sum){
				big++;
				result += big;
			}else if(result > sum){
				result -= small;
				small ++;
			}else{
				System.out.println("small: "+small+" big: "+big);
				big++;
				result +=big;
			}
		}
	}

	public static void main(String[] args) {
		GetSpecificSumOfArray ge = new GetSpecificSumOfArray();
		ge.findSequenceNum();
		//GetSpecificSumOfArray.findSequenceNum2();
	}
}
