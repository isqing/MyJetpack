package com.qing.myjetpack

import android.app.Application
import com.qing.httputillibray.httpUtils.HttpHelper
import com.qing.httputillibray.retrofit.RetrofitProcessor

/**
 *create by yqli on 2019/5/6
 */
class AppAppliction :Application() {
    override fun onCreate() {
        super.onCreate()
        HttpHelper.init(RetrofitProcessor(Constans.BASE_URL))

    }
}