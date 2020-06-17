package com.example.rxpractise;

import org.greenrobot.eventbus.EventBus;

public class EventManager {

    public static EventManager eventManager;
    private static EventBus eventBus;

    private EventManager(){}

    public static EventManager getInstance(){
        if(eventManager== null){
            eventManager = new EventManager();
            eventBus = new EventBus();
        }
        return eventManager;
    }

    public EventBus getEvent(){
        return eventBus;
    }

}
