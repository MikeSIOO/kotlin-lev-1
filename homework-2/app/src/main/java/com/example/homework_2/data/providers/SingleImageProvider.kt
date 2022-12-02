package com.example.homework_2.data.providers

import com.example.homework_2.ResponseParameters
import com.example.homework_2.data.api.GetItemApi
import com.example.homework_2.presentation.model.Response
import com.example.homework_2.presentation.model.SingleResponse

// провайдер для получения картинок из сети
class SingleImageProvider(private val getSingleRequest: GetItemApi) {
    suspend fun getSingleItems(id: String): SingleResponse {
        return getSingleRequest.getSingleItems(
            id,
            ResponseParameters.API_KEY.value,
            )
    }
}