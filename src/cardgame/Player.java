
package cardgame;


/**
 *
 * @author Samarth Patel
 */
public class Player {
    private Card[] hands;
    private int numsOfCards;

    // Constructor for the Player
    public Player() {
        hands = new Card[10]; // Maximum 10 cards per hands
        numsOfCards = 0;
    }

    // this is method to add  card to the player's hands
    public void addCardTohands(Card card) {
        if (numsOfCards < hands.length) {
            hands[numsOfCards] = card;
            numsOfCards++;
        } else {
            System.out.println("Cannot add more cards to hand.");
        }
    }

    // this method to calculate value of the player's hand
    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (int i = 0; i < numsOfCards; i++) {
            if (hands[i].getValus() == Card.Value.ACE) {
                numAces++;
            }
            value += hands[i].getNumericValues();
        }

        while (value > 21 && numAces > 0) {
            value -= 10; // Convert into Ace from 11 to 1
            numAces--;
        }

        return value;
    }

    // this method to get the numbers of cards in the player's hand
    public int getNumberOfCards() {
        return numsOfCards;
    }
}