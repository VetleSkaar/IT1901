package casino.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    Player player = new Player(new UserInfo("Player", "password"));

    @Test
    public void test_new_player() {
        UserInfo user = new UserInfo("name", "password");
        Player player1 = new Player(user);
        assertEquals(player1.getBalance(), 10000);
        assertEquals(player1.getName(), "name");

    }

    @Test
    public void test_update_player() {
        UserInfo user = new UserInfo("name", "password");
        Player player1 = new Player(user);
        UserInfo user2 = new UserInfo("name2", "password2");
        Player player2 = new Player(user2);
        player1.updatePlayer(player2);
        assertEquals(player1.getName(), "name2");
    }

    @Test
    public void test_add_to__balance() {
        UserInfo user = new UserInfo("name", "password");
        Player player = new Player(user);
        player.addToBalance(1000);
        assertEquals(player.getBalance(), 11000);
    }

    @Test
    public void test_add_to_player_balance_neg() {
        UserInfo user = new UserInfo("name", "password");
        Player player = new Player(user);
        assertThrows(IllegalArgumentException.class, () -> {
            player.addToBalance(-1000);
        }, "Cannot add a negativ value to balance");
    }

    @Test
    public void test_remove_from_player_balance() {
        player.removeFromBalance(1000);
        assertEquals(player.getBalance(), 9000);

    }

    @Test
    public void test_remove_too_much_from_player_balance() {
        assertThrows(IllegalArgumentException.class, () -> {
            player.removeFromBalance(11000);
            ;
        }, "Cannot remove higher value than is in balance balance");

    }

    @Test
    public void testAddCardToHand() {
        Value eight = new Value("Eight", 8);
        Suit spade = new Suit("Spade", "♠", "♤");
        Card eightOfSpades = new Card(spade, eight);
        player.addCardToHand(eightOfSpades);
        assertEquals(eightOfSpades, player.getHand().get(0));
    }

    @Test
    public void testGetTotalSum() {
        Value eight = new Value("Eight", 8);
        Suit spade = new Suit("Spade", "♠", "♤");
        Card eightOfSpades = new Card(spade, eight);
        player.addCardToHand(eightOfSpades);
        assertEquals("8", player.getTotalSum());
        Value ace = new Value("Ace", 14, 10, 1);
        Card aceOfSpades = new Card(spade, ace);
        player.addCardToHand(aceOfSpades);
        assertEquals("9/18", player.getTotalSum());
    }

}
