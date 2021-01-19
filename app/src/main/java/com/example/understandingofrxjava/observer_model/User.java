package com.example.understandingofrxjava.observer_model;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/7/19 18:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/19 18:58
 * @UpdateRemark: 更新说明
 */
public class User implements Observer {

    private static final String TAG = User.class.getSimpleName();
    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;

        readMessage();
    }

    private void readMessage() {
        System.out.println(name + " read Message:  " + message);
    }
}
