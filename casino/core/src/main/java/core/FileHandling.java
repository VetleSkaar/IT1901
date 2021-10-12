package core;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class FileHandling {

    public Player player;

    public void readData() {
        
    }

    public void writeData() {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            mapper.writeValue(new File(playerData.json), player);

            String jsonString = mapper.writeValueAsString(player);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        om.writeValue(new File("playerData.json"), player);
    }
}
