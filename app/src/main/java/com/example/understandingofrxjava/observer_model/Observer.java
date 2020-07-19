package com.example.understandingofrxjava.observer_model;

public interface Observer {

    //跟新消息回调
    void update(String message);
}
