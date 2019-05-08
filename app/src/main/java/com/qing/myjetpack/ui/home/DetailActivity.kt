package com.qing.myjetpack.ui.home

import android.os.Bundle
import com.qing.myjetpack.R
import com.qing.myjetpack.base.BaseActivity
import com.qing.myjetpack.bean.Data

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var i = intent;
        val extras = i.extras
        val detail = extras.getParcelable<Data>("detail")
        addFragment(R.id.frament, DetailFragment.newInstance(detail!!));
    }
}
