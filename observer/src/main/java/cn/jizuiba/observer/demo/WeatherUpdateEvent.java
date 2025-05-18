package cn.jizuiba.observer.demo;

public class WeatherUpdateEvent extends BaseEvent {

    private final String weather;

    public WeatherUpdateEvent(String weather) {
        this.weather = weather;
    }

    @Override
    public Object source() {
        return weather;
    }
}
