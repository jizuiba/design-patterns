package cn.jizuiba.observer.spring.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private ApplicationEventMulticaster applicationEventMulticaster;

    @PostConstruct
    public void init() {
        System.out.println(applicationContext == applicationEventPublisher); // true
//        applicationEventPublisher.publishEvent(new UserEvent("用户事件"));
        // 在此处执行事件发布由于阶段过早，会导致this.getApplicationListeners(event, type)找不到已经注册的监听器。
        // 可以选择在启动类中发布
    }
}
