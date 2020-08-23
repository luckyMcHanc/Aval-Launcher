package src.aircrafts;
import src.Coordinates;
import src.WeatherTower;
import java.util.ArrayList;

public class AirCraftFactory {
    
    int num_simulation;
    private static WeatherTower weatherTower;
    int i = 0;
    public void scenario(ArrayList<String> data) {
        weatherTower = new WeatherTower();
        for (i = 0; i < data.size(); i++) {
            String arr[] = data.get(i).split(" ");
            try {
                if (i == 0) {
                    if (arr.length != 1)
                        throw new Exception();
                    num_simulation = Integer.parseInt(data.get(i));
                } else {
                    if (arr.length != 5)
                        throw new Exception();
                    newAirCraft(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]),
                            Integer.parseInt(arr[4])).registerTower(weatherTower);
                }
            } catch (Exception e) {
                System.err.println("Error");
                System.exit(0);

            }
        }
        while (num_simulation >0){
            weatherTower.changeWeather();
            num_simulation--;
        }

    }

    public Flyable newAirCraft(String type, String name, int longitude, int latitude, int height) {
       try{
        if (longitude < 0 || latitude < 0 || height < 0){
           throw new Exception();
       }
       if (height > 100){
           height = 100;
       }
           Coordinates coordinates = new Coordinates(longitude, latitude, height);
       if (type.equalsIgnoreCase("Helicopter")){
           return new Helicopter(name, coordinates);
       }
       if (type.equalsIgnoreCase("JetPlane")){
           return new JetPlane(name, coordinates);
       }
       if (type.equalsIgnoreCase("Baloon")){
           return new Baloon(name, coordinates);
       }
    }catch(Exception e){
        System.err.println("Error" );
    }
       return null;
    }
}