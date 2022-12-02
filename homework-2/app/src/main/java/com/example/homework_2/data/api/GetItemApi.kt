package com.example.homework_2.data.api

import com.example.homework_2.data.entities.CreateRequest
import com.example.homework_2.data.entities.CreateSingleRequest
import com.example.homework_2.presentation.model.Response
import com.example.homework_2.presentation.model.SingleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// интерфейс запроса к сервису
interface GetItemApi {
    @GET("/v1/gifs/search")
    suspend fun getItems(
        @Query("api_key") api_key: String,
        @Query("q") q: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String,
        @Query("lang") lang: String,
    ) : Response

    companion object {
        fun getRequest(baseUrl: String): GetItemApi {
            return CreateRequest.createRequest(baseUrl).create(GetItemApi::class.java)
        }
    }

    @GET("/v1/gifs/{id}")
    suspend fun getSingleItems(
        @Path("id") id: String,
        @Query("api_key") api_key: String,
    ) : SingleResponse
}