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

    public void newUser(String username, String password) {
        // TODO
    }

    public static void readData() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<UserInfo> tempList = Arrays
                    .asList(mapper.readValue(Paths.get("casino/resources/playerDB.json").toFile(), UserInfo[].class));

            for (UserInfo pl : tempList) {
                System.out.println(pl.getPassword());
            }

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
