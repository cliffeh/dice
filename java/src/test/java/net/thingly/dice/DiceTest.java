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
			results[r-1]++;
		}
		double chisq = 0;
		double expected = ((double)iter)/6.0; 
		for(int i = 0; i < results.length; i++) {
			System.out.println(i+1 + ": " + results[i]);
			chisq += Math.pow(((double)results[i])-expected, 2)/expected;
		}
		System.out.println("chi squared: " + chisq);
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
