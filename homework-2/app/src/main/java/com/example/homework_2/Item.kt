package com.example.homework_2

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// Элемент, полученный по сети
@Parcelize
class Item(@SerializedName("_id") var id: String = "") : Parcelable