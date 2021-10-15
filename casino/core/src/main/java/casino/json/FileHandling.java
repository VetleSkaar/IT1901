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

    public static void newUser(UserInfo user) {
        userList.add(user);
        writeData();
    }

    public static void updateUserInfo(UserInfo info) {
        readData();

        for (UserInfo userInfo : userList) {
            if(userInfo.getUsername().equals(info.getUsername())) {
                userInfo.setBalance(info.getBalance());
                writeData();
            }
        }
    }

    public static void readData() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            userList = Arrays
                    .asList(mapper.readValue(Paths.get("casino/resources/UserDatabase.json").toFile(), UserInfo[].class));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void writeData() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(Paths.get("casino/resources/UserDatabase.json").toFile(), userList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

