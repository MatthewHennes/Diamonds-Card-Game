/**
 * The card class is used to represent the playing cards.
 * A card can be made for each combination of
 * suit and value (2-9, Jack, Queen, King, and Ace).
 * @author Matt Hennes
 * @version 10/11/13
 */
public class Card implements Comparable
{
    /** Holds the suit of the card */
    private Suit suit;
    /** Holds the rank of the card */
    private CardValue value;
    
    /**
     * Constructs a new Card with the given suit and rank.
     * 
     * @param suit      The suit of the new card.
     * @param value     The rank of the new card.
     */
    public Card(Suit suit, CardValue value)
    {
        this.suit = suit;
        this.value = value;
    }
    
    /**
     * Gives the suit of the card.
     * 
     * @return Returns the suit of the card.
     */
    public Suit getSuit()
    {
        return suit;
    }
    
    /**
     * Gives the rank of the card.
     * 
     * @return Returns the rank of the card.
     */
    public CardValue getValue()
    {
        return value;
    }
    
    /**
     * Compares a card to another card in order to sort cards.
     * Sorts according to suit first and then
     * rank.
     * 
     * @param other The card for this card to be compared to.
     * @return Returns negative if this card comes before the other card,
     * and positive if this card comes after the other card
     */
    public int compareTo(Object other)
    {
        /* Checks if the other object is a card at all and returns -1 if it is not. */
        if (other.getClass() != Card.class)
        {
            return -1;
        }
        
        /* Returns the appropriate value based on the enums' built-in compareTo methods,
         * which are based on
         * the order of the listed constants.
         */
        /* The comment above did not show up on the checkstyle. */
        if (suit != ((Card) other).getSuit())
        {
            return suit.compareTo(((Card) other).getSuit());
        }
        /* Determines that the suits are different, and compares the values. */
        else
        {
            return value.compareTo(((Card) other).getValue());
        }
    }
    
    /**
     * Converts the card to a string containing its rank and suit.
     * 
     * @return Returns a string representing the card.
     */
    public String toString()
    {
        return "the " + value + " of " + suit + "s";
    }
}
