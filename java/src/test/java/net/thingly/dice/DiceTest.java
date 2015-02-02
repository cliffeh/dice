package net.thingly.dice;

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
			double pct = ((double) results[i]) / iter;
			// not super-scientific, but i'm satisfied if we're within a half a
			// percent for each possible outcome
			assertTrue(Math.abs(pct - (expected / ((double) iter))) <= .005);
		}
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testRollN() {
		assertTrue(true);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testRollND() {
		assertTrue(true);
	}
}
