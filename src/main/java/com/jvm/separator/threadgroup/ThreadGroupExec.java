package com.jvm.separator.threadgroup;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-03-27
 * Time: 20:41
 */
public class ThreadGroupExec {

    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("group1"){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        // 这是匿名类写法
        Thread thread1 =
                // 这个线程是threadGroup1的一员
                new Thread(threadGroup1, new Runnable() {
                    @Override
                    public void run() {
                        // 抛出unchecked异常
                        throw new RuntimeException("测试异常");
                    }
                });

        thread1.start();
    }
}
