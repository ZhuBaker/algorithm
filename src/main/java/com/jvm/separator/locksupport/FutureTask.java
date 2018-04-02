package com.jvm.separator.locksupport;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-04-02
 * Time: 10:11
 */
public class FutureTask <V> implements Runnable{
    private boolean isDone;
    private V returnVal;

    CountDownLatch countDownLatch = new CountDownLatch(1);
    Thread currentT ;



    Callable<V> callable;

    public FutureTask(Callable<V> callable,Thread t) {
        if(null == callable){
            throw new NullPointerException("parameter callable can not be null");
        }
        currentT = t;
        this.callable = callable;
        isDone = false;
    }

    @Override
    public void run() {
        try{
            returnVal = callable.call();
            runFinished();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void runFinished(){
        isDone = true;
        LockSupport.unpark(currentT);
    }

    public V getVal(){
        LockSupport.park();
        return  returnVal;
    }
}
