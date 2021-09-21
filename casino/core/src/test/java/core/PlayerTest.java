package test;

import casino.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayer {


    @BeforeEach
    public void setUp(){
    }

    @Test
    public void test_new_player() {
        Player player_only_name = new Player("test");

        assertEquals("test", player_only_name.getName());
        assertEquals(0, player_only_name.getBalance(), 0);
    }

    @Test
    public void test_new_player_blank_name() {
        Player[] player = new Player[2];

        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    player[0] = new Player("");
                    player[1] = new Player("",100);
                });

        String expectedMessage = "Player name cannot be blank.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertNull(player[0]);
        assertNull(player[1]);

    }

    @Test
    public void test_new_player_0_bal() {
        Player player_only_name = new Player("test");
        Player player_bal_0 = new Player("test",0);

        assertEquals(player_only_name.getBalance(), player_bal_0.getBalance(),0);
    }

   @Test
    public void test_new_player_negative_balance() {
        Player[] player = new Player[1];

        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    player[0] = new Player("test",-100);
                });

        String expectedMessage = "Player balance must be positive.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertNull(player[0]);
    }


    @Test
    public void test_update_player() {
        Player old_player = new Player("old_player");
        Player new_player = new Player("new_player");

        old_player.updatePlayer(new_player);

        assertEquals(new_player.getName(), old_player.getName());
        assertNotEquals(old_player, new_player);
    }

    @Test
    public void test_add_to__balance() {
       //TODO
    }

    @Test
    public void test_add_to_player_balance_neg() {
        //TODO
    }


    @Test
    public void test_remove_from_player_balance() {
      //TODO
    }

    @Test
    public void test_remove_too_much_from_player_balance() {
        //TODO

    }
}
