package com.jvm.separator.threadgroup;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-03-27
 * Time: 19:02
 */

class MyThread2 extends Thread{
    boolean stopped ;

    public MyThread2(ThreadGroup group, String name) {
        super(group, name);
        stopped = false;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting.");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(".");
                Thread.sleep(250);
                synchronized (this) {
                    if (stopped){
                        break;
                    }
                }
            }
        } catch (Exception exc) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " exiting.");
    }

    synchronized void myStop() {
        stopped = true;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        ThreadGroup tg = new ThreadGroup("My Group");
        MyThread2 thrd = new MyThread2(tg, "MyThread #1");
        MyThread2 thrd2 = new MyThread2(tg, "MyThread #2");
        MyThread2 thrd3 = new MyThread2(tg, "MyThread #3");

        thrd.start();
        thrd2.start();
        thrd3.start();

        Thread.sleep(2000);

         System.out.println(tg.activeCount() + " threads in thread group.");


        thrd.myStop();

        Thread.sleep(2000);

        Thread thrds[] = new Thread[tg.activeCount()];
        tg.enumerate(thrds);

        for (Thread t : thrds){
            System.out.println(t.getName());
            System.out.println(t.getState());
        }

        tg.list();




/*

        Thread.sleep(2000);
        System.out.println(tg.activeCount() + " threads in tg.");



        Thread thrds2[] = new Thread[3];
        tg.enumerate(thrds2);
        for (Thread t : thrds2){
            if(t != null){
                System.out.println(t.getName());
                System.out.println(t.getState());
            }

        }
        tg.interrupt();
*/

    }

}

