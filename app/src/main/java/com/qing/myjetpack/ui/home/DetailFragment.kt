package com.qing.myjetpack.ui.home

import android.graphics.Bitmap
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

import com.qing.myjetpack.R
import com.qing.myjetpack.base.BaseFragment
import com.qing.myjetpack.bean.Data
import kotlinx.android.synthetic.main.detail_fragment.*

private const val ARG_PARAM = "bundle"


class DetailFragment : BaseFragment() {
    private lateinit var viewModel: DetailViewModel
    private  var  data:Data?=null;

    companion object {

        @JvmStatic
        fun newInstance(data: Data) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM, data)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data=it?.getParcelable<Data>(ARG_PARAM)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var webSetting=webView.settings;
        webSetting.javaScriptEnabled=true;
        webSetting.databaseEnabled=true;
        webView.webViewClient=object :WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.i("qing==","onPageStarted")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.i("qing==","onPageFinished")

            }
        }
        webView.loadUrl(data?.url)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
