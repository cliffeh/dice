package net.thingly.dice.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob {

	public static Hashtable<Integer, Double> prob(int n, int d) {
		DiceCartesianProduct rolls = new DiceCartesianProduct(n, d);
		Hashtable<Integer, Integer> results = new Hashtable<Integer, Integer>();
		int total = 0;
		for (List<Integer> roll : rolls) {
			total++;
			int key = 0;
			for (int r : roll) {
				key += r;
			}
			int value = results.getOrDefault(key, 0);
			results.put(key, value + 1);
		}

		Hashtable<Integer, Double> probs = new Hashtable<Integer, Double>();
		for (Integer key : results.keySet()) {
			probs.put(key, ((double) results.get(key)) / ((double) total));
		}

		return probs;
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

		Hashtable<Integer, Double> probs = prob(n, d);
		List<Integer> keys = new ArrayList<Integer>(probs.keySet());
		Collections.sort(keys);
		double totalProb = 0.0;
		for (Integer key : keys) {
			System.out.println(key + ": " + probs.get(key));
			totalProb += probs.get(key);
		}
		System.out.println("total: " + totalProb);
	}
}
