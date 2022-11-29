package com.example.homework_2.data.providers

import com.example.homework_2.ResponseParameters
import com.example.homework_2.data.api.GetItemApi
import com.example.homework_2.presentation.model.Response

// провайдер для получения картинок из сети
class ImageProvider(private val getRequest: GetItemApi) {
    suspend fun getItems(page: Int): Response {
        return getRequest.getItems(
            ResponseParameters.API_KEY.value,
            ResponseParameters.Q.value,
            ResponseParameters.LIMIT.value.toInt(),
            page * ResponseParameters.LIMIT.value.toInt(),
            ResponseParameters.RATING.value,
            ResponseParameters.LANG.value)
    }
}