package com.jackie.rxdemo.rxjava2;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Jackie on 2018/8/30.
 */
public class CallerCreate<T> extends Caller<T>{

    private CallerOnCall<T> mCallerOnCall;

    public CallerCreate(CallerOnCall<T> callerOnCall){
        mCallerOnCall = callerOnCall;
    }


    @Override
    protected void callActual(Callee<T> callee) {
        CreateEmitter<T> createEmitter = new CreateEmitter<>(callee);
        callee.onCall(createEmitter);
        mCallerOnCall.call(createEmitter);
    }

    public static final class CreateEmitter<T> extends AtomicReference<Release> implements CallerEmitter<T>,Release{

        private Callee<T> mCallee;

        public CreateEmitter(Callee<T> callee){
            mCallee = callee;
        }

        @Override
        public void onReceive(T t) {
            if (!isReleased()){
                mCallee.onReceive(t);
            }
        }

        @Override
        public void onCompleted() {
            if (!isReleased()){
                mCallee.onComplete();
            }
        }

        @Override
        public void onError(Throwable t) {
            if (!isReleased()){
                mCallee.onError(t);
            }
        }

        @Override
        public boolean isReleased() {
            return ReleaseHelper.isReleased(get());
        }

        @Override
        public void release() {
            ReleaseHelper.release(this);
        }
    }

}
