package com.example.homework_2.presentation.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// Запрос, полученный по сети
data class SingleResponse(
    @SerializedName("data") var data: Item
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
            @SerializedName("original") var original: Original = Original()
        ) : Parcelable {
            // Параметры изображения
            @Parcelize
            data class Original(
                @SerializedName("url") var url: String = "",
                @SerializedName("width") var width: Int = 0,
                @SerializedName("height") var height: Int = 0
            ) : Parcelable
        }
    }
}
