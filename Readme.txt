Matt Hennes
Diamonds Card Game User Guide

Overview
Diamonds is a relatively simple card game that I created. The goal of the game is simple: end the game with more points than the opponent by accumulating cards of the diamond suit. Points are awarded based on the rank of the card. Aces through fives are worth one point, sixes through nines tens are worth 2 points, and face cards are worth three points. When the game begins, each of the two players is dealt 3 cards. Any diamonds the player draws are placed in a pool of diamonds for that player, separate from their hand. Then the players take turns making moves. A move begins by drawing a card from the deck (if the deck is not empty), then choosing a card to play from their hand. The card that is played has an effect based on its suit. Clubs take diamonds (by force) from the opponent. If the player plays a club, they may take diamond cards from their opponent equal to the value of their card (the same values used for scoring). The player takes their opponent’s most valuable diamonds. For example, if the player played the four of clubs, they would take their opponent’s most valuable diamond card, and if the player played the jack of clubs, they would take their opponent’s three most valuable diamond cards. If the player plays a heart, they MUST give their opponent diamond cards from their own stack. The diamond cards they give away are the player’s least valuable diamonds. Again, the number of cards given is equal to the value of the card played, so if the player played an eight of hearts, they must give their opponent their two least valuable diamond cards. Finally, if the player plays a spade, they may draw cards from the deck equal to the value of the card they played. So if the player uses the 10 of spades, they may draw 2 cards from the deck and add them to either their hand or their pool of diamonds accordingly. The game ends when both players have used all the cards in their hands and there are no more cards left in the deck.

Input Requirements
Throughout the game, the user will be asked to:
1)	Press the ‘Enter’ key to draw a card.
2)	Enter the number displayed on screen corresponding to the card they wish to play.
3)	Press the ‘Enter’ key to see the computer’s move.
All of these interactions will be accomplished though typing into the command line, where all game information is displayed.
Output Requirements
1.	Prompt for player to draw a card – “Press enter to draw.”
2.	Display of the cards in your hand – a numbered list of the cards in your hand
3.	Display the diamonds the player holds – a list of the player’s diamonds
4.	Display the diamonds the computer holds – a list of the computer’s diamonds
5.	Prompt for the player to enter the card they would like to play – “Enter the number corresponding to the card you would like to play.”
6.	A message indicating that the user stole diamonds from the computer – “You stole [number of cards stolen] diamonds! [list of the cards stolen]”
7.	A message indicating that the user gave diamonds to the computer – “You gave [number of cards given] diamonds away! [list of the cards given]”
8.	A message indicating that you drew cards from the deck – “You drew [number of cards drawn] cards. [list of the cards drawn]”
9.	A message indicating the card the computer played – “The computer played the [rank of card] of [suit of card]s”
10.	A message indicating that the computer stole diamonds from you – “[number of cards stolen] have been stolen from you! [list of cards stolen]”
11.	A message indicating that the computer gave diamonds to you – “[number of cards given] have been given to you! [list of cards given]”
12.	A message indicating that the computer drew cards – “The computer drew [number of cards drawn] cards.”
13.	A message indicating that the deck is empty – “The deck is out of cards. You cannot draw.”
14.	A message indicating that the player has no cards to play – “You have no cards to play.”
15.	A message indicating that the computer has no cards to play – “The computer has no cards to play.”
16.	A prompt for the player to press enter to see the computer’s move – “Press enter to see the computer’s move.”
17.	A message indicating that the game is over and the scores – “Game over. Your score: [score], computer’s score: [score]”
18.	A message indicating that the player lost – “The computer won.”
19.	A message indicating that the player won – “You won!”
Operating Instructions
Program Startup
1.	Launch the program from the command line by typing java Game
Playing the Game
2.	A prompt to press enter to draw is displayed.
3.	The player’s hand, diamonds, and the computer’s diamonds are displayed.
4.	The player is asked to select a card from their hand to play. The player must enter a number corresponding to the card they wish to play (the cards in their hand are displayed with a number next to them). The number must correspond to a card the player has in their hand, and the program will not advance until a valid entry is input.
5.	The program will display the results of the player’s move, as described above.
6.	The program will then ask the player to press enter to see the computer’s move.
Ending the Game
7.	The game ends when there are no cards remaining in the deck or either player’s hand.
8.	At this time, the program displays the scores and who won the game.
9.	The program terminates.
