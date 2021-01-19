package com.example.understandingofrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Main4Activity extends AppCompatActivity {

    private static final String TAG = Main4Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        test();
    }

    /**
     * 使用rxjava打印for循环
     */
    @SuppressLint("CheckResult")
    private void test() {
        String[] strings = {"aaa","bbb","ccc","ddd"};

        for (String string : strings) {
            Log.d(TAG,string);
        }

        //性能降低了
        Observable.fromArray(strings)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(TAG,s);
                    }
                });
    }
}
