package casino.core;

import static casino.core.BlackjackDefaults.*;

import java.util.ArrayList;

/**
 * A list of Card class elememts. contains methods for shuffling and drawing
 * cards
 */

public class CardDeck {

    public ArrayList<Card> deck;

    /**
     * creates a new standard, sorted carddeck
     */
    public CardDeck() {
        ArrayList<Card> sortedDeck = new ArrayList<>(52);

        for (Suit suit : SUITS) {
            for (Value value : VALUES) {
                sortedDeck.add(new Card(suit, value));
            }
        }
        deck = sortedDeck;
    }

    /**
     * creates numberOfTimes amount of carddecks, then shuffles them together to one
     * deck.
     * 
     * @param numberOfTimes
     */
    public void multiplyAndShuffleDeck(int numberOfTimes) {
        ArrayList<Card> deck = new ArrayList<>();

        for (int i = 0; i < numberOfTimes; i++) {
            deck.addAll(this.deck);
        }
        java.util.Collections.shuffle(deck);

        this.deck = deck;
    }

    /**
     * @return and removes top card from deck.
     */
    public Card draw() {
        Card newCard = deck.remove(0); // removes the card on the top of the deck
        return newCard;
    }

}
