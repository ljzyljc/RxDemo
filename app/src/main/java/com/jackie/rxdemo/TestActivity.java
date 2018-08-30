package com.jackie.rxdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jackie.rxdemo.rxjava2.Callee;
import com.jackie.rxdemo.rxjava2.Caller;
import com.jackie.rxdemo.rxjava2.CallerEmitter;
import com.jackie.rxdemo.rxjava2.CallerOnCall;
import com.jackie.rxdemo.rxjava2.Release;
//import android.util.Log;
//
//import com.jackie.rxdemo.rxjava1.Caller;
//import com.jackie.rxdemo.rxjava1.Calling;
//import com.jackie.rxdemo.rxjava1.Receiver;
//
//import org.reactivestreams.Subscriber;
//import org.reactivestreams.Subscription;
//
//import io.reactivex.Observable;
//import io.reactivex.Observer;

/**
 * Created by Jackie on 2018/8/30.
 */
public class TestActivity extends AppCompatActivity {
    private static final String TAG = "TestActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        test1();
        test2();
    }
    public void test2(){
        Caller.create(new CallerOnCall<String>() {
            @Override
            public void call(CallerEmitter<String> callerEmitter) {
                callerEmitter.onReceive("sb day day coming");
                callerEmitter.onCompleted();
            }
        }).call(new Callee<String>() {
            @Override
            public void onCall(Release release) {
                Log.i(TAG, "onCall: -------");
                release.release();
            }

            @Override
            public void onReceive(String s) {
                Log.i(TAG, "onReceive: ==="+s);
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: -----");
            }

            @Override
            public void onError(Throwable t) {

            }
        });

    }










    public void test1(){
//        Calling calling = Caller.create(new Caller.OnCall<String>() {
//            @Override
//            public void call(Receiver<String> stringReceiver) {
//                Log.i(TAG, "call: ------");
//                stringReceiver.onNext("123");
//
//            }
//        }).call(new Receiver<String>() {
//            @Override
//            public void onNext(String o) {
//                Log.i(TAG, "onNext: -----"+o);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

    }

    public void test(){
//                 Subscription tSubscription = Observable.create(new Observable.OnSubscribe<String>() {
//                    @Override
//                    public void call(Subscriber<? super String> subscriber) {
//                        if (!subscriber.isUnsubscribed()) {
//                            subscriber.onNext("test");
//                            subscriber.onCompleted();
//                        }
//                    }
//                }).subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext:" + s);
//                    }
//                });
//        Calling tCalling = Caller.create(new Caller.OnCall<String>() {
//            @Override
//            public void call(Receiver<String> stringReceiver) {
//                if (!stringReceiver.isUnCalled()) {
//                    stringReceiver.onReceive("test");
//                    stringReceiver.onCompleted();
//                }
//            }
//        }).call(new Receiver<String>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onReceive(String s) {
//                System.out.println("onReceive:" + s);
//            }
//        });
    }
}
