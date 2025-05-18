package cn.jizuiba.observer.demo;

public interface Event {
    long timestamp();

    Object source();
}
