package com.interview.interview.case1;

/**
 * 1-n 中所有数字中 包含1的数目
 * 
 * @author zhoushaojun
 * 
 */
public class Find_count_scope_to_N {

	private int num = 21;

	public int getCount() {
		int factor = 1;
		int curValue = 0;
		int lowVaue = 0;
		int highValue = 0;
		int count = 0;
		while (num / factor != 0) {
			lowVaue = num - (num / factor);
			curValue = num / factor % 10;
			highValue = num / (factor * 10);
			switch (curValue) {
			case 0:
				count += highValue * factor;
				break;
			case 1:
				count += highValue * factor + lowVaue + 1;
				break;

			default:
				count += (highValue + 1) * factor;
				break;
			}
			factor *= 10;
			System.out.println(count);
		}
		return count;
	}

	public static void main(String[] args) {

		Find_count_scope_to_N leng = new Find_count_scope_to_N();
		System.out.println(leng.getCount());
	}
}
