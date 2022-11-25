package com.example.homework_2.domain

import com.example.homework_2.Response
import com.example.homework_2.data.api.GetRequest
import com.example.homework_2.presentation.model.Request

// провайдер для получения картинок из сети
class ItemProvider(private val getRequest: GetRequest) {

    suspend fun getItems(page: Int): Request {
        return getRequest.getItems(
            Response.API_KEY.value,
            Response.Q.value,
            Response.LIMIT.value.toInt(),
            page * Response.LIMIT.value.toInt(),
            Response.RATING.value,
            Response.LANG.value)
    }
}