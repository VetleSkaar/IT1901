package casino.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static casino.core.BlackjackDefaults.*;

public class BlackjackTest {

    private Player player = new Player(new UserInfo("Player"));
    private Blackjack blackjack;

    private CardDeck cardDeck = new CardDeck();

    @BeforeEach
    public void setUp() {
        blackjack = new Blackjack();
        blackjack.setRegisteredPlayer(player);
        blackjack.setPlayableDeck(cardDeck);

    }

    @Test
    public void testGetRegisteredPlayer() {
        assertEquals(blackjack.getRegisteredPlayer(), player);
    }

    @Test
    public void testStart() {
        blackjack.start();
        List<Card> cardsInHand = new ArrayList<Card>();
        for (Card card : player.getHand()) {
            cardsInHand.add(card);
        }
        List<Card> dealerCards = new ArrayList<Card>();
        for (Card card : DEALER.getHand()) {
            dealerCards.add(card);
        }
        assertEquals(cardsInHand.size(), 2);
        assertEquals(dealerCards.size(), 2);
    }

    /**
     * First Card in an unshuffled dec should be King of Spades. Checks that hit()
     * deals the player this card.
     */
    @Test
    public void testHit() {
        blackjack.hit(player);
        List<Card> cardsInHand = new ArrayList<Card>();
        for (Card card : player.getHand()) {
            cardsInHand.add(card);
        }
        assertEquals(cardsInHand.size(), 1);
        Card newCard = player.getHand().get(0);
        assertEquals("Spade", newCard.getSuit().getSuit());
    }

    /**
     * When player hits, this should be added to history. All other actions uses
     * same code for adding to history. If it works for hit, it works for all.
     */
    @Test
    public void testGetHistory() {
        blackjack.hit(player);
        String history = blackjack.getHistory();
        assertTrue(history.contains("Player Hits"));
    }

    @Test
    public void playDealer() {
        blackjack.playDealer();
        assertEquals(20, DEALER.getHardSum());
    }

}
