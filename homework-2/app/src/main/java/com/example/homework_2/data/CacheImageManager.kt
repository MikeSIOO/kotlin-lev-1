package com.example.homework_2.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class CacheImageManager {
    var cache: MutableMap<String, ByteArray> = mutableMapOf()

    suspend fun checkCache(key: String, url: String): ByteArray {
        if (cache[key] == null) {
            cache[key] = byteArrFromUrl(url)
        }
        return cache[key]!!
    }

    private suspend fun byteArrFromUrl(url: String) : ByteArray {
        return withContext(Dispatchers.IO) {
            URL(url).readBytes()
        }
    }
}