package com.jackie.rxdemo.rxjava2;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Jackie on 2018/8/30.
 */
public enum  ReleaseHelper implements Release {

    RELEASED;

    public static boolean isReleased(Release release){
        return release == RELEASED;
    }

    public static boolean release(AtomicReference<Release> releaseAtomicReference){
        Release current = releaseAtomicReference.get();
        Release d = RELEASED;
        if (current != d){
            current = releaseAtomicReference.getAndSet(d);
            if (current != d){
                if (current != null){
                    current.release();
                }
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean isReleased() {
        return false;
    }

    @Override
    public void release() {

    }
}
