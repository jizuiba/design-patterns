package cn.jizuiba.observer;

import cn.jizuiba.observer.spring.event.UserEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ObserverApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ObserverApplication.class, args);
        applicationContext.publishEvent(new UserEvent("用户事件"));
    }
}
