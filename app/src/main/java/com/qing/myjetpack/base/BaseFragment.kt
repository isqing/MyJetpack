package com.qing.myjetpack.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 *create by yqli on 2019/5/7
 */
open class BaseFragment : Fragment {
    var TAG=this.javaClass.simpleName+"==>";

    constructor() : super()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"onCreate");
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i(TAG,"onCreateView");

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(TAG,"onViewCreated");

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG,"onActivityCreated");

        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"onStart");
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
}