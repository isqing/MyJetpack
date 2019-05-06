package com.qing.httputillibray.callBack;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * create by yqli on 2019/4/11
 */
public abstract class HttpCallBack<T> implements Icallback {
    @Override
    public void successful(String response) {

        Class<?> clazz=analysisClassInfo(this);
        T t=(T)new Gson().fromJson(response,clazz);
        onSuccess(t);
    }
    @Override
    public void fail(Error error) {

    }
    private Class<?> analysisClassInfo(Object obj) {
        Type gentype=obj.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) gentype).getActualTypeArguments();
        return (Class<?>) actualTypeArguments[0];
    }
    public abstract void onSuccess(T result);
}
