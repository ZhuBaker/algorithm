package com.jvm.separator.asyncnoblocking;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-04-02
 * Time: 11:13
 */
public interface IFuture<V> extends Future<V> {

    boolean isSuccess(); // 是否成功
    V getNow(); //立即返回结果(不管Future是否处于完成状态)
    Throwable cause(); //若执行失败时的原因
    boolean isCancellable(); //是否可以取消
    IFuture<V> await() throws InterruptedException; //等待future的完成
    boolean await(long timeoutMillis) throws InterruptedException; // 超时等待future的完成
    boolean await(long timeout, TimeUnit timeunit) throws InterruptedException;
    IFuture<V> awaitUninterruptibly(); //等待future的完成，不响应中断
    boolean awaitUninterruptibly(long timeoutMillis);//超时等待future的完成，不响应中断
    boolean awaitUninterruptibly(long timeout, TimeUnit timeunit);
    IFuture<V> addListener(IFutureListener<V> l); //当future完成时，会通知这些加进来的监听器
    IFuture<V> removeListener(IFutureListener<V> l);


}
