package casino.json;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import casino.core.UserInfo;

public class FileHandlingTest {

    private FileHandling fileHandler = new FileHandling();
    
    @Test
    public void test_Read_Write() {
        UserInfo user = new UserInfo("testUser", "testPassword");
        fileHandler.newUser(user);
        assertEquals(user.getPassword(), fileHandler.getUserInfo("testUser").getPassword());
    }

    @Test
    public void test_UpdateUserInfo() {
        UserInfo user = new UserInfo("testUser", "testPassword");
        assertEquals(user.getBalance(), fileHandler.getUserInfo("testUser").getBalance());

        user.setBalance(200);
        fileHandler.updateUserInfo(user);

        assertEquals(user.getBalance(), fileHandler.getUserInfo("testUser").getBalance());
    }
    
}
