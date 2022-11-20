package com.example.homework_2

// провайдер для похода в сеть
class MyProvider(private val accessor: IAccessor) {
    suspend fun getItems(limit: Int, offset: Int): List<Item> {
        return accessor.getItems(limit, offset)
    }
}