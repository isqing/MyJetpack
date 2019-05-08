package com.qing.myjetpack.bean

import android.os.Parcel
import android.os.Parcelable

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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author_name)
        parcel.writeString(category)
        parcel.writeString(date)
        parcel.writeString(thumbnail_pic_s)
        parcel.writeString(thumbnail_pic_s02)
        parcel.writeString(thumbnail_pic_s03)
        parcel.writeString(title)
        parcel.writeString(uniquekey)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
}
