package com.jackie.rxdemo.rxjava1;

/**
 * Created by Jackie on 2018/8/30.
 */
public class Caller<T> {

    final OnCall<T> mOnCall;

    public Caller(OnCall<T> onCall){
        this.mOnCall = onCall;
    }

    public static <T> Caller<T> create(OnCall<T> onCall){
        return new Caller(onCall);
    }

    public Calling call(Receiver receiver){
        this.mOnCall.call(receiver);
        return receiver;
    }



    public interface OnCall<T> extends Action1<Receiver<T>>{

    }

}
