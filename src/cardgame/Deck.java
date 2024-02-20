
package cardgame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Dev Patel
 */
public class Deck {
  private List<Card> cards;

    // Constructor for Deck
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    // Method to initialize the deck with all cards
    private void initializeDeck() {
        for (Card.Suit suits : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards.add(new Card(value, suits));
            }
        }
    }

    // Method to shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to draw a card from the deck
    public Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty. Cannot draw a card.");
            return null;
        }
        return cards.remove(0);
    }
}