package src.aircrafts;
import src.Coordinates;
import src.WeatherTower;
import src.Simulation;

public class Baloon extends AirCraft implements Flyable{

    private WeatherTower weathertower;

    protected Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public int updateWeather(Coordinates coordinates, String weather){

        Messages messages = new Messages();
        new Simulation("Baloon#"+this.name+"(" + this.id+") "+ messages.Messages(weather));
       switch (weather){
           case "SUN":
               this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
               break;
           case "RAIN":
               this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
               break;
           case "FOG":
               this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
               break;
           case "SNOW":
               this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
               break;
       }
        if (this.coordinates.getHeight() > 100)
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
       return this.coordinates.getHeight();
    }
    public void updateConditions(){
        String weather = weathertower.getWeather(coordinates);
        if (updateWeather(coordinates, weather) <= 0) {
            new Simulation("Baloon#"+this.name+"(" + this.id+") is Landing");
            new Simulation("Tower says: Baloon#"+this.name+"(" + this.id+") has been unregistered");
            this.weathertower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weathertower = weatherTower;
        this.weathertower.register(this);
        new Simulation("Tower says: Baloon#"+this.name+"(" + this.id+") has been registered");
    }
}