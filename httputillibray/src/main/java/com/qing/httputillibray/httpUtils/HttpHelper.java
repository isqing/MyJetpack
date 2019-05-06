package com.qing.httputillibray.httpUtils;

import com.qing.httputillibray.callBack.Icallback;

import java.util.Map;

/**
 * create by yqli on 2019/4/11
 */
public class HttpHelper implements IHttpProcessor {
    private static HttpHelper instance;
    private static IHttpProcessor httpProcessor;
    public HttpHelper() {
    }

    public static HttpHelper instance(){
        if (instance==null){
            synchronized (HttpHelper.class){
                if (instance==null){
                    instance=new HttpHelper();
                }
            }
        }
        return instance;
    }
    public static void init(IHttpProcessor processor){
        httpProcessor=processor;
    }
    @Override
    public void post(String url, Map<String, Object> params, Icallback callback) {
        httpProcessor.post(url, params, callback);
    }
}
