package com.jackie.rxdemo.rxjava2;

/**
 * Created by Jackie on 2018/8/30.
 */
public interface Callee<T> {

    void onCall(Release release);

    void onReceive(T t);

    void onComplete();

    void onError(Throwable t);


}
