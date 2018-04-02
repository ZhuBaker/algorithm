package com.jvm.separator.asyncnoblocking;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-04-02
 * Time: 11:16
 */
public interface IFutureListener<T> {

    public void operationCompleted(IFuture<T> future) throws Exception;

}
