package src;

import java.util.Random;

public class WeatherProvider {

    WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather[] = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {

    }
    public WeatherProvider getProvider() {
        return weatherProvider.weatherProvider;
    }
    public static String getCurrentWeather(Coordinates coordinates){
        Random ran = new Random();
        int pos = ran.nextInt(4);

        return weather[pos];
    }
}
