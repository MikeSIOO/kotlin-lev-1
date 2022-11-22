package com.example.homework_2.data.api

import com.example.homework_2.presentation.model.Item
import com.example.homework_2.presentation.model.Request
import retrofit2.http.GET
import retrofit2.http.Query

// интерфейс запроса к сервису
interface GetRequest {
    // TODO string from res
//    @GET("/api/cats")
//    suspend fun getItems(@Query("limit") limit: Int, @Query("skip") offset: Int) : ArrayList<Item>
    @GET("/v1/gifs/search")
    suspend fun getItems(@Query("api_key") api_key: String,
                         @Query("q") q: String,
                         @Query("limit") limit: Int,
                         @Query("offset") offset: Int,
                         @Query("rating") rating: String,
                         @Query("lang") lang: String,
    ) : Request
//    ) : ArrayList<Item>
}