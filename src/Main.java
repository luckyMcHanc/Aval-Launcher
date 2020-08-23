package src;
import src.aircrafts.AirCraftFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> data = new ArrayList<>();
    public static void main(String[] args) {

        try {
            if (args.length == 1) {
                readFile(args[0]);
                AirCraftFactory airCraft = new AirCraftFactory();
                airCraft.scenario(data);
            } else {
                throw new Exception("Invalid number of documents");
            }
        } catch(Exception e){
            System.err.println("Error");
            System.exit(0);
        }
    }
    public static void readFile(String path) {
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            
            while (reader.hasNextLine()) {
                data.add(reader.nextLine());
            }
            reader.close();
        } catch(Exception e){
            System.err.println("Error");
            System.exit(0);
        }
    }
}