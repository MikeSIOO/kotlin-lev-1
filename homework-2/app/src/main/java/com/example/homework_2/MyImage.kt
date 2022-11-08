package com.example.homework_2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyImage(
//    val type: String, // type
    val height: Int, // images original height
    val width: Int, // images original width
    val img: Int,
//    val uri: Uri, // embed_url
    ) : Parcelable {
}

//private val images = arrayListOf(
//    MyImage(400, 400, R.drawable.ic_launcher_foreground),
//    MyImage(400, 400, R.drawable.ic_launcher_background),
//    MyImage(400, 400, androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha),
//)

// https://giphy.com/embed/BzyTuYCmvSORqs1ABM
// https://giphy.com/embed/ICOgUNjpvO0PC
// https://giphy.com/embed/l4KibK3JwaVo0CjDO