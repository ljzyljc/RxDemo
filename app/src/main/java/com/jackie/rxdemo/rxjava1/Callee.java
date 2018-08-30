package com.jackie.rxdemo.rxjava1;

/**
 * Created by Jackie on 2018/8/30.
 */
public interface Callee<T> {

    void onNext(T t);

    void onError(Throwable t);

    void onComplete();


}
