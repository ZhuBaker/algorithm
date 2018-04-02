package com.jvm.separator.locksupport;


import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-04-02
 * Time: 10:49
 */
public class FutureTaskTest {

    public static void main(String[] args) {

        Callable<Integer> callable = new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 12;
            }
        };

        FutureTask<Integer> future = new FutureTask<>(callable, Thread.currentThread());
        Thread t = new Thread(future);
        t.start();
        System.out.println("=============================");
        Integer val = future.getVal();

        System.out.println(val);
    }
}
