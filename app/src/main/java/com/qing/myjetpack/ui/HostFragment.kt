package com.qing.myjetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.qing.myjetpack.R

class HostFragment : Fragment() {

    companion object {
        fun newInstance() = HostFragment()
    }

    private lateinit var viewModel: HostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.host_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HostViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
