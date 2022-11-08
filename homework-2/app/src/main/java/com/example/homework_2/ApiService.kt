package com.example.homework_2

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
// https://developer.android.com/codelabs/basic-android-kotlin-training-getting-data-internet#5
// https://rahul9650ray.medium.com/how-to-implement-rest-api-in-android-using-retrofit-in-kotlin-part-1-1302cb0d978b

// https://api.giphy.com/v1/gifs/search
// ?api_key=9FF4Dz6pMk2JDlphgZOMSOU4l4fBWNII&q=cat&limit=25&offset=0&rating=g&lang=en

private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .build()

//private val retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
//
//interface ImagesApiService {
//    @GET("photos")
//    suspend fun getImages(): List<MyImage>
//}
//
//object ImagesApi {
//    val retrofitService: ImagesApiService by lazy { retrofit.create(ImagesApiService::class.java) }
//}

//object MarsApi {
//    val retrofitService : ImagesApiService by lazy { retrofit.create(ImagesApiService::class.java) }
//}