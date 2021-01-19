package com.example.understandingofrxjava.TestApi;

import java.util.zip.DeflaterOutputStream;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author Jack_Ou  created on 2021/1/18.
 */
public class CreateOperator implements Tester {
    @Override
    public Disposable test() {
        Disposable disposable;
        disposable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("novel 1");
                e.onNext("novel 2");
                e.onNext("novel 3");
                e.onComplete();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("result -> " + s);
            }
        });
        return disposable;
    }
}
