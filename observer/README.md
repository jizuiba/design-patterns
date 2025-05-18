# Demo

观察者模式：事件的生产者 -> 监听器 

发布订阅模式：事件的生产者 -> 总线 -> 监听器

# Spring中的事件

在 `@PostConstruct` 中发布事件，会出现发布由于阶段过早，会导致 `this.getApplicationListeners(event, type)` 找不到已经注册的监听器。

可以选择：
- 可以选择在启动类中发布
- 或者使用使用 `ApplicationRunner` 或 `CommandLineRunner`
```java
@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("应用启动完成，开始发布事件...");
        eventPublisher.publishEvent(new UserEvent("用户事件"));
    }
}
```
- 监听 `ApplicationReadyEvent.class` 事件
```java
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
    }
```

使用 `applicationEventMulticaster` 添加一个不是监听器的bean会出现什么？
```java
@Autowired
    private ApplicationEventMulticaster applicationEventMulticaster;

// 报错
// Bean named 'testListener' is expected to be of type 'org.springframework.context.ApplicationListener' but was actually of type 'cn.jizuiba.observer.spring.listener.TestListener'
```

实现时间的异步执行
- 在事件上添加 `@Async` 注解
- 自定义 `ApplicationEventMulticaster`
```java
@Component
public class EventConfig {

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(Executors.newCachedThreadPool());
        return multicaster;
    }
}
```

备注：
```java
    /*
     * @Async加了就是异步监听,没加就是同步（启动类要开启@EnableAsync注解）
     * 可以使用@Order定义监听者顺序，默认是按代码书写顺序
     * 如果返回类型不为void,则会被当成一个新的事件,再次发布
     * @EventListener注解在EventListenerMethodProcessor类被扫描
     * 可以使用SpEL表达式来设置监听器生效的条件
     * 监听器可以看做普通方法,如果监听器抛出异常,在publishEvent里处理即可
     */
```