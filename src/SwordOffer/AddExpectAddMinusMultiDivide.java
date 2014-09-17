package SwordOffer;

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
