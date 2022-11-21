package com.example.homework_2

// провайдер для получения картинок из сети
class ItemProvider(private val getRequest: GetRequest) {
    suspend fun getItems(limit: Int, offset: Int): List<Item> {
        return getRequest.getItems(limit, offset)
    }
}