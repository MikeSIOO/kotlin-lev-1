package com.example.homework_2

// провайдер для похода в сеть
class MyProvider(private val accessor: IAccessor) {
    suspend fun getItems(offset: Int, limit: Int): List<Item> {
        return accessor.getItems(offset, limit)
    }
}