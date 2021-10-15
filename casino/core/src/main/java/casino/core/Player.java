package casino.core;

import java.util.ArrayList;
import java.util.List;

/**
 * The contestants in Blackjack game. handles in game sums and cards.
 */

public class Player {

    public UserInfo userInfo;

    // variables for Blackjack
    private final List<Card> hand = new ArrayList<>();
    private int hardSum = 0;
    private int softSum = 0;

    public Player(UserInfo user) {
        this.userInfo = user;
    }

    public void setUserInfo(UserInfo user) {
        this.userInfo = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public String getName() {
        return userInfo.getUsername();
    }

    public int getBalance() {
        return userInfo.getBalance();
    }

    /**
     * Sets the players balance
     * 
     * @param int balance
     * @throws IllegalArgumentException if balance < 0
     */
    public void setBalance(int balance) throws IllegalArgumentException {
        userInfo.setBalance(balance);
    }

    public void addToBalance(int value) throws IllegalArgumentException {
        userInfo.addToBalance(value);
    }

    public void removeFromBalance(int value) throws IllegalArgumentException {
        userInfo.removeFromBalance(value);
    }

    /**
     * sets players name and balance to themself.
     * 
     * @param player
     */
    public void updatePlayer(Player player) {
        setUserInfo(player.getUserInfo());
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
