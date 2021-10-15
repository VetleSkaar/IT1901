package core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FileHandlingTest {
    
    @Test
    public void test_Read_Write() {
        FileHandling.userList.clear();
        UserInfo user = new UserInfo("testUser", "testPassword");
        FileHandling.readData();
        assertEquals(user.getUsername(), FileHandling.userList.get(0).getUsername());
        assertEquals(user.getPassword(), FileHandling.userList.get(0).getPassword());
    }

    /*@Test
    public void test_UpdateUserInfo() {
        FileHandling.userList.clear();
        UserInfo user = new UserInfo("testUser", "testPassword");
        assertEquals(user.getBalance(), FileHandling.userList.get(0).getBalance());

        user.setBalance(200);
        FileHandling.readData();

        assertEquals(user.getBalance(), FileHandling.userList.get(0).getBalance());
    }*/
    
}
