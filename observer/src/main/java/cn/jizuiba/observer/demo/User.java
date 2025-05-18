package cn.jizuiba.observer.demo;

import java.util.function.Consumer;

public class User implements EventListener{
    private String name;

    public User(String name, Consumer<String> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    private final Consumer<String> consumer;

    public void receiveInfo(String info) {
        consumer.accept(info);
    }

    @Override
    public void onEvent(Event event) {
        receiveInfo(event.source().toString());
    }
}
