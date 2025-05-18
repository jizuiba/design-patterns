package cn.jizuiba.observer.demo;

public class Main {
    public static void main(String[] args) {
        TVStation tvStation = new TVStation();
        WeatherStation weatherStation = new WeatherStation(tvStation);

        User zhangsan = new User("zhangsan", (info) -> {
            if ("rain".equals(info)) {
                System.out.println("雨天 - 张三");
            } else {
                System.out.println("晴天 - 张三");
            }
        });

        User lisi = new User("lisi", (info) -> {
            if ("rain".equals(info)) {
                System.out.println("雨天 - 李四");
            } else {
                System.out.println("晴天 - 李四");
            }
        });

        tvStation.subscribe(zhangsan, WeatherUpdateEvent.class);
        tvStation.subscribe(lisi, WeatherUpdateEvent.class);

        try {
            weatherStation.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
