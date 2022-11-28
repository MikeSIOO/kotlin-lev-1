package com.example.homework_2.data.api

import com.example.homework_2.presentation.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

// интерфейс запроса к сервису
interface GetItemRequest {
    @GET("/v1/gifs/search")
    suspend fun getItems(
        @Query("api_key") api_key: String,
        @Query("q") q: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String,
        @Query("lang") lang: String,
    ) : Response
}