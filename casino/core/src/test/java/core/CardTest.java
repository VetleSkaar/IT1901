package core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardTest {

    Value eight, king;
    Suit suit;
    Card eightOfSpades, kingOfSpades;

    @BeforeEach
    public void setup() {
        eight = new Value("Eight", 8);
        suit = new Suit("Spade", "♠", "♤");
        Value king = new Value("King", 13, 10);
        eightOfSpades = new Card(suit, eight);
        kingOfSpades = new Card(suit, king);
    }

    @Test
    public void testNumberCard() {
        assertEquals(eightOfSpades.getSuit(), suit);
        assertEquals(eightOfSpades.getValue(), eight);
    }

    @Test
    public void testToString() {
        assertEquals(eightOfSpades.toString(), "♠8");
    }

    @Test
    public void testFaceCardToString() {
        assertEquals(eightOfSpades.toString(), "♠K");
    }

}
