package com.interview.sword.offer;

import java.util.ArrayList;

import org.w3c.dom.NodeList;
/**
 * 计算筛子 n个筛子 的 数值和
 * @author zhoushaojun
 *
 */

public class CalculateDice {

	private final static int diceNum = 10;
	private final static int diceSum = 50;
	private static int sum = 0;
	private static int totalSum = 0;

	public static void coreLogic() {
		ArrayList<Node> nodeList = new ArrayList<Node>(diceNum);
		// Initial each node Y : 5
		for (int i = 1; i <= diceNum; i++) {
			Node node = new Node(i, 5);
			nodeList.add(node);
		}
		if (checkSum(nodeList)) {
			CalculateDice.sum++;
		}

		for (int i = 1; i < diceNum; i++) {
			clearFlag(nodeList);
			CalculateDice.sum = 0;

			for (Node node : nodeList) {
				if (node.getPosition().getX() <= i) {
					node.getPosition().right(1);
				}
			}

			calculateCore(nodeList, i + 1, i);
			totalSum += c(diceNum, i) * sum;
			System.out.println(totalSum);
		}
		double result = (totalSum + 1) / Math.pow(6, diceNum);
		System.out.println(result);
	}

	public static int c(int n, int m) {
		if (n < m)
			return 0;
		int temp = n - m;
		int firstn = 1;
		int secondm = 1;
		int thirdnm = 1;
		for (int i = 1; i <= n; i++) {
			firstn *= i;
			if (i <= m)
				secondm *= i;
			if (i <= temp)
				thirdnm *= i;
		}
		return firstn / (secondm * thirdnm);
	}

	/**
	 * Bug1 : node.getPosition().getX() + 1
	 * 
	 * find next target, if use indexStart for example (6 6) 5 5, the first node
	 * move right. when the last 5 start work, it will find next target will be
	 * indexstart + 1 = 3+1 =4 node.getPositon().getX()+1 = 4+1 =5
	 * 
	 * @param nodeList
	 * @param indexStart
	 * @param steps
	 */
	public static void calculateCore(ArrayList<Node> nodeList, int indexStart, int steps) {

		for (Node node : nodeList) {
			if (node.getPosition().getX() >= indexStart) {
				for (int i = 1; i <= steps; i++) {
					node.getPosition().left(1);
					if (checkSum(nodeList)) {
						CalculateDice.sum++;
						node.getPosition().setY(5);
						break;
					}

					calculateCore(nodeList, node.getPosition().getX() + 1, steps - 1);
				}
			}
		}

	}

	public static boolean checkSum(ArrayList<Node> nodeList) {

		int sum = 0;
		StringBuilder builder = new StringBuilder();
		for (Node node : nodeList) {
			sum += node.getPosition().getY();
			builder.append(String.valueOf(node.getPosition().getY() + " -> "));
		}
		if (sum == diceSum) {
			// System.out.println(builder.toString());
			return true;
		}
		return false;
	}

	public static void clearFlag(ArrayList<Node> nodeList) {
		for (Node node : nodeList) {
			node.getPosition().setY(5);
		}
	}

	// ////////////////////////////////Another Method////////////////////////////////////////////////

	private static final int maxNum = 6;
	private static final int totalNum = 10;

	private static int[] firstArray = new int[maxNum * totalNum + 1];
	private static int[] secondArray = new int[maxNum * totalNum + 1];

	public static void calculateCore() {
		// init the first 1-6 1,1,1,1,1,1
		for (int i = 1; i <= maxNum; i++) {
			firstArray[i] = 1;
		}
		ArrayList<int[]> dataList = new ArrayList<int[]>(2);
		dataList.add(0, firstArray);
		dataList.add(1, secondArray);
		int flag = 1;
		for (int j = 2; j <= totalNum; j++) {
			// if less than j, then array value will be 0.
			// for example 2 dice totalnum must be more than 2

			for (int k = 1; k < j; k++) {
				dataList.get(flag)[k] = 0;
			}
			for (int k = j; k <= totalNum * maxNum; k++) {
				dataList.get(flag)[k] = 0;
				for (int s = k - 1, freq = 1; freq <= 6 && s >= 1; freq++, s--) {
					dataList.get(flag)[k] += dataList.get(1 - flag)[s];
				}
			}
			flag = 1 - flag;
		}

		System.out.println(dataList.get(1 - flag)[50]);
	}

	public static void printfResult() {
		StringBuilder builder = new StringBuilder();
		for (int element : firstArray) {
			builder.append(element + " ");
		}
		System.out.println("first  : " + builder.substring(1, builder.length()).toString());

		StringBuilder builderT = new StringBuilder();
		for (int element : secondArray) {
			builderT.append(element + " ");
		}
		System.out.println("second : " + builderT.substring(1, builderT.length()).toString());
	}

	public static void main(String[] args) {
		CalculateDice.calculateCore();
		CalculateDice.printfResult();
		coreLogic();
	}
}

/**
 * Position
 */
class Position {

	private int x;
	private int y;
	public static int maxY = 6;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void left(int step) {
		if (this.getY() - step >= 0) {
			this.setY(this.getY() - step);
		}
	}

	public void right(int step) {
		if (this.getY() + step <= maxY) {
			this.setY(this.getY() + step);
		}
	}
}

/**
 * Node
 */
class Node {

	private String name;
	private Position position = new Position();

	public Node(int x, int y) {
		this.position.setX(x);
		this.position.setY(y);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String toString() {
		return " x: " + this.position.getX() + " y: " + this.position.getY();

	}
}
