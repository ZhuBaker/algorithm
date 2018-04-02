package com.jvm.separator.asyncnoblocking;

import java.util.Collection;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-04-02
 * Time: 11:34
 */
public class AbstractFuture<V> implements IFuture<V> {

    // 需要保证其可见性
    protected volatile Object result;

    // 监听器
    protected Collection<IFutureListener<V>> listeners = new CopyOnWriteArrayList<IFutureListener<V>>();

    private static final SuccessSignal SUCCESS_SIGNAL = new SuccessSignal();



    @Override
    public boolean isSuccess() {
        return result == null ? false : result instanc
    }

    @Override
    public V getNow() {
        return null;
    }

    @Override
    public Throwable cause() {
        return null;
    }

    @Override
    public boolean isCancellable() {
        return result == null;
    }

    @Override
    public IFuture<V> await() throws InterruptedException {
        return null;
    }

    @Override
    public boolean await(long timeoutMillis) throws InterruptedException {
        return false;
    }

    @Override
    public boolean await(long timeout, TimeUnit timeunit) throws InterruptedException {
        return false;
    }

    @Override
    public IFuture<V> awaitUninterruptibly() {
        return null;
    }

    @Override
    public boolean awaitUninterruptibly(long timeoutMillis) {
        return false;
    }

    @Override
    public boolean awaitUninterruptibly(long timeout, TimeUnit timeunit) {
        return false;
    }

    @Override
    public IFuture<V> addListener(IFutureListener<V> l) {
        return null;
    }

    @Override
    public IFuture<V> removeListener(IFutureListener<V> l) {
        return null;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        if(isDone()){// 已经完成了 不能取消
            return false;
        }
        synchronized (this){
            if(isDone()){
                return false;
            }
            result = new CauseHolder(new CancellationException());
            notifyAll();// isDone = true; 通知等待在该对象的wait的线程
        }
        notifyListeners(); // 通知监听器该异步操作已完成
        return true;
    }

    private void notifyListeners() {
        for (IFutureListener<V> l : listeners){
            notifyListener(l);
        }
    }

    private void notifyListener(IFutureListener<V> l) {
        try{
            l.operationCompleted(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isCancelled() {
        return result != null && result instanceof CauseHolder &&
                ((CauseHolder)result).cause instanceof CancellationException;
    }

    @Override
    public boolean isDone() {
        return result != null;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        await();//等待执行结果
        Throwable cause = cause();
        if(cause == null){ // 没有发生异常，异步操作正常结果
            return getNow();
        }
        if(cause instanceof CancellationException){ // 异步操作被取消了
            throw (CancellationException)cause;
        }
        throw new ExecutionException(cause);//其他异常
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {

        if(await(timeout,unit)) { //超时等待执行结果
            Throwable cause = cause();
            if(cause == null){
                return getNow();
            }
            if(cause instanceof CancellationException){
                throw (CancellationException)cause;
            }
            throw new ExecutionException(cause);
        }

        throw new TimeoutException();
    }

    private static class SuccessSignal {

    }

    private static final class CauseHolder {
        final Throwable cause;

        public CauseHolder(Throwable cause) {
            this.cause = cause;
        }
    }
}
