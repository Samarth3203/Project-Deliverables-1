
package cardgame;

/**
 *
 * @author Preet patel
 */
class Card {
 public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACKs, QUEENs, KINGs
    }

    private final Suit suits;
    private final Value value;

    public Card(Value value, Suit suits) {
        this.value = value;
        this.suits = suits;
    }

    public Suit getSuits() {
        return suits;
    }

    public Value getValus() {
        return value;
    }

    public int getNumericValues() {
        switch (value) {
            case ACE:
                return 1; 
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            default:
                return 10; // For Jacks, Queens, Kings
        }
    }
}