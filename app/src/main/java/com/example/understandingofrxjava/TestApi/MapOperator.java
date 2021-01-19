package com.example.understandingofrxjava.TestApi;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.zip.DeflaterOutputStream;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @author Jack_Ou  created on 2021/1/18.
 */
public class MapOperator implements Tester {

    @Override
    public Disposable test() {
        // TODO map用于单一的变换
        Disposable disposable = Observable.just("1","2")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return "煎蛋" + s;
                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("result -> " + s);
                    }
                });
        return disposable;
    }

    public Disposable test2() {

        // TODO flatmap返回ObservableSource，可以执行更多的变换
        Disposable disposable = Observable.just("1","2")
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(String s) throws Exception {
                        ArrayList<String> al = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            al.add(i + " Novel " + s);
                        }
                        return Observable.fromIterable(al).delay(3, TimeUnit.SECONDS);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("result -> " + s);
                    }
                });
        return disposable;
    }
}
