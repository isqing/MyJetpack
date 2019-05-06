package com.qing.httputillibray.okHttp;

import android.os.Handler;

import com.qing.httputillibray.httpUtils.IHttpProcessor;
import com.qing.httputillibray.callBack.Icallback;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * create by yqli on 2019/4/11
 */
public class OkhttpProcessor implements IHttpProcessor {
    private OkHttpClient okHttpClient;
    private Handler handler;

    public OkhttpProcessor(){
        okHttpClient = new OkHttpClient();
        handler=new Handler();
    }
    @Override
    public void post(String url, Map<String, Object> params, final Icallback callback) {
        final RequestBody requestBody=appendBody(params);
        final Request request = new Request.Builder()
                .post(requestBody)
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
               e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                   final String str=response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.successful(str);

                        }
                    });
                }
            }
        });
    }

    private RequestBody appendBody(Map<String, Object> params) {
        FormBody.Builder formBody=new FormBody.Builder();
        if (params!=null||params.isEmpty()){
            return formBody.build();
        }
        for (Map.Entry<String,Object> entry :params.entrySet()){
            formBody.add(entry.getKey(),entry.getValue().toString());
        }
        return formBody.build();
    }
}
