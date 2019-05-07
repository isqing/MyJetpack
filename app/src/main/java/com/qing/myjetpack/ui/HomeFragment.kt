package com.qing.myjetpack.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.qing.myjetpack.R
import com.qing.myjetpack.bean.HomeBean
import com.qing.myjetpack.bean.Result

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.home_fragment, container, false)
        view.findViewById<TextView>(R.id.tv).setOnClickListener(View.OnClickListener {
//            viewModel.getHomeData()?.value= HomeBean(0,"dddd", null);

        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getHomeData()?.observe(this, Observer {
            Log.i("qing=",it.reason);
        })
        viewModel.requestData();
    }

}
