package src.aircrafts;
import src.Coordinates;
import src.Simulation;
import src.WeatherTower;

public class Helicopter extends AirCraft implements Flyable{

    private WeatherTower weathertower;

    protected Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public int updateWeather(Coordinates coordinates, String weather){

        Messages messages = new Messages();
        new Simulation("Helicopter#"+this.name+"(" + this.id+") "+ messages.Messages(weather));
        switch (weather){
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10 , coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                break;
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
        return this.coordinates.getHeight();
    }
    public void updateConditions(){
        String weather = weathertower.getWeather(coordinates);
        if (updateWeather(coordinates, weather) <= 0) {
            new Simulation("Helicopter#"+this.name+"(" + this.id+") is Landing");
            new Simulation("Tower says: Helicopter#"+this.name+"(" + this.id+") has been unregistered");
            this.weathertower.unregister(this);
        }
    }
    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weathertower = weatherTower;
        this.weathertower.register(this);
        new Simulation("Tower says: Helicopter#"+this.name+"(" + this.id+") has been registered");
    }
}