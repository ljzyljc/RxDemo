package com.jackie.rxdemo.rxjava2;

/**
 * Created by Jackie on 2018/8/30.
 */
public abstract class Caller<T> {



    public static <T> Caller<T> create(CallerOnCall<T> callerOnCall){
        return new CallerCreate<>(callerOnCall);
    }

    public void call(Callee<T> callee){
        callActual(callee);
    }

    protected abstract void callActual(Callee<T> callee);

}
