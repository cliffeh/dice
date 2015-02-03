package net.thingly.dice;

import java.util.Hashtable;

import net.thingly.dice.util.Prob;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Dice.
 */
public class DiceTest extends TestCase {

	private int iter = 100000;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public DiceTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(DiceTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testRoll() {
		// Hashtable<Integer, Double> probs = Prob.prob(1, 6);
		int[] results = new int[6];
		for (int i = 0; i < iter; i++) {
			int r = Dice.roll();
			assertTrue(r >= 1 && r <= 6);
			results[r - 1]++;
		}

		double expected = ((double) iter) / 6.0;
		for (int i = 0; i < results.length; i++) {
			double observed = ((double) results[i]) / iter;
			// not super-scientific, but i'm satisfied if we're within a half a
			// percent for each possible outcome
			assertTrue(Math.abs(observed - expected) / expected <= .005);
		}
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testRollN() {
		int[] results = new int[6];
		int[] rolls = Dice.roll(iter);
		for (int i = 0; i < iter; i++) {
			results[rolls[i] - 1]++;
		}

		double expected = ((double) iter) / 6.0;
		for (int i = 0; i < results.length; i++) {
			double observed = ((double) results[i]) / iter;
			// not super-scientific, but i'm satisfied if we're within a half a
			// percent for each possible outcome
			assertTrue(Math.abs(observed - expected) / expected <= .005);
		}
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testRollND() {
		Hashtable<Integer, Integer> results = new Hashtable<Integer, Integer>();
		for (int i = 0; i < iter; i++) {
			int[] r = Dice.roll(4, 12);
			assertTrue(r.length == 4);
			int key = 0;
			for (int j = 0; j < r.length; i++) {
				assertTrue(r[j] >= 1 && r[j] <= 12);
				key += r[j];
			}
			int value = results.getOrDefault(key, 0);
			results.put(key, value + 1);
		}

		Hashtable<Integer, Double> probs = Prob.prob(4, 12);
		for (int key : probs.keySet()) {
			double observed = ((double) results.getOrDefault(key, 0))
					/ ((double) iter);
			double expected = probs.get(key);
			assertTrue((Math.abs(observed - expected) / expected) <= .005);
		}
	}
}
