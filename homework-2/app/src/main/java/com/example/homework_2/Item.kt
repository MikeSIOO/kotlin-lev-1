package com.example.homework_2

import com.google.gson.annotations.SerializedName

// Элемент, полученный по сети
class Item {
    @SerializedName("_id") var id = ""

    fun imageId() = id
}