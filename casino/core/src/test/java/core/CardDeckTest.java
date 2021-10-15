package core;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardDeckTest {

    CardDeck deck;

    @BeforeEach
    public void setup() {
        deck = new CardDeck();
    }

    @Test
    public void testDraw() {
        Card card = deck.draw();
        assertNotNull(card);
    }

    /*@Test
    public void testMultiplyAndShuffle() {
        deck.multiplyAndShuffleDeck(2);
        for (int i = 0; i < 105; i++) {
            deck.draw();
        }
        assertThrows(Exception.class, () -> {
            deck.draw();
        });
    }*/

}
