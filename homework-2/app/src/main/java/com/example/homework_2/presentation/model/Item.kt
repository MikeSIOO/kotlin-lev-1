package com.example.homework_2.presentation.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// Элемент, полученный по сети
data class Request(@SerializedName("data") var data: ArrayList<Item> = arrayListOf())

@Parcelize
data class Item(@SerializedName("data") var id: String = "",
                @SerializedName("embed_url") var embed_url: String = "",
                @SerializedName("images") var images: Images = Images()) : Parcelable

@Parcelize
data class Images(@SerializedName("fixed_width") var fixed_width: FixedWidth = FixedWidth()) : Parcelable

@Parcelize
data class FixedWidth(@SerializedName("url") var url: String = "",
                      @SerializedName("width") var width: Int = 200,
                      @SerializedName("height") var height: Int = 0) : Parcelable
