package SwordOffer;

/**
 * 禁止使用 四则运算 进行 加法
 * 抑或 非进位 加法
 * 与 <<1 提取进位
 * @author zhoushaojun
 *
 */
public class AddExpectAddMinusMultiDivide {
	private static int first = 19;
	private static int second = 6;

	public static void handleCore() {
		int result = 0;
		int forward = 0;
		do {
			result = first ^ second;
			forward = (first & second) << 1;

			first = result;
			second = forward;

		} while (forward != 0);
		System.out.println(result);
	}

	public static void main(String[] args) {
		AddExpectAddMinusMultiDivide.handleCore();
	}
}
