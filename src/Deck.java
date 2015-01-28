import java.util.Stack;
import java.util.Collections;

/**
 * The deck class holds the deck of Cards. It can be used to deal/draw cards.
 * 
 * @author Matt Hennes 
 * @version 10/11/13
 */
public class Deck
{
    /** Holds the deck of playing cards that will be used
     * to play the game in the form of a stack. */
    private Stack<Card> deck;
    
    /**
     * Constructs a new Deck, adds all the cards to it, and shuffles it.
     */
    public Deck()
    {
        deck = new Stack<Card>();
        /* Increments through each suit, and then for each suit through each rank,
         * and pushes a
         * new card with the corresponding information onto the deck.
         */
        /* The above comment did not show up in the checkstyle. */
        for (Suit suit : Suit.values())
        {
            /* Increments through each card value. */
            for (CardValue value : CardValue.values())
            {
                deck.push(new Card(suit, value));
            }
        }
        Collections.shuffle(deck);
    }
    
    /**
     * Gives the top card from the deck.
     * 
     * @return Pops and returns the card from the top of the stack.
     */
    public Card giveCard()
    {
        return deck.pop();
    }
    
    /**
     * Tells whether or not the deck is empty.
     * 
     * @return Returns true if the deck is empty and false
     * if the deck has more cards remaining.
     */
    public boolean empty()
    {
        return deck.empty();
    }
}
