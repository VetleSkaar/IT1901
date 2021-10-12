package core;

/**
 * Contains logic for handling a standard 52-card type card. Uses help classes Suit and Value
 */

public class Card{
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }
    @Override
    public String toString(){
        String result = "";

        result += suit.getSymbolW();
        result += "";
        result += value.getValueAsString(true);

        return result;
    }
}
