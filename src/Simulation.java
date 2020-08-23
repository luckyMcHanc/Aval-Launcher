package src;

import java.io.FileWriter;
import java.io.IOException;

public class Simulation {
    public Simulation(String message){

        try {
            FileWriter myWriter = new FileWriter("../simulation.txt", true);
            myWriter.write(message+"\n");
            myWriter.close();
        } catch (IOException e) {
            System.err.println("Error");
            System.exit(0);

        }

    }
}
