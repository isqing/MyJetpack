package com.qing.myjetpack.ui.home

import android.graphics.Bitmap
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

import com.qing.myjetpack.R
import com.qing.myjetpack.base.BaseFragment
import com.qing.myjetpack.bean.Data
import kotlinx.android.synthetic.main.detail_fragment.*



class DetailFragment : BaseFragment() {
    private lateinit var viewModel: DetailViewModel
    private var data: Data? = null;
    private  val ARG_PARAM = "bundle"

//    companion object {
//        fun newInstance(data: Data) =
//            DetailFragment().apply {
//                arguments = Bundle().apply {
//                    putParcelable(ARG_PARAM, data)
//                }
//            }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it?.getParcelable<Data>("detail")

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater?.inflate(R.layout.detail_fragment, container, false);
        val webView = view?.findViewById<WebView>(R.id.webView)
        val btn = view?.findViewById<Button>(R.id.btn)
        btn.setText(data?.url);
        btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_detailFragment3_to_blankFragment)
        })
        var webSetting = webView.settings;
        webSetting.javaScriptEnabled = true;
        webSetting.databaseEnabled = true;
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.i("qing==", "onPageStarted")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.i("qing==", "onPageFinished")

            }
        }
        webView.loadUrl(data?.url)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }


}
