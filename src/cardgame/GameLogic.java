
package cardgame;

import java.util.Scanner;
/**
 *
 * @author DEv Patel
 */
public class GameLogic {
   public static final int BLACKJACK_VALUE = 21;

    
    public static boolean isBlackjacks(Player player) {
        return player.getHandValue() == BLACKJACK_VALUE && player.getNumberOfCards() == 2;
    }

    // This ethod to check if  player has busted (hand value exceeds 21)
    public static boolean isBust(Player player) {
        return player.getHandValue() > BLACKJACK_VALUE;
    }

    // this method to check if  dealer is done (hand value >= 17)
    public static boolean isDealersDone(Player dealer) {
        return dealer.getHandValue() >= 17;
    }

    /**
	 * This method to check if the player was done (hit or stand)
	 * @param player
	 */
    @SuppressWarnings("resource")
    public static boolean isPlayerDone(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to hit or stand? (h/s)");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("s");
    }

    // Method to determine  winner of the game
    public static void determineWinner(Player player, Player dealer) {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        if (playerValue > BLACKJACK_VALUE) {
            System.out.println("Player busts! Dealer wins.Ahaha");
        } else if (dealerValue > BLACKJACK_VALUE) {
            System.out.println("Dealer busts! Player wins.OHooo");
        } else if (playerValue == dealerValue) {
            System.out.println("It's tie!");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins!,Hurrey");
        } else {
            System.out.println("Dealer wins!ohh shit");
        }
    }
}