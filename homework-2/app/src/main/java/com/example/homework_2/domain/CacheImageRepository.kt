//package com.example.homework_2.domain
//
//import com.example.homework_2.data.CacheImageManager
//import com.example.homework_2.presentation.model.Response
//import kotlinx.coroutines.withContext
//import kotlinx.coroutines.Dispatchers;
//import java.net.URL
//
//class CacheImageRepository(
//    private val provider: ImageProvider,
//    private val cacheImageManager: CacheImageManager
//) {
//    suspend fun getImages(page: Int) = provider.getItems(page)
//
//    suspend fun setCache(page: Int): ArrayList<Response.Item> {
//        val response = provider.getItems(page)
//        val data = response.data
//
//        data.forEach {
//            if (cacheImageManager.cache[it.id] == null) {
//                cacheImageManager.cache[it.id] =
//                    withContext(Dispatchers.IO) { URL(it.images.fixed_width.url).readBytes() }
//            }
//        }
//
//        return data
//    }
//
//    fun getCache(): MutableMap<String, ByteArray> {
//        return cacheImageManager.cache
//    }
//}