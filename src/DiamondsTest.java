

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DiamondsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DiamondsTest
{
    /**
     * Default constructor for test class DiamondsTest
     */
    public DiamondsTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Tests the add() method.
     */
    @Test
    public void testAdd()
    {
        Diamonds diamonds1 = new Diamonds();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        assertEquals(true, diamonds1.add(card1));
    }

    /**
     * Tests the get() method.
     */
    @Test
    public void testGet()
    {
        Diamonds diamonds1 = new Diamonds();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        diamonds1.add(card1);
        assertEquals(card1, diamonds1.get(0));
    }

    /**
     * Tests the empty() method.
     */
    @Test
    public void testEmpty()
    {
        Diamonds diamonds1 = new Diamonds();
        assertEquals(true, diamonds1.empty());
    }

    /**
     * Tests the getBest() method.
     */
    @Test
    public void testGetBest()
    {
        Diamonds diamonds1 = new Diamonds();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        diamonds1.add(card1);
        assertEquals(card1, diamonds1.getBest());
    }

    /**
     * Tests the getWorst() method.
     */
    @Test
    public void testGetWorst()
    {
        Diamonds diamonds1 = new Diamonds();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        diamonds1.add(card1);
        assertEquals(card1, diamonds1.getWorst());
    }

    /**
     * Tests the toString() method.
     */
    @Test
    public void testToString()
    {
        Diamonds diamonds1 = new Diamonds();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        diamonds1.add(card1);
        assertEquals("the two of diamonds", diamonds1.toString());
    }

    /**
     * Tests the score() method.
     */
    @Test
    public void testScore()
    {
        Diamonds diamonds1 = new Diamonds();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        diamonds1.add(card1);
        assertEquals(1, diamonds1.score());
    }

    @Test
    public void testAdd2()
    {
        Diamonds diamonds1 = new Diamonds();
        assertEquals(false, diamonds1.add(null));
    }

    @Test
    public void testPrint()
    {
        Diamonds diamonds1 = new Diamonds();
        diamonds1.print();
    }

    @Test
    public void testToString2()
    {
        Diamonds diamonds2 = new Diamonds();
        Card card3 = new Card(Suit.diamond, CardValue.two);
        Card card4 = new Card(Suit.diamond, CardValue.three);
        diamonds2.add(card3);
        diamonds2.add(card4);
        assertEquals("the two of diamonds, the three of diamonds", diamonds2.toString());
    }

    @Test
    public void testPrint2()
    {
        Diamonds diamonds1 = new Diamonds();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        diamonds1.add(card1);
        diamonds1.print();
    }
}











