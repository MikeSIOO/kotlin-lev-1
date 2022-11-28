package com.example.homework_2.domain

import com.example.homework_2.ResponseParameters
import com.example.homework_2.data.api.GetItemRequest
import com.example.homework_2.presentation.model.Response

// провайдер для получения картинок из сети
class ImageProvider(private val getRequest: GetItemRequest) {

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