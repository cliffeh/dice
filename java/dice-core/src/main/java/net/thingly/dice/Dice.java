package net.thingly.dice;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dice {
	private static final Random random = new Random();

	public static int roll() {
		return roll(1, 6)[0];
	}

	public static int[] roll(int n) {
		return roll(n, 6);
	}

	public static int[] roll(int n, int d) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = random.nextInt(d) + 1;
		}
		return result;
	}

	public static void main(String[] args) {
		int n = 1, d = 6;

		if (args.length != 1) {
			System.err.println("usage: dice NdD");
			System.exit(1);
		}

		Pattern p = Pattern.compile("((\\d+)(d(\\d+))?)");
		Matcher m = p.matcher(args[0]);
		if (!m.matches()) {
			System.err.println("usage: dice NdD");
			System.exit(1);
		}

		n = Integer.parseInt(m.group(2));
		d = m.group(4) != null ? Integer.parseInt(m.group(4)) : d;

		System.out.println(Arrays.toString(roll(n, d)));
	}
}
