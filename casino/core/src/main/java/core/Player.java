package core;

import java.util.ArrayList;
import java.util.List;

/**
 * The contestants in Blackjack game. handles player name, balance, in game sums
 * and cards in hand.
 */

public class Player {

    private String name;
    private int balance;

    // variables for Blackjack
    private final List<Card> hand = new ArrayList<>();
    private int hardSum = 0;
    private int softSum = 0;

    public Player(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be blank.");
        }
        this.name = name;
    }

    public Player(String name, int balance) {
        this(name);
        if (balance < 0) {
            throw new IllegalArgumentException("Player balance must be positive.");
        }
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Sets the players name
     * 
     * @param String name
     */
    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be blank.");
        } else {
            this.name = name;
        }
    }

    public int getBalance() {
        return this.balance;
    }

    /**
     * Sets the players balance
     * 
     * @param int balance
     * @throws IllegalArgumentException if balance < 0
     */
    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be positive.");
        } else {
            this.balance = balance;
        }
    }

    /**
     * Value must be positive.
     *
     * @param value to add to the balance
     * @throws IllegalArgumentException if value < 0
     */
    public void addToBalance(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value to be added must be positive.");
        } else {
            this.balance += value;
        }
    }

    /**
     * Value cannot be greater than players balance.
     *
     * @param value to remove from the value
     * @throws IllegalArgumentException if value is greater than players balance
     */
    public void removeFromBalance(int value) {
        if (value > balance) {
            throw new IllegalArgumentException("Value to be removed cannot be greater than the players balance.");
        } else {
            this.balance -= value;
        }
    }

    /**
     * sets players name and balance to themself.
     * 
     * @param player
     */
    public void updatePlayer(Player player) {
        setName(player.name);
        setBalance(player.balance);
    }

    /**
     * @return cards in players hand.
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * @param card to add to the hand
     */
    public void addCardToHand(Card card) {
        hand.add(card);
        hardSum += card.getValue().getBjValue();
        softSum += card.getValue().getAltValue();
    }

    /**
     * 
     * @return highest current cardssum in the game.
     */
    public int getHardSum() {
        return hardSum;
    }

    /**
     * @return sum of cards in players hand.
     */
    public int getSoftSum() {
        return softSum;
    }

    /**
     * 
     * @return a string containing softsum and hardsum if they're different and
     *         below 21. Else returns softsum
     */
    public String getTotalSum() {
        if (hardSum != softSum && hardSum < 21) {
            return softSum + "/" + hardSum;
        }
        return Integer.toString(softSum);
    }
}
