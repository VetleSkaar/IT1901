package core;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandling {

    public static Player player1 = new Player("testPlayer1", 10000);
    public static Player player2 = new Player("testPlayer2", 600);
    public static Player player3 = new Player("testPlayer3", 4000);
    public static Player player4 = new Player("testPlayer4", 200);

    public static List<Player> playerDB = new ArrayList<Player>();

    public void newUser(String username, String password) {
        //TODO
    }

    public static void readData() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Player> tempList = Arrays.asList(mapper.readValue(Paths.get("casino/resources/playerDB.json").toFile(), Player[].class));

            for (Player pl : tempList) {
                System.out.println(pl.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void writeData() { //Functional
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
