package com.jvm.separator.locksupport;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description : LockSupport类提供了park()和unpark()两个方法来实现线程的阻塞和唤醒,下面我们就来详解Java多线程编程中LockSupport类的线程阻塞用法:
 * LockSupport中的park() 和 unpark() 的作用分别是阻塞线程和解除阻塞线程，而且park()和unpark()不会遇到“Thread.suspend 和 Thread.resume所可能引发的死锁”问题。
 * 因为park() 和 unpark()有许可的存在；调用 park() 的线程和另一个试图将其 unpark() 的线程之间的竞争将保持活性。
 * User: zhubo
 * Date: 2018-04-01
 * Time: 16:37
 */
public class LockSupportTest {

    public static void main(String[] args) throws Exception{
        test2();
    }

    /**
     * LockSupport 很类似于二元信号量(只有1个许可证可供使用)，如果这个许可还没有被占用，当前线程获取许可并继 续 执行；如果许可已经被占用，当前线 程阻塞，等待获取许可。
     * 运行该代码，可以发现主线程一直处于阻塞状态。因为 许可默认是被占用的 ，调用park()时获取不到许可，所以进入阻塞状态。
     */
    public static void test1(){
        LockSupport.park();
        System.out.println("blok");
    }

    /**
     * 如下代码：先释放许可，再获取许可，主线程能够正常终止。LockSupport许可的获取和释放，一般来说是对应的，如果多次unpark，
     * 只有一次park也不会出现什么问题，结果是许可处于可用状态。
     */
    public static void test2() throws Exception{
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("aaaaaaaa");
                LockSupport.park();
                System.out.println("bbbbbbbb");
            }
        };
        t.start();
        Thread.sleep(1000);
        LockSupport.unpark(t);
        Thread.sleep(1000);
        System.out.println("ssssssss");
    }

    /**
     * LockSupport是可不重入 的，如果一个线程连续2次调用 LockSupport .park()，那么该线程一定会一直阻塞下去。
     * 这段代码打印出a和b，不会打印c，因为第二次调用park的时候，线程无法获取许可出现死锁。
     */
    public static void test3() {
        Thread thread = Thread.currentThread();

        LockSupport.unpark(thread);

        System.out.println("a");
        LockSupport.park();
        System.out.println("b");
        LockSupport.park();
        System.out.println("c");
    }


}
