package com.example.homework_2.domain

import com.example.homework_2.data.api.GetRequest
import com.example.homework_2.presentation.model.Request

// провайдер для получения картинок из сети
class ItemProvider(private val getRequest: GetRequest) {
    suspend fun getItems(limit: Int, offset: Int): Request {
        // TODO string from res
        return getRequest.getItems("9FF4Dz6pMk2JDlphgZOMSOU4l4fBWNII",
            "cat", limit, offset, "g", "en")
    }
}