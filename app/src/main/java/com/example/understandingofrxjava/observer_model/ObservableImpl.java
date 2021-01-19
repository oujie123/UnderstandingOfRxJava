package com.example.understandingofrxjava.observer_model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/7/19 18:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/19 18:51
 * @UpdateRemark: 更新说明
 */
public class ObservableImpl implements Observable {

    private static final String TAG = ObservableImpl.class.getSimpleName();
    private List<Observer> observers = new ArrayList<>();
    private String message;

    @Override
    public void addObserver(Observer observer) {
        if (observer != null){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer != null){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public void pushMessage(String message) {
        this.message = message;
        System.out.println("pushMessage: " + message);
        //有消息来了就通知
        notifyObservers();
    }
}
