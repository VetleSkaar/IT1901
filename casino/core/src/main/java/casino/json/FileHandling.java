package casino.json;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import casino.core.UserInfo;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandling {

    private static List<UserInfo> userList = new ArrayList<UserInfo>();

    public UserInfo getUserInfo(String uName) {
        for (UserInfo userInfo : userList) {
            if (userInfo.getUsername().equals(uName)) {
                return userInfo;
            }
        }
        return null;
    }

    /**
     * Method for adding new users to UserDatabase.json
     * 
     * @param user UserInfo object
     */
    public void newUser(UserInfo user) {
        userList.add(user);
        writeData();
    }

    /**
     * Method for updating account balance.
     * 
     * Finds correct user in json file and updates balance.
     * 
     * @param info UserInfo object
     */
    public void updateUserInfo(UserInfo info) {
        readData();

        for (UserInfo userInfo : userList) {
            if (userInfo.getUsername().equals(info.getUsername())) {
                userInfo.setBalance(info.getBalance());
                writeData();
            }
        }
    }

    /**
     * Reads user data from UserDatabase.json to a List
     * 
     * @return List of UserInfo Objects
     */
    public static void readData() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            userList = Arrays.asList(
                    mapper.readValue(Paths.get("../resources/" + "UserDatabase.json").toFile(), UserInfo[].class));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes data from userList to UserDatabase.json
     */
    public static void writeData() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(Paths.get("../resources/" + "UserDatabase.json").toFile(), userList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}