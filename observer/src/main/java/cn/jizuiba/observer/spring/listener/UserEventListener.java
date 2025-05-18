package cn.jizuiba.observer.spring.listener;

import cn.jizuiba.observer.spring.event.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    @EventListener
    public void eventListen(UserEvent userEvent) {
        System.out.println(userEvent.getSource());
    }
}
