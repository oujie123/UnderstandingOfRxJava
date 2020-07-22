package com.example.understandingofrxjava.rx;

import android.view.View;

import io.reactivex.Observable;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/7/22 23:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/22 23:48
 * @UpdateRemark: 自定义操作符
 */
public class RxView {

    public static Observable<Object> click(View view) {
        return new ObservableViewClick(view,null);
    }
}
