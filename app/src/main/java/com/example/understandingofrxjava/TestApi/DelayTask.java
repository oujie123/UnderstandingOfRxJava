package com.example.understandingofrxjava.TestApi;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObservableFromCallable;

/**
 * defer的使用
 * defer 和 just区别
 *
 * @author Jack_Ou  created on 2021/1/18.
 */
public class DelayTask implements Tester {
    @Override
    public Disposable test() {
        Disposable disposable = null;

        // 使用just创建对象
        Student student1 = new Student("DY");
        Observable<Student> observable = Observable.just(student1);
        student1.setName("Jack Ou");
        disposable = observable.subscribe(new Consumer<Student>() {
            @Override
            public void accept(Student student) throws Exception {
                System.out.println("just result -> " + student.getName());
            }
        });

        // 使用defer创建对象
        Student student2 = new Student("DY");
        Observable<Student> observable2 = Observable.defer(new Callable<ObservableSource<? extends Student>>() {
            @Override
            public ObservableSource<? extends Student> call() throws Exception {
                return Observable.just(student2);
            }
        });
        student2.setName("Jack Ou");
        disposable = observable2.subscribe(new Consumer<Student>() {
            @Override
            public void accept(Student student) throws Exception {
                System.out.println("defer result -> " + student.getName());
            }
        });
        return disposable;
    }

    private static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
