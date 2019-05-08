package com.qing.myjetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.qing.myjetpack.MainActivity

import com.qing.myjetpack.R
import com.qing.myjetpack.base.BaseFragment

class MeFragment : BaseFragment() {

    companion object {
        fun newInstance() = MeFragment()
    }

    private lateinit var viewModel: MeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.me_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onResume() {
        super.onResume()
        MainActivity.tabs[2]=true;
        if (MainActivity.tabs.contains(true)) {
            (activity as MainActivity).showBottomBar()
        }

    }

    override fun onPause() {
        super.onPause()
        MainActivity.tabs[2]=false;
        if (!MainActivity.tabs.contains(true)) {
            (activity as MainActivity).hideBottomBar()
        }
    }
}
