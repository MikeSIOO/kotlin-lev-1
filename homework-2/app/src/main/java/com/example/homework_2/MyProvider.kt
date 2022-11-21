package com.example.homework_2

// провайдер для похода в сеть
class MyProvider(private val getRequest: GetRequest) {
    suspend fun getItems(limit: Int, offset: Int): List<Item> {
        return getRequest.getItems(limit, offset)
    }
}