package com.example.understandingofrxjava.rx;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import java.io.PipedReader;
import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/7/22 23:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/22 23:51
 * @UpdateRemark: 更新说明
 */
public class ObservableViewClick extends Observable<Object> {

    private View view;
    private static final Object EVENT = new Object();
    private Object EVENT2;

    public ObservableViewClick(View view, Object EVENT2) {
        this.view = view;
        this.EVENT2 = EVENT2;
    }

    @Override
    protected void subscribeActual(Observer<? super Object> observer) {
        MyListener myListener = new MyListener(view, observer);
        observer.onSubscribe(myListener);
        view.setOnClickListener(myListener);
    }

    public static class MyListener implements View.OnClickListener, Disposable {

        private View view;
        private Observer<Object> objectObserver;
        private final AtomicBoolean isDisposable = new AtomicBoolean();

        public MyListener(View view, Observer<? super Object> observer) {
            this.view = view;
            this.objectObserver = observer;
        }

        @Override
        public void onClick(View view) {
            if (!isDisposed()) {
                objectObserver.onNext(EVENT);
            }
        }

        @Override
        public void dispose() {
            if (isDisposable.compareAndSet(false, true)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    view.setOnClickListener(null);
                } else {
                    //方法1
//                    new Handler(Looper.getMainLooper()){
//                        @Override
//                        public void handleMessage(Message msg) {
//                            super.handleMessage(msg);
//                            view.setOnClickListener(null);
//                        }
//                    };
                    //方法2
                    AndroidSchedulers.mainThread().scheduleDirect(new Runnable() {
                        @Override
                        public void run() {
                            view.setOnClickListener(null);
                        }
                    });
                }
            }
        }

        @Override
        public boolean isDisposed() {
            return isDisposable.get();
        }
    }
}
