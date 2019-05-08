package com.qing.myjetpack.adpter

import android.content.Context
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.qing.myjetpack.R
import com.qing.myjetpack.bean.Data
import com.qing.myjetpack.utils.recyclerview.base.ItemViewDelegate
import com.qing.myjetpack.utils.recyclerview.base.ViewHolder

/**
 *create by yqli on 2019/5/7
 */
class ThreeImgAdapter : ItemViewDelegate<Data> {
    var context: Context?=null;
    constructor(context: Context ){
        this.context=context;
    }
    override fun convert(holder: ViewHolder?, t:Data?, position: Int) {
        holder?.setText(R.id.tv_title, t?.title);
        holder?.setText(R.id.tv_author_name, t?.author_name);
        var img1 =holder?.getView<ImageView>(R.id.iv_img_1);
        var img2 =holder?.getView<ImageView>(R.id.iv_img_2);
        var img3 =holder?.getView<ImageView>(R.id.iv_img_3);
        Glide.with(context!!).load(t?.thumbnail_pic_s).into(img1!!);
        Glide.with(context!!).load(t?.thumbnail_pic_s02).into(img2!!);
        Glide.with(context!!).load(t?.thumbnail_pic_s03).into(img3!!);

    }

    override fun isForViewType(item: Data?, position: Int): Boolean {
        if (TextUtils.isEmpty(item?.thumbnail_pic_s03)) {
            return false;
        }
        return true;
    }

    override fun getItemViewLayoutId(): Int {
        return R.layout.select_three_item
    }

}