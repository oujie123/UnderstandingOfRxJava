package com.example.understandingofrxjava.TestApi;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @author Jack_Ou  created on 2021/1/18.
 */
public class IntervalOperator implements Tester{

    @Override
    public Disposable test() {
        Disposable disposable;
        long count = 60;
//        disposable = Observable.interval(0,1, TimeUnit.SECONDS)
//                .take(60)
//                .map(new Function<Long, Long>() {
//                    @Override
//                    public Long apply(Long aLong) throws Exception {
//                        return count - aLong;
//                    }
//                }).subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        System.out.println("result ->" + aLong);
//                    }
//                });

        disposable = Observable.intervalRange(0,10,0,1,TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("result ->" + aLong);
                    }
                });
        return disposable;
    }
}
