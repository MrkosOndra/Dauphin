import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WorldMap {




    public boolean loadMap(){
        try (BufferedReader br = new BufferedReader(new FileReader("World.txt"))){
                String line;
                while ((line = br.readLine()) !=null){
                    String[] lines = line.split("-");
                }
            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
    }

