package com.example.homework_2.domain

import androidx.lifecycle.MutableLiveData
import com.example.homework_2.data.CacheImageManager
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers;
import java.net.URL

class CacheImageRepository() {
    val images = MutableLiveData<CacheImageManager>()

    suspend fun setCache(map: MutableMap<String, String>){
        map.forEach {
            if (images.value?.cache?.get(it.key) == null) {
                images.value?.cache?.set(it.key,
                    withContext(Dispatchers.IO) { URL(it.value).readBytes() }
                )
            }
        }
    }

//    fun getCache(): MutableMap<String, ByteArray> {
//        return images.value?.cache!!
//    }
}