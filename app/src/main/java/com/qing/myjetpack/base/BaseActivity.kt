package com.qing.myjetpack.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.qing.myjetpack.R

/**
 *create by yqli on 2019/5/7
 */
open class BaseActivity : AppCompatActivity {
    var TAG=this.javaClass.simpleName+"==>";

    constructor() : super()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"onCreate");
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"onStart");
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"onRestart");
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy");

    }
    fun addFragment( id :Int, fragment:Fragment){
        getSupportFragmentManager()
            .beginTransaction()
            .add(id, fragment)
            .show(fragment)
            .commit();
    }
}