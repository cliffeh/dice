package net.thingly.dice;

import java.util.Random;

public class Dice {
	private static final Random random = new Random();

	static int roll() {
		return roll(1, 6)[0];
	}

	static int[] roll(int n) {
		return roll(n, 6);
	}

	static int[] roll(int n, int d) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = random.nextInt() % d + 1;
		}
		return result;
	}

	public static void main(String[] args) {

	}
}
