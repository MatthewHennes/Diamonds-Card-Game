import java.util.ArrayList;
import java.util.Collections;

/**
 * This class simply holds the diamonds that a player currently has control of.
 * 
 * @author Matt Hennes
 * @version 10/11/13
 */
public class Diamonds
{
    /** The ArrayList of cards that holds the diamond cards. */
    private ArrayList<Card> diamonds;
    
    /**
     * Constructs a new empty Diamonds.
     */
    public Diamonds()
    {
        diamonds = new ArrayList<Card>();
    }
    
    /**
     * Adds the given card to the diamons.
     * 
     * @param diamond The card to be added.
     * @return Returns true if the diamond is added and
     * false if the card passed in is null.
     */
    public boolean add(Card diamond)
    {
        /* Checks if diamond is null and adds it to the diamons if not. */
        if (diamond != null)
        {
            diamonds.add(diamond);
            Collections.sort(diamonds);
            return true;
        }
        return false;
    }
    
    /**
     * Gets the diamon at the specified index.
     * 
     * @param index The index of the diamond to be returned.
     * @return Returns the diamond specified.
     */
    public Card get(int index)
    {
        return diamonds.remove(index);
    }
    
    /**
     * Tells whether or not this Diamonds is empty.
     * 
     * @return Returns true if the Diamonds is empty and
     * false if there are cards remaining.
     */
    public boolean empty()
    {
        /* Checks if there are diamonds remaining, and returns tue if not. */
        if (diamonds.isEmpty())
        {
            return true;
        }
        return false;
    }
    
    /**
     * Gives the best diamond.
     * 
     * @return Returns the best diamond that this Diamonds holds (in terms of points).
     */
    public Card getBest()
    {
        /* Returns the last diamond in the list,
         * which is the most valuable because of the way the
         * list is sorted.
         */
        return diamonds.remove(diamonds.size() - 1);
    }
    
    /**
     * Gives the worst diamond.
     * 
     * @return Returns the worst diamond that this Diamonds holds (in terms of points).
     */
    public Card getWorst()
    {
        return diamonds.remove(0);
    }
    
    /**
     * Prints the diamonds in a numbered list format with each card on a new line.
     */
    public void print()
    {
        /* Increments through all the cards and prints each one on a new line
         * with a number */
         /* The above comment did not show up in the checkstyle. */
        for (int index = 0; index < diamonds.size(); index++)
        {
            Card card = diamonds.get(index);
            System.out.println((index + 1) + ") " + card.toString());
        }
    }
    
    /**
     * Changes this Diamonds into a string representation in list form.
     * 
     * @return Returns a string containging all the diamonds in list form.
     */
    public String toString()
    {
        String cards = ""; // The string containig all the diamonds
        /* Increments through all the diamonds and adds each one to the string */
        for (int index = 0; index < diamonds.size(); index++)
        {
            Card card = diamonds.get(index); // The card to be added to the string
            cards += card.toString();
            /* Adds a comma if there are more diamonds to be printed. */
            if (index < diamonds.size() - 1)
            {
                cards += ", ";
            }
        }
        return cards;
    }
    
    /**
     * Gives the total score of all the diamonds contained here.
     * 
     * @return Returns the total score of all the diamonds contained here.
     */
    public int score()
    {
        int score = 0; // The score of these diamonds.
        /* Increments through all the diamonds and adds up the total score */
        for (int index = 0; index < diamonds.size(); index++)
        {
            score += diamonds.get(index).getValue().points();
        }
        return score;
    }
}
