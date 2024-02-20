package cardgame;
/**
 * Author:Samarth Patel
 */
import java.util.Random;

public class CardHandGenerator {
    public static Card[] generateHands(int numCards) {
        Card[] hand = new Card[numCards];
        Random random = new Random();

        for (int i = 0; i < hand.length; i++) {
            int numValues = Card.Value.values().length;
            Card.Value value = Card.Value.values()[random.nextInt(numValues)];

            int numSuits = Card.Suit.values().length;
            Card.Suit suits = Card.Suit.values()[random.nextInt(numSuits)];

            Card card = new Card(value, suits);
            hand[i] = card;
        }
        return hand;
    }
}