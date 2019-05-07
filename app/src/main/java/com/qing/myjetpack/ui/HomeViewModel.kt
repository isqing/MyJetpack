package com.qing.myjetpack.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qing.httputillibray.callBack.HttpCallBack
import com.qing.httputillibray.httpUtils.HttpHelper
import com.qing.myjetpack.Constans
import com.qing.myjetpack.bean.HomeBean
import java.util.HashMap


class HomeViewModel : ViewModel() {
    val TAG=this.javaClass.simpleName;
    // TODO: Implement the ViewModel
     private var homeBean : MutableLiveData<HomeBean>?= null;
    private var str : MutableLiveData<String>?=null;
    public fun  requestData(){
//        if (homeBean==null){
//            homeBean = MutableLiveData<HomeBean>();
//        }
        var map = HashMap<String, Any>();

        map["type"]="";
        map["key"]="69bde3e9041f66b9009af510193bec92";
        HttpHelper.instance().post(Constans.BASE_URL, map, object : HttpCallBack<HomeBean>() {
            override fun onSuccess(result: HomeBean) {
                 if (result!=null) {
                     homeBean?.value=result;
                    Log.i(TAG, "onSuccess: " + homeBean?.value?.result?.stat)
                 }
            }
        })
    }
    fun getHomeData(): MutableLiveData<HomeBean> ? {
        if (homeBean==null){
            homeBean= MutableLiveData<HomeBean>();
        }
        return homeBean;
    }
    fun getStr() : MutableLiveData<String>?{
        if (str==null){
            str= MutableLiveData<String>();
        }
        return  str;
    }
}
