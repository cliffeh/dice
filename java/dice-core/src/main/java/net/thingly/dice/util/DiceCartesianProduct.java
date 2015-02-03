package net.thingly.dice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.thingly.util.CartesianProduct;

public class DiceCartesianProduct extends CartesianProduct<Integer> {

	public DiceCartesianProduct(int n, int d) {
		List<List<Integer>> dice = new ArrayList<List<Integer>>(n);
		for (int i = 0; i < n; i++) {
			List<Integer> die = new ArrayList<Integer>();
			for (int j = 1; j <= d; j++) {
				die.add(j);
			}
			dice.add(die);
		}
		setObjects(dice);
	}

	public DiceCartesianProduct(List<List<Integer>> objects) {
		super(objects);
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

		DiceCartesianProduct rolls = new DiceCartesianProduct(n, d);
		for (List<Integer> roll : rolls) {
			System.out.println(roll);
		}
	}
}
