package com.jvm.separator.asyncnoblocking;

/**
 * Created by zhubo on 2018/4/3.
 */
public class DelayAdditionFuture extends  AbstractFuture<Integer>  {

    @Override
    public IFuture<Integer> setSuccess(Object result) {
        return super.setSuccess(result);
    }

    @Override
    public IFuture<Integer> setFailure(Throwable cause) {
        return super.setFailure(cause);
    }
}
