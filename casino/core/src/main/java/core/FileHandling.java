import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandling{

    private final String FILE_PATH;
    private final User userId; //Temporary name for data type. Type to be used for users in the casino

    public FileHandling(Player userId){
        this.userId = userId;
        this.FILE_PATH = userId.getName() + "_user_data.txt";
    }

    /**
     * Temporary code to be edited later.
     *
     * Assumes a user with a name or id, and a balance to be read/written to a .txt file.
     * May use a different system to store information in the future.
     *
     * Currently working with a single user.
     *
     * TODO:
     *      - Add support for several userID`s
     *      - Integrate with user handling system
     *
     * @return
     * @throws IOException
     */

    @Override
    public Player readUserState() throws IOException {
        List<String> userData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                userData.add(line);
            }
        } catch (IOException e){
            writePlayerState();
            return new User();
        }

        String name = userData.get(0);
        if(name.isBlank()) {
            throw new IllegalArgumentException("Invalid file. No user ID found.");
        }

        if (!userData.get(1).matches("[0-9]+")) {
            throw new IllegalArgumentException("Invalid file. User balance is not an integer.");
        }else {
            int balance = Integer.parseInt(userData.get(1));

            if (userId.isNegative(balance)) {
                throw new IllegalArgumentException("Invalid file. User balance must be positive.");
            }else {
                return new User();
            }
        }
    }

    @Override
    public boolean writePlayerState() {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            String playerData = userId.getName() +
                    "\n" +
                    userId.getBalance();

            fw.write(playerData);
            fw.close();

            return true;

        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
