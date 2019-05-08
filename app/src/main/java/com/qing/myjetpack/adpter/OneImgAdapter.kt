package com.qing.myjetpack.adpter

import android.content.Context
import android.text.TextUtils
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.qing.myjetpack.R
import com.qing.myjetpack.bean.Data
import com.qing.myjetpack.utils.recyclerview.base.ItemViewDelegate
import com.qing.myjetpack.utils.recyclerview.base.ViewHolder

/**
 *create by yqli on 2019/5/7
 */
class OneImgAdapter : ItemViewDelegate<Data> {
    var context: Context?=null;
    constructor(context: Context ){
        this.context=context;
    }
    override fun convert(holder: ViewHolder?, t: Data?, position: Int) {
        holder?.setText(R.id.tv_title, t?.title);
        holder?.setText(R.id.tv_author_name, t?.author_name);
        var img =holder?.getView<ImageView>(R.id.iv_img);
        Glide.with(context!!).load(t?.thumbnail_pic_s)
            .into(img!!);

    }

    override fun isForViewType(item: Data?, position: Int): Boolean {
        if (TextUtils.isEmpty(item?.thumbnail_pic_s03)) {
            return true;
        }
        return false;
    }

    override fun getItemViewLayoutId(): Int {
        return R.layout.select_one_item
    }

}