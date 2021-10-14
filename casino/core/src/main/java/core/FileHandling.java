package core;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandling {

    public static List<UserInfo> playerDB = new ArrayList<UserInfo>();

    public static void newUser(UserInfo info) {
        playerDB.add(info);
        writeData();
    }

    public static void updateUserInfo(UserInfo info) {
        readData();

        for (UserInfo userInfo : playerDB) {
            if(userInfo.getUsername() == info.getUsername()) {
                userInfo.setBalance(info.getBalance());
                writeData();
            }
        }
    }

    public static void readData() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            playerDB = Arrays
                    .asList(mapper.readValue(Paths.get("casino/resources/playerDB.json").toFile(), UserInfo[].class));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void writeData() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(Paths.get("casino/resources/playerDB.json").toFile(), playerDB);
            System.out.println("Player data base written");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
