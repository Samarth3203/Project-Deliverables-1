
package cardgame;

import java.util.Scanner;

/**
 *
 * @author Meet Mistry
 */
public class BlackjackGame {
   private Player player;
    private Player dealer;
    private Deck deck;

    // Constructor for BlackjackGame
    public BlackjackGame() {
        // Initialize player, dealer, and deck
        player = new Player();
        dealer = new Player();
        deck = new Deck();
    }

    // Method to start the Blackjack game
    public void play() {
        // Shuffle the deck
        deck.shuffle();

        // Deal initial cards to player and dealer
        player.addCardTohands(deck.drawCard());
        dealer.addCardTohands(deck.drawCard());
        player.addCardTohands(deck.drawCard());
        dealer.addCardTohands(deck.drawCard());

        // Display initial hands
        System.out.println("Player's Hands: " + player.getHandValue());
        System.out.println("Dealer's Hands: " + dealer.getHandValue());

        // Player's turn
        if (!GameLogic.isPlayerDone(player)) {
            playerAction();
        }

        // Dealer's turn
        while (!GameLogic.isDealersDone(dealer) && !GameLogic.isBust(dealer)) {
            dealer.addCardTohands(deck.drawCard());
            System.out.println("Dealer's Hands: " + dealer.getHandValue());
        }

        // Determine winner
        GameLogic.determineWinner(player, dealer);
    }

    // Method to prompt player for action (hit or stand)
    @SuppressWarnings("resource")
    private void playerAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to take hit or stand? (h/s)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("h")) {
            player.addCardTohands(deck.drawCard());
            System.out.println("Player's Hand after hitting: " + player.getHandValue());
            if (GameLogic.isBust(player)) {
                System.out.println("Player busts! Dealer wins.");
                System.exit(0); // Exit  game
            } else if (!GameLogic.isPlayerDone(player)) {
                playerAction(); // Prompt to the player for action again if they choose to hit
            }
        }
    }
}