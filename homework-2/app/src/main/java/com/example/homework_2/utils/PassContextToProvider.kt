package com.example.homework_2.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.homework_2.R
import com.example.homework_2.data.api.GetItemApi
import com.example.homework_2.data.providers.ImageProvider

// получение контекста
@SuppressLint("StaticFieldLeak")
object PassContextToProvider {
    lateinit var context: Context

    private val request by lazy { GetItemApi.getRequest(context.getString(R.string.base_url))  }

    fun initialize(context: Context) {
        PassContextToProvider.context = context.applicationContext
    }

    fun provider(): ImageProvider {
        return ImageProvider(request)
    }
}