package com.jackie.rxdemo.rxjava2;

/**
 * Created by Jackie on 2018/8/30.
 */
public interface CallerOnCall<T> {

    void call(CallerEmitter<T> callerEmitter);

}
