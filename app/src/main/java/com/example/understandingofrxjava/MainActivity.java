package com.example.understandingofrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.understandingofrxjava.observer_model.Observable;
import com.example.understandingofrxjava.observer_model.ObservableImpl;
import com.example.understandingofrxjava.observer_model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
    }

    private static void test() {
        //创建内容发布部门
        Observable server = new ObservableImpl();

        //创建用户
        User user1 = new User("Jack Ou");
        User user2 = new User("yi bao bao");
        User user3 = new User("song ling jie");
        User user4 = new User("wu zhong wei");

        // 用户订阅消息
        server.addObserver(user1);
        server.addObserver(user2);
        server.addObserver(user3);
        server.addObserver(user4);

        // 更新消息
        server.pushMessage("今天广州下暴雨！大家注意安全");

        // 取消关注
        server.removeObserver(user3);

        // 一个用户取消关注之后再推送一条消息
        server.pushMessage("明天大家别出门！");
    }
}
