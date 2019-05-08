package com.qing.myjetpack.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.qing.myjetpack.R
import com.qing.myjetpack.adpter.HomeAdpter
import com.qing.myjetpack.bean.Data
import com.qing.myjetpack.utils.DividerItemDecoration
import com.qing.myjetpack.utils.recyclerview.MultiItemTypeAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.qing.myjetpack.base.BaseFragment


class HomeFragment : BaseFragment() {

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
        return inflater.inflate(com.qing.myjetpack.R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mulAdpter = HomeAdpter(context!!, dataList);
        rv.layoutManager = LinearLayoutManager(context);

        rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));
        rv.setAdapter(mulAdpter);
        mulAdpter?.setOnItemClickListener(object  : MultiItemTypeAdapter.OnItemClickListener{
            override fun onItemClick(view: View?, holder: RecyclerView.ViewHolder?, position: Int) {
//                var intent = Intent()
//                intent.setClass(context, DetailActivity::class.java!!)
                var bundle=Bundle();
                bundle.putParcelable("detail",dataList.get(position));
//                intent.putExtras(bundle);
//                startActivity(intent)
//                findNavController().navigate(R.id.action_firstFragment_to_detailActivity,bundle);
                navagition(bundle);

            }

            override fun onItemLongClick(view: View?, holder: RecyclerView.ViewHolder?, position: Int): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }

    private fun navagition(bundle: Bundle) {
        NavHostFragment.findNavController(this).navigate(R.id.action_firstFragment_to_detailActivity,bundle);

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
