package com.example.homework_2

import retrofit2.http.GET
import retrofit2.http.Query

interface GetRequest {
    // TODO string from res
    @GET("/api/cats")
    suspend fun getItems(@Query("limit") limit: Int, @Query("skip") offset: Int) : List<Item>
}