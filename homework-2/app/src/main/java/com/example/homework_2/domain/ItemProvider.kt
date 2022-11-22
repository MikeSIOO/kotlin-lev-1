package com.example.homework_2.domain

import com.example.homework_2.data.api.GetRequest
import com.example.homework_2.presentation.model.Item

// провайдер для получения картинок из сети
class ItemProvider(private val getRequest: GetRequest) {
    suspend fun getItems(limit: Int, offset: Int): ArrayList<Item> {
        return getRequest.getItems(limit, offset)
    }
}