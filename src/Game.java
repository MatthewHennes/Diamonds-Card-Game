import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

/**
 * This class runs the main logic of the game.
 * 
 * @author Matt Hennes
 * @version 10/11/13
 */
public final class Game
{
    /** The deck of playing cards that will be used for the game */
    private Deck deck;
    /** The hand of cards belonging to the human player */
    private Hand playerHand;
    /** The hand of cards belonging to the "artificial intelligence" */
    private Hand computerHand;
    /** The number of cards to initially deal */
    private final static int kCardsToDeal = 3;
    
    /**
     * Constructs a new instance of the Game class.
     * That game will be used to run the main logic and
     * rules of the game.
     */
    private Game()
    {
        deck = new Deck();
        playerHand = new Hand();
        computerHand = new Hand();
    }
    
    /**
     * Runs the game.
     * 
     * @param args Takes command line arguments (and does nothing with them).
     */
    public static void main(String[] args)
    {
        Game game = new Game(); // The instance of game that is used to run the game.
        game.firstDeal();
        /* Continues to alternate between the human player's turn
         * and the computer's turn until the deck, the player's hand,
         * and the computer's hand are all out of cards.*/
        /* The above comment did not show up on the checkstyle. */
        do
        {
            Scanner advancer = new Scanner(System.in);
            game.playerTurn(advancer);
            System.out.println("");
            System.out.println("Press enter to see the computer's move.");
            /* Waits for the player to press enter to see the computer's next move. */
            advancer.nextLine();
            /* Draws a card for the computer if the deck still has cards remaining. */
            if (!game.deck.empty())
            {
                game.computerHand.draw(game.deck);
            }
            /* Plays the first card in the computer's hand. */
            if (!game.computerHand.empty())
            {
                game.computerPlayCard(game.computerHand.playCard(0), game.computerHand,
                    game.playerHand);
            }
            else
            {
                System.out.println("The computer has no cards to play.");
            }
            System.out.println("");
        }
        while (!(game.deck.empty() && game.playerHand.empty() &&
            game.computerHand.empty()));
        int playerScore = game.playerHand.score(); // The score of the human player.
        int computerScore = game.computerHand.score();  // Computer score.
        /* Prints the scores of the game. */
        System.out.println("Game over. Your score: " + playerScore +
            ", computer's score: " + computerScore);
        /* Prints that the human player won. */
        if (playerScore > computerScore)
        {
            System.out.println("You won!");
        }
        /* Prints that the computer won. */
        else if (computerScore > playerScore)
        {
            System.out.println("The computer won.");
        }
        /* Prints that the game was a tie. */
        else
        {
            System.out.println("Tie game.");
        }
    }
    
    /**
     * Deals the first three cards to each player at the start of the game.
     */
    private void firstDeal()
    {
        int count = 0;
        /* deals 3 cards to each player. */
        while (count < kCardsToDeal)
        {
            playerHand.draw(deck);
            computerHand.draw(deck);
            count++;
        }
    }
    
    /**
     * This method controls the player's turn. It involves drawing a card,
     * accepting input for the card the
     * player would like to play, and taking the appropriate actions
     * for the card the player chose.
     */
    private void playerTurn(Scanner playerScanner)
    {
        /* Checks if the deck is empty, and if not, allows the player to draw a card. */
        if (!deck.empty())
        {
            System.out.println("Press enter to draw.");
            /* Waits for the player to press enter before drawing a card. */
            playerScanner.nextLine();
            playerHand.draw(deck);
        }
        /* Determines that the deck is out of cards and prints a message saying so. */
        else
        {
            System.out.println("The deck is out of cards. You cannot draw.");
        }
        System.out.println("Your hand:");
        playerHand.print();
        System.out.println("Your diamonds:");
        playerHand.printDiamonds();
        System.out.println("Your opponent's diamonds:");
        computerHand.printDiamonds();
        
        /* Determines if the player's hand is empty. */
        playerScanCard(playerScanner);
    }
    
    /**
     * Scans and plays the card the player chooses.
     */
    private void playerScanCard(Scanner play)
    {
        /* Determines if the player's hand is empty. */
        if (!playerHand.empty())
        {
        	String scannedCard;
            int playCard;                           // Chosen card.
            boolean playScanned = false;            // valid card chosen?
            Card playedCard;                        // Card to play
            /* Asks for input until the player chooses a valid card to play. */
            while (!playScanned)
            {
                /* Tries to take input from the player. */
                try
                {
                    System.out.printf("Enter the number corresponding to the card");
                    System.out.printf(" you would like to play.");
                    /* Scans the integer the player input. */
                    //playCard = play.nextInt();
                    scannedCard = play.nextLine();
                    playCard = Integer.parseInt(scannedCard);
                    playScanned = true;
                    /* Plays the card the player selected.*/
                    playedCard = playerHand.playCard(playCard - 1);
                    playerPlayCard(playedCard, playerHand, computerHand);
                }
                catch (InputMismatchException exception)
                {
                    playScanned = false;
                }
                catch (NoSuchElementException exception)
                {
                    playScanned = false;
                }
                catch (IllegalStateException exception)
                {
                    playScanned = false;
                }
                catch (NumberFormatException exception)
                {
                	playScanned = false;
                }
            }
        }
        /* Determines that the player has no cards to play. */
        else
        {
            System.out.println("You have no cards to play.");
        }
    }
    
    /**
     * Plays the card the player has selected
     * and takes the appropriate actions depending on the card
     * that was played.
     * 
     * @param card          The card to be played.
     * @param thisHand      Represents the hand that the card is being played from.
     * @param otherHand     Represnets the hand of the other player
     * (the hand a card is NOT being played from.
     */
    private void playerPlayCard(Card card, Hand thisHand, Hand otherHand)
    {
        /* Checks if the card is a heart, and takes the appropriate actions if it is. */
        if (card.getSuit() == Suit.heart)
        {
            Diamonds given = new Diamonds();    // Diamonds that were given away
            int cardsGiven = 0;                 // Diamonds that were given away
            boolean notDone = true;             // program should give another diamond
            System.out.printf("You gave ");
            /* Gives diamond cards away. */
            do
            {
                /* gives a diamond to the opponent. */
                notDone = given.add(thisHand.giveWorstDiamond(otherHand));
                /* Increments the number of cards given if a card was given above */
                if (notDone)
                {
                    cardsGiven += 1;
                }
            }
            while (notDone && cardsGiven < card.getValue().points());
            
            /* Prints the message of how many and which cards were given away. */
            if (cardsGiven == 1)
            {
                System.out.printf(cardsGiven + " diamond away! " + given.toString() +
                    "\n");
            }
            else
            {
                System.out.printf(cardsGiven + " diamonds away! " + given.toString() +
                    "\n");
            }
        }
        /* Checks if the card is a club, and takes the appropriate actions if it is. */
        else if (card.getSuit() == Suit.club)
        {
            playerPlayClub(card, thisHand, otherHand);
        }
        /* Plays a spade card. */
        else
        {
            playerPlaySpade(card, thisHand, otherHand);
        }
    }
    
    /**
     * Plays a club card for the player.
     * 
     * @param card      The Card to be played.
     * @param thisHand  The hand that is playing the card
     * @param otherHand The hand that is not playing the card
     */
    private void playerPlayClub(Card card, Hand thisHand, Hand otherHand)
    {
        Diamonds taken = new Diamonds();    // Diamonds stolen.
        int cardsTaken = 0;                 // Diamonds stolen.
        boolean notDone = true;             // attempt to steal another diamond?
        System.out.printf("You stole ");
        /* Steals diamond cards. */
        do
        {
            /* steals a diamond fromt the opponent. */
            notDone = taken.add(otherHand.giveBestDiamond(thisHand));
            /* Incrememts the number of cards stolen if a card was stolen above. */
            if (notDone)
            {
                cardsTaken++;
            }
        }
        while (notDone && cardsTaken < card.getValue().points());
        /* Prints the message of how many and which cards were stolen. */
        if (cardsTaken == 1)
        {
            System.out.printf(cardsTaken + " diamond! " + taken.toString() + "\n");
        }
        else
        {
            System.out.printf(cardsTaken + " diamonds! " + taken.toString() + "\n");
        }
    }
    
    /**
     * Plays a spade card for the player.
     * 
     * @param card      The card to be played
     * @param thisHand  The hand the card is being played from
     * @param otherHand The hand the card is NOT being played from
     */
    private void playerPlaySpade(Card card, Hand thisHand, Hand otherHand)
    {
        Hand drawn = new Hand();    // Holds the cards that were drawn.
        int cardsDrawn = 0;         // Holds the number of cards that were drawn.
        /* Draws cards from the deck. */
        for (int index = 0; index < card.getValue().points(); index++)
        {
            /* Checks if deck is empty. */
            if (!deck.empty())
            {
                /* Draws a card. */
                drawn.add(thisHand.draw(deck));
                cardsDrawn++;
            }
        }
        /* Prints the message of how many and which cards were stolen. */
        if (cardsDrawn == 1)
        {
            System.out.println("You drew " + cardsDrawn + " card. " +
                drawn.toStringAll());
        }
        else
        {
            System.out.println("You drew " + cardsDrawn + " cards. " +
                drawn.toStringAll());
        }
    }
    
    /**
     * Plays the card the computer selected to play.
     * Identical to playerPlayCard except for the things that
     * are printed.
     * 
     * @param card          The cad to be played.
     * @param thisHand      Represents the hand that the card is being played from.
     * @param otherHand     Represents the hand of the other player
     * (the hand that the card is NOT being played from).
     */
    private void computerPlayCard(Card card, Hand thisHand, Hand otherHand)
    {
        System.out.println("The computer played " + card.toString());
        /* Checks if the card is a heart, and takes the appropriate actions if it is. */
        if (card.getSuit() == Suit.heart)
        {
            Diamonds given = new Diamonds(); // Holds the diamonds that were given away
            int cardsGiven = 0;    // Holds the number of diamonds that were given away
            boolean notDone = true; //attempt to give another diamond?
            /* Gives diamond cards away. */
            do
            {
                /* Gives a diamond away. */
                notDone = given.add(thisHand.giveWorstDiamond(otherHand));
                /* Increments the number of cards given if a card was given above */
                if (notDone)
                {
                    cardsGiven++;
                }
            }
            while (notDone && cardsGiven < card.getValue().points());
            /* Prints the message of how many and which cards were given away. */
            if (cardsGiven == 1)
            {
                System.out.printf(cardsGiven + " diamond has been given to you! " +
                    given.toString() + "\n");
            }
            else
            {
                System.out.printf(cardsGiven + " diamonds have been given to you! " +
                    given.toString() + "\n");
            }
        }
        /* Checks if the card is a club, and takes the appropriate actions if it is. */
        else if (card.getSuit() == Suit.club)
        {
            computerPlayClub(card, thisHand, otherHand);
        }
        /* Plays a spade card. */
        else
        {
            computerPlaySpade(card, thisHand, otherHand);
        }
    }
    
    /**
     * Plays a club for the computer.
     * 
     * @param card      The card to be played.
     * @param thisHand  The hand the card is being played from.
     * @param otherHand The hand the card is NOT being played from.
     */
    private void computerPlayClub(Card card, Hand thisHand, Hand otherHand)
    {
        Diamonds taken = new Diamonds(); // Holds the diamonds that were stolen.
        int cardsTaken = 0;    // Holds the number of diamonds that were stolen.
        boolean notDone = true; // Attempt to steal another diamond?
        /* Steals diamond cards. */
        do
        {
            /* Steals a diamond. */
            notDone = taken.add(otherHand.giveBestDiamond(thisHand));
            /* Incrememts the number of cards stolen if a card was stolen above. */
            if (notDone)
            {
                cardsTaken++;
            }
        }
        while (notDone && cardsTaken < card.getValue().points());
        /* Prints the message of how many and which cards were stolen. */
        if (cardsTaken == 1)
        {
            System.out.printf(cardsTaken + " diamond has been stolen from you! " +
                taken.toString() + "\n");
        }
        else
        {
            System.out.printf(cardsTaken + " diamonds have been stolen from you! " +
                taken.toString() + "\n");
        }
    }
    
    /**
     * Plays a spade for the computer.
     * 
     * @param card      The card to be played.
     * @param thisHand  The hand the card is being played from.
     * @param otherHand The hand the card is NOT being played from.
     */
    private void computerPlaySpade(Card card, Hand thisHand, Hand otherHand)
    {
        Hand drawn = new Hand();        // Holds the cards that were drawn.
        int cardsDrawn = 0;             // Holds the number of cards that were drawn.
        /* Draws cards from the deck. */
        for (int index = 0; index < card.getValue().points(); index++)
        {
            /* Checks if the deck is empty. */
            if (!deck.empty())
            {
                /* Draws a card. */
                drawn.add(thisHand.draw(deck));
                cardsDrawn++;
            }
        }
        /* Prints the message of how many and which cards were drawn. */
        if (cardsDrawn == 1)
        {
            System.out.println("The computer drew " + cardsDrawn + " card.");
        }
        else
        {
            System.out.println("The computer drew " + cardsDrawn + " cards.");
        }
    }
}
