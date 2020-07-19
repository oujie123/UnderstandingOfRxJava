package com.example.understandingofrxjava.observer_model;

public interface Observable {
    //增加监听
    void addObserver(Observer observer);

    //移除监听者
    void removeObserver(Observer observer);

    //通知监听者
    void notifyObservers();

    //推送消息
    void pushMessage(String message);
}
