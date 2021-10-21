package casino.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    /*
     * @Test public void testToString() { assertEquals(eightOfSpades.toString(),
     * "♠8"); }
     */

    @Test
    public void testFaceCardToString() {
        assertNotEquals(eightOfSpades.toString(), "♠K");
    }

    @Test
    public void testAltValueCard() {
        Value ace = new Value("Ace", 14, 10, 1);
        Card aceOfSpades = new Card(suit, ace);
        assertEquals(1, aceOfSpades.getValue().getAltValue());
        assertEquals(10, aceOfSpades.getValue().getBjValue());
        assertEquals(14, aceOfSpades.getValue().getValue());
        assertEquals("Ace", aceOfSpades.getValue().getName());
    }

    @Test
    public void testGetSuits() {
        assertEquals("Spade", eightOfSpades.getSuit().getSuit());
        assertEquals("♤", eightOfSpades.getSuit().getSymbolW());
        assertEquals("♠", eightOfSpades.getSuit().getSymbolB());
    }

    @Test
    public void testToString() {
        String eightofSpadesString = "♤8";
        assertEquals(eightofSpadesString, eightOfSpades.toString());
    }

}
