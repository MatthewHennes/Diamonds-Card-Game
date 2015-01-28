/**
 * This defines the various values that a card can have.
 * 
 * @author Matt Hennes
 * @version 10/11/13
 */
public enum CardValue
{
    ace (1),
    two (1),
    three (1),
    four (1),
    five (1),
    six (2),
    seven (2),
    eight (2),
    nine (2),
    ten (2),
    jack (3),
    queen (3),
    king (3);
    
    /** The point value of this rank. */
    private final int points;
    
    /**
     * Constructs a new CardValue with the given points.
     * 
     * @param points The number of points to be assigned to this value.
     */
    private CardValue(int points)
    {
        this.points = points;
    }
    
    /**
     * Gives the points associated with that value.
     * 
     * @return Returns the number of points associated with that value.
     */
    public int points()
    {
        return points;
    }
}
