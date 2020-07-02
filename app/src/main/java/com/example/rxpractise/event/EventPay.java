package com.example.rxpractise.event;

public class EventPay {

    public static final int SUCCESS = 1;
    public static final int NOPAY = 0;

    public int status;

    public EventPay(int status){
        this.status = status;
    }
}
