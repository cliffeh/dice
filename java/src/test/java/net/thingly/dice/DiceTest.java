package net.thingly.dice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Dice.
 */
public class DiceTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DiceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DiceTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testRoll()
    {
        assertTrue( true );
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testRollN()
    {
        assertTrue( true );
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testRollND()
    {
        assertTrue( true );
    }
}
