package com.qing.httputillibray.retrofit;

import android.util.Log;

import com.google.gson.JsonObject;
import com.qing.httputillibray.callBack.Icallback;
import com.qing.httputillibray.httpUtils.IHttpProcessor;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * create by yqli on 2019/4/30
 */
public class RetrofitProcessor implements IHttpProcessor {
    private final String TAG=this.getClass().getSimpleName();
    private Retrofit retrofit;
    private ApiService apiService;

    public RetrofitProcessor(String URL) {
        this.retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(URL)
//                .addQueryParameter("udid", "d2807c895f0348a180148c9dfa6f2feeac0781b5")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient().newBuilder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                //公共参数
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        Request request = chain.request();
//                        HttpUrl httpUrl = request.url().newBuilder().addQueryParameter("platName", "sdk_test").build();
//                        Request newRequest = request.newBuilder().url(httpUrl).build();
//                        return chain.proceed(newRequest);
//                    }
//                })
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60L, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public void post(String url, Map<String, Object> params, final Icallback callback) {
        Observable<JsonObject> post = apiService.post( params);
        post.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(JsonObject s) {
                        Log.i(TAG, "onNext: ");
                        ( callback).successful(s.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: ");
                    }
                });
    }
}
