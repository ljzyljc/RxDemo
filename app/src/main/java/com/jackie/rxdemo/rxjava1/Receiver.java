package com.jackie.rxdemo.rxjava1;

/**
 * Created by Jackie on 2018/8/30.
 */
public abstract class Receiver<T> implements Callee<T>,Calling {

    @Override
    public boolean isUnCalled() {
        return false;
    }

    @Override
    public void unCall() {

    }
}
