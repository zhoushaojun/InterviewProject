package com.netease.google.guava;

import java.util.Date;
import java.util.EventListener;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Guava EventBus 执行时没有顺序的
 * @author zhoushaojun
 *
 */
public class EventBusListen {

    @Subscribe
    public void listen(TestEvent event){
        System.out.println(System.currentTimeMillis()+ "get "+ event.getMessage());
    }
    @Subscribe
    public void listenDead(DeadEvent deadEvent){
        System.out.println(System.currentTimeMillis()+" "+ "get dead event");
    }
    public static void main(String[] args) {
        EventBus eventBus = new EventBus("ss");
        EventBusListen listener = new EventBusListen();
        EventAnotherListen listenAnother = new EventAnotherListen();
        AAEventAnotherListen aaEventAnother = new AAEventAnotherListen();
       // eventBus.register(listenAnother);
        eventBus.register(listener);
        //eventBus.register(aaEventAnother);
        for (int i = 0; i < 5; i++) {
            eventBus.post(new TestEvent("zhoushaojun"+i));
        }
    
       // eventBus.post(("zhoushaojun"));
        
        
    }
}

class EventAnotherListen{
    @Subscribe
    public void listen(TestEvent event){
        System.out.println(this.getClass().getName() + "get "+ event.getMessage());
    }
}
class AAEventAnotherListen{
    @Subscribe
    public void listen(TestEvent event){
        System.out.println(this.getClass().getName() + "get "+ event.getMessage());
    }
}
class TestEvent {
    private final String message;
    public TestEvent(String message) {        
        this.message = message;
        //System.out.println("event message:"+message);
    }
    public String getMessage() {
        return message;
    }
}