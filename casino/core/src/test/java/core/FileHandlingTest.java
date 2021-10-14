package core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FileHandlingTest {
    
    @Test
    public void test_Read_Write() {
        FileHandling.playerDB.clear();
        UserInfo user = new UserInfo("testUser", "testPassword");
        FileHandling.readData();
        assertEquals(user.getUsername(), FileHandling.playerDB.get(0).getUsername());
        assertEquals(user.getPassword(), FileHandling.playerDB.get(0).getPassword());
    }

    @Test
    public void test_UpdateUserInfo() {
        FileHandling.playerDB.clear();
        UserInfo user = new UserInfo("testUser", "testPassword");
        assertEquals(user.getBalance(), FileHandling.playerDB.get(0).getBalance());

        user.setBalance(200);
        FileHandling.readData();

        assertEquals(user.getBalance(), FileHandling.playerDB.get(0).getBalance());
    }
    
}
