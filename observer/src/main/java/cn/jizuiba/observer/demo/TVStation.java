package cn.jizuiba.observer.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TVStation {

//    private Set<EventListener> listeners = new HashSet<>();
    private Map<Class<? extends Event>, Set<EventListener>> listenerMap = new HashMap<>();

    /*public void subscribe(EventListener listener) {
        listeners.add(listener);
    }*/

    // 扩展
    public void subscribe(EventListener listener, Class<? extends Event> eventClass) {
        // 维护一个Map
        listenerMap.computeIfAbsent(eventClass, k -> new HashSet<>()).add(listener);
    }

    public void onInfoUpdate(Event event) {
        Class<? extends Event> clazz = event.getClass();
        Set<EventListener> eventListeners = listenerMap.get(clazz);
        if (eventListeners != null) {
            eventListeners.forEach(listener -> listener.onEvent(event));
        }
    }
}
