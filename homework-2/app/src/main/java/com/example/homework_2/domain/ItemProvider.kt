package com.example.homework_2.domain

import com.example.homework_2.data.api.GetRequest
import com.example.homework_2.presentation.model.Request

// провайдер для получения картинок из сети
class ItemProvider(private val getRequest: GetRequest) {
    // TODO string from res
    private val api_key = "9FF4Dz6pMk2JDlphgZOMSOU4l4fBWNII"
    private val q = "cat"
    private val limit = 10
    private val rating = "g"
    private val lang = "en"

    suspend fun getItems(page: Int): Request {
        return getRequest.getItems(api_key, q, limit, (page - 1) * limit, rating, lang)
    }
}