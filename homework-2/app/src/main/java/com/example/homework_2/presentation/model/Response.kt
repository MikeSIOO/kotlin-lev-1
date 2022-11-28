package com.example.homework_2.presentation.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// Запрос, полученный по сети
data class Response(
    @SerializedName("data") var data: ArrayList<Item> = arrayListOf()
) {
    // Элемент, полученный по сети
    @Parcelize
    data class Item(
        @SerializedName("id") var id: String = "",
        @SerializedName("embed_url") var embed_url: String = "",
        @SerializedName("images") var images: Images = Images()
    ) : Parcelable {
        // Конкретное изображение
        @Parcelize
        data class Images(
            @SerializedName("fixed_width") var fixed_width: FixedWidth = FixedWidth()
        ) : Parcelable {
            // Параметры изображения
            @Parcelize
            data class FixedWidth(
                @SerializedName("url") var url: String = "",
                @SerializedName("width") var width: Int = 200,
                @SerializedName("height") var height: Int = 0
            ) : Parcelable
        }
    }
}
