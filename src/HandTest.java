

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HandTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HandTest
{
    /**
     * Default constructor for test class HandTest
     */
    public HandTest()
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
     * Tests the draw() method.
     */
    @Test
    public void testDraw()
    {
        Deck deck1 = new Deck();
        Hand hand1 = new Hand();
        assertNotNull(hand1.draw(deck1));
    }

    /**
     * Tests the playCard() method.
     */
    @Test
    public void testPlayCard()
    {
        Hand hand1 = new Hand();
        Card card1 = new Card(Suit.heart, CardValue.two);
        hand1.add(card1);
        assertEquals(card1, hand1.playCard(0));
    }

    /**
     * Tests the empty() method.
     */
    @Test
    public void testEmpty()
    {
        Hand hand1 = new Hand();
        assertEquals(true, hand1.empty());
    }

    /**
     * Tests the giveBestDiamond() method.
     */
    @Test
    public void testGiveBestDiamond()
    {
        Hand hand1 = new Hand();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        hand1.add(card1);
        Hand hand2 = new Hand();
        assertEquals(card1, hand1.giveBestDiamond(hand2));
    }

    /**
     * Tests the giveWorstDiamond() method.
     */
    @Test
    public void testGiveWorstDiamond()
    {
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        hand1.add(card1);
        assertEquals(card1, hand1.giveWorstDiamond(hand2));
    }

    /**
     * Tests the addDiamond() method.
     */
    @Test
    public void testAddDiamond()
    {
        Hand hand1 = new Hand();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        hand1.addDiamond(card1);
        assertEquals(1, hand1.score());
    }

    /**
     * Tests the add() method.
     */
    @Test
    public void testAdd()
    {
        Hand hand1 = new Hand();
        Card card1 = new Card(Suit.heart, CardValue.two);
        hand1.add(card1);
        assertEquals(card1, hand1.playCard(0));
    }

    /**
     * Tests the toStringAll() method.
     */
    @Test
    public void testToStringAll()
    {
        Hand hand1 = new Hand();
        Card card1 = new Card(Suit.heart, CardValue.two);
        hand1.add(card1);
        assertEquals("the two of hearts", hand1.toStringAll());
    }

    /**
     * Tests the score() method.
     */
    @Test
    public void testScore()
    {
        Hand hand1 = new Hand();
        Card card1 = new Card(Suit.diamond, CardValue.two);
        hand1.add(card1);
        assertEquals(1, hand1.score());
    }

    @Test
    public void testPrint()
    {
        Hand hand1 = new Hand();
        Card card1 = new Card(Suit.heart, CardValue.two);
        hand1.add(card1);
        hand1.print();
    }

    @Test
    public void testGiveBestDiamond2()
    {
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        assertEquals(null, hand1.giveBestDiamond(hand2));
    }

    @Test
    public void testGiveWorstDiamond2()
    {
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        assertEquals(null, hand1.giveWorstDiamond(hand2));
    }

    @Test
    public void testPrintDiamonds()
    {
        Hand hand1 = new Hand();
        hand1.printDiamonds();
    }

    @Test
    public void testToStringAll2()
    {
        Hand hand2 = new Hand();
        Card card1 = new Card(Suit.heart, CardValue.two);
        Card card2 = new Card(Suit.heart, CardValue.three);
        hand2.add(card1);
        hand2.add(card2);
        assertEquals("the two of hearts, the three of hearts", hand2.toStringAll());
    }

    @Test
    public void testToStringAll3()
    {
        Hand hand2 = new Hand();
        Card card2 = new Card(Suit.diamond, CardValue.two);
        hand2.add(card2);
        assertEquals("the two of diamonds", hand2.toStringAll());
    }

    @Test
    public void testToStringAll4()
    {
        Hand hand1 = new Hand();
        Card card1 = new Card(Suit.heart, CardValue.two);
        Card card2 = new Card(Suit.diamond, CardValue.two);
        hand1.add(card1);
        hand1.add(card2);
        assertEquals("the two of hearts, the two of diamonds", hand1.toStringAll());
    }
}
















