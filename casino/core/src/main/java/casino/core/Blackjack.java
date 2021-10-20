package casino.core;

import static casino.core.BlackjackDefaults.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * main logic for game blackjack.
 */

public class Blackjack {

    public CardDeck playableDeck;

    private Player registeredPlayer;
    private Player currentPlayer;

    private final List<String> turnHistory = new ArrayList<>();

    private final List<Action> actions = ACTIONS;

    public Player getRegisteredPlayer() {
        return registeredPlayer;
    }

    public void setRegisteredPlayer(Player registeredPlayer) {
        this.registeredPlayer = registeredPlayer;
    }

    public void setPlayableDeck(CardDeck deck) {
        this.playableDeck = deck;
    }

    private void nextPlayer() {
        if (currentPlayer == DEALER)
            currentPlayer = registeredPlayer;
        else
            currentPlayer = DEALER;
    }

    /**
     * Checks if a players sum is over 21.
     * 
     * @param player to check.
     */
    private void checkBust(Player player) {
        if (player.getSoftSum() > 21) {
            addToHistory(player.getName() + " busted.");

        }
    }

    /**
     * @return a String containing every action made during game seperated by \n.
     */
    public String getHistory() {
        StringBuilder history = new StringBuilder();

        for (String line : turnHistory) {
            history.append(line);
            history.append("\n");
        }
        return history.toString();
    }

    private void addToHistory(String event) {
        turnHistory.add(event);
    }

    /**
     * if no cards are drawn.
     * 
     * @return a String of the event "players 'action's".
     */
    private String createEvent(Player player, Action action) {
        return player.getName() + " " + action.getName() + "s";
    }

    /**
     * if a card is drawn.
     * 
     * @return a String of the event "'Player' got 'Card'. They now have 'All
     *         Cards'. Total: 'total sum'".
     */
    private String createEvent(Player player, Card card) {
        return player.getName() + " got " + card + ". They now have: " + player.getHand() + ". Total: "
                + player.getTotalSum();
    }

    /**
     * event for when cardss are being hit.
     * 
     * @param player player preforming event.
     * @param action action being done.
     * @param card   Card being delt.
     * @return a string describing event.
     */
    private String createEvent(Player player, Action action, Card card) {
        return player.getName() + " " + action.getName() + "s, they got " + card + ". They now have: "
                + player.getHand() + ". Total: " + player.getTotalSum();
    }

    /**
     * Filters out all unavailable actions.
     * 
     * @return list of available actions.
     */
    private List<Action> getAvailableActions() {
        return actions.stream().filter(Action::isAvailable).collect(Collectors.toList());
    }

    /**
     * Deals a card to the player.
     * 
     * @param player, player being delt card.
     * @throws IllegalCallerException if action "hit" is unavailable.
     */
    public void hit(Player player) {
        if (!getAvailableActions().contains(HIT)) {
            throw new IllegalCallerException("Action 'hit' is unavailable");
        }

        deal(player, HIT);
        checkBust(player);
    }

    /**
     * Finishes players round, adds action adds action to history, and continues to
     * next player.
     * 
     * @param player, player proforming stand.
     * @throws IllegalCallerException if action "stand" is unavailable.
     */

    public void stand(Player player) {
        if (!getAvailableActions().contains(STAND)) {
            throw new IllegalCallerException("Action 'stand' is unavailable");
        }

        addToHistory(createEvent(player, STAND));
        nextPlayer();
    }

    /**
     * doubles potential return by 100%. In return player must stand after first
     * hit.
     * 
     * @param player, player proforming stand.
     * @throws IllegalCallerException if action "double down" is unavailable.
     */
    public void doubleDown(Player player) {
        if (!getAvailableActions().contains(DOUBLE_DOWN)) {
            throw new IllegalCallerException("Action 'double down' is unavailable");
        }

        deal(player, DOUBLE_DOWN);
        checkBust(player);

    }

    /**
     * It gives the player the option of splitting the cards into two separate
     * hands, then receiving an additional card for each hand from the dealer.
     * 
     * @param player
     * @throws IllegalCallerException if action "double down" is unavailable.
     */
    public void split(Player player) {
        if (!getAvailableActions().contains(SPLIT)) {
            throw new IllegalCallerException("Action 'split' is unavailable");
        }

        addToHistory(createEvent(player, SPLIT));
    }

    /**
     * player surrenders round.
     * 
     * @param player
     */
    public void surrender(Player player) {
        if (!getAvailableActions().contains(SURRENDER)) {
            throw new IllegalCallerException("Action 'surrender' is unavailable");
        }

        addToHistory(createEvent(player, SURRENDER));
    }

    /**
     * player is dealt a card, while another action (etc double down) is preformed.
     * 
     * @param player player who is delt card.
     * @param action Cause of card delt.
     */
    private void deal(Player player, Action action) {
        Card newCard = playableDeck.draw(); // removes the card on the top of the deck
        player.addCardToHand(newCard);

        addToHistory(createEvent(player, action, newCard));
    }

    /**
     * player is dealt a card
     * 
     * @param player player being delt card.
     */
    private void deal(Player player) {
        Card newCard = playableDeck.draw(); // removes the card on the top of the deck.
        player.addCardToHand(newCard);

        addToHistory(createEvent(player, newCard));
    }

    /**
     * Dealer plays until softsum goes above 16 or hard.
     * 
     */
    public void playDealer() {

        while (DEALER.getHardSum() < 17 || (DEALER.getSoftSum() <= 17 && DEALER.getSoftSum() != DEALER.getHardSum())) {
            hit(DEALER);
        }
        stand(DEALER);

    }

    // Starting function.
    public void start() {
        currentPlayer = registeredPlayer;
        deal(currentPlayer);
        nextPlayer();
        deal(currentPlayer);
        nextPlayer();
        deal(currentPlayer);
        nextPlayer();
        deal(currentPlayer);
        nextPlayer();

    }

    /**
     * @return a string containing players cards.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Dealers hand: [");
        for (Card card : DEALER.getHand()) {
            result.append(card.toString());
        }
        result.append("]\n");

        result.append("Players hand: [");
        for (Card card : registeredPlayer.getHand()) {
            result.append(card.toString());
        }
        result.append("]\n");

        return result.toString();
    }
}