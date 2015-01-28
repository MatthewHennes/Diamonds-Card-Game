

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CardTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CardTest
{
    /**
     * Default constructor for test class CardTest
     */
    public CardTest()
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
     * Tests the getSuit() method.
     */
    @Test
    public void testGetSuit()
    {
        Card card1 = new Card(Suit.heart, CardValue.two);
        assertEquals(Suit.heart, card1.getSuit());
    }

    /**
     * Tests the getValue() method.
     */
    @Test
    public void testGetValue()
    {
        Card card1 = new Card(Suit.heart, CardValue.two);
        assertEquals(CardValue.two, card1.getValue());
    }

    /**
     * Tests the compareTo() method.
     */
    @Test
    public void testCompareTo()
    {
        Card card1 = new Card(Suit.heart, CardValue.two);
        Card card2 = new Card(Suit.club, CardValue.two);
        assertEquals(-2, card1.compareTo(card2));
    }

    /**
     * Tests the toString() method.
     */
    @Test
    public void testToString()
    {
        Card card1 = new Card(Suit.heart, CardValue.two);
        assertEquals("the two of hearts", card1.toString());
    }

    @Test
    public void testCompareTo2()
    {
        Card card1 = new Card(Suit.heart, CardValue.two);
        Deck deck1 = new Deck();
        assertEquals(-1, card1.compareTo(deck1));
    }

    @Test
    public void testCompareTo3()
    {
        Card card1 = new Card(Suit.heart, CardValue.two);
        Card card2 = new Card(Suit.heart, CardValue.three);
        assertEquals(-1, card1.compareTo(card2));
    }
}






