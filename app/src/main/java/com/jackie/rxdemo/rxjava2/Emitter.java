package com.jackie.rxdemo.rxjava2;

/**
 * Created by Jackie on 2018/8/30.
 */
public interface Emitter<T> {

    void onReceive(T t);

    void onCompleted();

    void onError(Throwable t);


}
