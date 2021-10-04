package core;

public class Suit {

    private final String suit;
    private final String symbolB;
    private final String symbolW;

    public Suit(String suit, String symbolB, String symbolW){
        this.suit = suit;
        this.symbolB = symbolB;
        this.symbolW = symbolW;

    }

    public String getSuit() {
        return suit;
    }
    /* Returns symbol for black card */
    public String getSymbolB() {
        return symbolB;
    }
    /* Returns symbol for white card */
    public String getSymbolW() {
        return symbolW;
    }

}