

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DeckTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DeckTest
{
    /**
     * Default constructor for test class DeckTest
     */
    public DeckTest()
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
     * Tests the giveCard() method.
     */
    public void testGiveCard()
    {
        Deck deck1 = new Deck();
        assertNotNull(deck1.giveCard());
        Card card1 = deck1.giveCard();
        assertNotNull(card1);
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
     * Tests the getCard() method.
     */
    @Test
    public void testGetCard()
    {
        Deck deck1 = new Deck();
        Card card1 = deck1.giveCard();
        assertNotNull(deck1.giveCard());
    }

    /**
     * Tests the empty() method.
     */
    @Test
    public void testEmpty()
    {
        Deck deck1 = new Deck();
        assertEquals(false, deck1.empty());
    }
}


