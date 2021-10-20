package casino.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    }

    /*
     * @Test public void testGetHistory() { blackjack.hit(player); String history =
     * "Player Hits, they got ♠K. They now have: " + player.getHand() + ". Total: "
     * + player.getTotalSum(); assertEquals(history, blackjack.getHistory());
     * 
     * }
     */

}
