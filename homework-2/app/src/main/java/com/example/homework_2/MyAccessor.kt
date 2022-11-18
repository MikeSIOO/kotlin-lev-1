package com.example.homework_2

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IAccessor {
    // TODO string from res
    @GET("/api/cats")
    suspend fun getItems(@Query("skip") offset: Int, @Query("limit") limit: Int) : List<Item>

    // static
    companion object {
        fun create(baseUrl: String): IAccessor {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder().apply {
                addNetworkInterceptor(loggingInterceptor)
            }.build()

            val retrofit = Retrofit.Builder().apply {
                client(client)
                addConverterFactory(GsonConverterFactory.create())
                baseUrl(baseUrl)
            }.build()

            return retrofit.create(IAccessor::class.java)
        }
    }
}