import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents the hand that a player holds.
 * The hand can draw a card and play a card.
 * 
 * @author Matt Hennes 
 * @version 10/11/13
 */
public class Hand
{
    /** Represents the cards in the hand. */
    private ArrayList<Card> hand;
    /** Represents the diamonds that the owner of this hand holds. */
    private Diamonds diamonds;
    
    /**
     * Constructs a new empty Hand.
     */
    public Hand()
    {
        hand = new ArrayList<Card>();
        diamonds = new Diamonds();
    }
    
    /**
     * Draws a card from the deck and adds it to the hand.
     * 
     * @param deck The deck to be drawn from.
     * @return Returns the card that was drawn.
     */
    public Card draw(Deck deck)
    {
        Card card = deck.giveCard();
        add(card);
        return card;
    }
    
    /**
     * Removes the specified card from the hand 
     * and returns it in order for it to be played.
     * 
     * @param index Represents the index of the card to be played
     * (must be a card that exists in the hand)
     * @return Returns the card that was removed to be played.
     */
    public Card playCard(int index)
    {
        return hand.remove(index);
    }
    
    /**
     * Tells whether or not the hand is empty.
     * 
     * @return Returns true if the hand is empty and false if the hand has more cards.
     */
    public boolean empty()
    {
        return hand.isEmpty();
    }
    
    /**
     * Prints the hand with each card numbered and on a new line.
     */
    public void print()
    {
        /* Increments through the hand and prints each card. */
        for (int index = 0; index < hand.size(); index++)
        {
            Card card = hand.get(index);        // Represents the card to be printed
            System.out.println((index + 1) + ") " + card.toString());
        }
    }
    
    /**
     * Gives away the best diamond this hand posesses to the other hand.
     * 
     * @param other The hand that the diamonds will be given to.
     * @return Returns the card that was given away.
     */
    public Card giveBestDiamond(Hand other)
    {
        /* Gives away the best diamond. */
        if (!diamonds.empty())
        {
            Card card = diamonds.getBest();
            other.addDiamond(card);
            return card;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Gives away the worst diamond this hand posesses to the other hand.
     * 
     * @param other The hand that the diamonds will be be given to.
     * @return Returns the card that was given away.
     */
    public Card giveWorstDiamond(Hand other)
    {
        /* Gives away the worst diamond. */
        if (!diamonds.empty())
        {
            Card card = diamonds.getWorst();
            other.addDiamond(card);
            return card;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Adds a diamond to the diamonds associated with this hand.
     * 
     * @param card The diamond to be added.
     */
    public void addDiamond(Card card)
    {
        diamonds.add(card);
    }
    
    /**
     * Prints the diamonds associated with this hand in a list format.
     */
    public void printDiamonds()
    {
        diamonds.print();
    }
    
    /**
     * Adds a card to this hand, or to the diamonds associated with this hand,
     * as appropriate.
     * 
     * @param card The card to be added.
     */
    public void add(Card card)
    {
        /* Determines if the card is a diamond and adds it to the appropriate place. */
        if (card.getSuit() == Suit.diamond)
        {
            diamonds.add(card);
        }
        else
        {
            hand.add(card);
        }
        Collections.sort(hand);
    }
    
    /**
     * Converts this hand to a String format.
     * 
     * @return Returns a string containing all the cards in this hand
     * and the diamonds associated with it in list format.
     */
    public String toStringAll()
    {
        String cards = "";      // The string that contains the list of cards.
        /* Increments through all the cards in this hand. */
        for (int index = 0; index < hand.size(); index++)
        {
            Card card = hand.get(index); // The card to be added to the string.
            cards += card.toString();
            /* Adds a comma if there are more cards to be printed. */
            if (index < hand.size() - 1)
            {
                cards += ", ";
            }
        }
        /* Prints the diamonds associated with this hand if there are any. */
        if (!diamonds.empty())
        {
            /* Prints without a comma in front if nothing has been printed so far. */
            if (!hand.isEmpty())
            {
                return cards + ", " + diamonds.toString();
            }
            /* Prints with a comma in front if other cards have already been printed. */
            else
            {
                return cards + diamonds.toString();
            }
        }
        /* Returns the string without diamonds if there are no diamonds to add. */
        else
        {
            return cards;
        }
    }
    
    /**
     * Gives the total score of the diamonds associated with this hand.
     * 
     * @return Returns the total of all the diamonds associated with this hand.
     */
    public int score()
    {
        return diamonds.score();
    }
}
