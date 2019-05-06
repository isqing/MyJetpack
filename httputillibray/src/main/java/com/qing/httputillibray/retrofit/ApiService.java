package com.qing.httputillibray.retrofit;

import com.google.gson.JsonObject;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * create by yqli on 2019/4/30
 */
public interface ApiService {

    @POST("api/static/")
    Observable<JsonObject> post(@QueryMap Map<String, Object> params);
}
