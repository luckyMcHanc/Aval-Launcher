package src.aircrafts;
import src.Coordinates;

public class AirCraft{

   protected long id;
   protected String name;
   protected Coordinates coordinates;
   static public long idCounter = 1;

   protected AirCraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
   }
    private long nextId(){
        return AirCraft.idCounter++;
   }
}