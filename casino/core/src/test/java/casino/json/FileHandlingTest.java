package casino.json;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import casino.core.UserInfo;

public class FileHandlingTest {
    
    @Test
    public void test_Read_Write() {
        UserInfo user = new UserInfo("testUser", "testPassword");
        FileHandling.newUser(user);
        assertEquals(user.getUsername(), FileHandling.readData().get(0).getUsername());
        assertEquals(user.getPassword(), FileHandling.readData().get(0).getPassword());
    }

    @Test
    public void test_UpdateUserInfo() {
        UserInfo user = new UserInfo("testUser", "testPassword");
        assertEquals(user.getBalance(), FileHandling.readData().get(0).getBalance());

        user.setBalance(200);
        FileHandling.updateUserInfo(user);

        assertEquals(user.getBalance(), FileHandling.readData().get(0).getBalance());
    }
    
}
