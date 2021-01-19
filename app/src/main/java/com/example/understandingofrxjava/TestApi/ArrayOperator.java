package com.example.understandingofrxjava.TestApi;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 复杂数据遍历
 *
 * @author Jack_Ou  created on 2021/1/18.
 */
public class ArrayOperator implements Tester{

    @Override
    public Disposable test() {
        // just创建
        Disposable disposable = Observable.just("1", "2", "3","4")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //System.out.println("result ->" + s);
                    }
                });

        // fromArray
        String[] array = new String[]{"1", "2", "3", "4"};
        disposable = Observable.fromArray(array)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //System.out.println("result ->" + s);
                    }
                });

        ArrayList al = new ArrayList() {{
            add("1");
            add("2");
            add("3");
            add("4");
        }};
        disposable = Observable.fromIterable(al)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("result ->" + s);
                    }
                });

        disposable = Observable.range(1,4)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("result ->" + integer);
                    }
                });

        return disposable;
    }
}
