package core;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileHandling {

    public static Player player1 = new Player("testPlayer1", 10000);
    public static Player player2 = new Player("testPlayer2", 600);
    public static Player player3 = new Player("testPlayer3", 4000);
    public static Player player4 = new Player("testPlayer4", 200);

    public static Map<String, Player> playerDB = new HashMap<String, Player>();

    public void readData() {
        //ObjectMapper mapper = new ObjectMapper();
        
        try {
            //Map<?, ?> tempMap = mapper.readValue(Paths.get("casino/resources/playerDB.json").toFile(), Map.class);
            
            playerDB.clear();

            /*for(Map.Entry<?, ?> entry : tempMap.entrySet()) {
                playerDB.put(entry.getKey(), entry.getValue()); //Bug?
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void writeData() { //Functional
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        playerDB.put(player1.getName(), player1);
        playerDB.put(player2.getName(), player2);
        playerDB.put(player3.getName(), player3);
        playerDB.put(player4.getName(), player4);

        try {
            writer.writeValue(Paths.get("casino/resources/playerDB.json").toFile(), playerDB);
            System.out.println("Player data base written");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
