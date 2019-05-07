package com.qing.myjetpack.bean

/**
 *create by yqli on 2019/5/5
 */

data class HomeBean (
    val error_code: Int,
    val reason: String,
    val result: Result?
)


data class Result(
    val `data`: List<Data> ,
    val stat: String
)

data class Data(
    val author_name: String,
    val category: String,
    val date: String,
    val thumbnail_pic_s: String,
    val thumbnail_pic_s02: String,
    val thumbnail_pic_s03: String,
    val title: String,
    val uniquekey: String,
    val url: String
)
