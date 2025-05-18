package cn.jizuiba.observer.demo;

import java.util.Random;

public class WeatherStation {

    private final static String RAIN = "rain";
    private final static String SUNNY = "sunny";

    private final TVStation tvStation;

    public WeatherStation(TVStation tvStation) {
        this.tvStation = tvStation;
    }

    public String getWeather() {
        if (new Random().nextBoolean()) {
            return RAIN;
        }
        return SUNNY;
    }

    public void start() throws InterruptedException {
        while (true) {
            String weather = getWeather();
            tvStation.onInfoUpdate(new WeatherUpdateEvent(weather));
            Thread.sleep(3000);
        }
    }
}
