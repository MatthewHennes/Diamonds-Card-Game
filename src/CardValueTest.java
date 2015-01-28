

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CardValueTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CardValueTest
{
    /**
     * Default constructor for test class CardValueTest
     */
    public CardValueTest()
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

    @Test
    public void testPoints()
    {
        Card card1 = new Card(Suit.diamond, CardValue.two);
        assertEquals(card1.getValue().points(), 1);
    }

    @Test
    public void testCardValue()
    {
        Card card1 = new Card(Suit.heart, CardValue.ace);
        Card card2 = new Card(Suit.heart, CardValue.two);
        Card card3 = new Card(Suit.heart, CardValue.three);
        Card card4 = new Card(Suit.heart, CardValue.four);
        Card card5 = new Card(Suit.heart, CardValue.five);
        Card card6 = new Card(Suit.heart, CardValue.six);
        Card card7 = new Card(Suit.heart, CardValue.seven);
        Card card8 = new Card(Suit.heart, CardValue.eight);
        Card card9 = new Card(Suit.heart, CardValue.nine);
        Card card10 = new Card(Suit.heart, CardValue.jack);
        Card card11 = new Card(Suit.heart, CardValue.ten);
        Card card12 = new Card(Suit.heart, CardValue.queen);
        Card card13 = new Card(Suit.heart, CardValue.king);
    }
}


