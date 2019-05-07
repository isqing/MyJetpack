package com.qing.myjetpack.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.qing.myjetpack.R
import com.qing.myjetpack.adpter.HomeAdpter
import com.qing.myjetpack.bean.Data
import com.qing.myjetpack.utils.recyclerview.MultiItemTypeAdapter
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    var mulAdpter: MultiItemTypeAdapter<Data>? = null;
    var dataList = ArrayList<Data>();

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mulAdpter = HomeAdpter(context!!, dataList);
        rv.layoutManager = LinearLayoutManager(context);
        rv.setAdapter(mulAdpter);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getHomeData()?.observe(this, Observer {
            Log.i("qing=", it.reason);
            var data=it?.result?.data;
            dataList.clear();
            dataList.addAll(data!!);
            mulAdpter?.notifyDataSetChanged()
        })
        viewModel.requestData();
    }

}
