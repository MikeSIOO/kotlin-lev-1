package com.example.homework_2.data.api

import com.example.homework_2.presentation.model.Item
import retrofit2.http.GET
import retrofit2.http.Query

// интерфейс запроса к сервису
interface GetRequest {
    // TODO string from res
    @GET("/api/cats")
    suspend fun getItems(@Query("limit") limit: Int, @Query("skip") offset: Int) : ArrayList<Item>
}