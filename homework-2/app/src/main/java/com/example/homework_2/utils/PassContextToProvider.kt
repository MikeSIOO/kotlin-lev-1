package com.example.homework_2.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.homework_2.R
import com.example.homework_2.data.entities.DescriptionGetRequest
import com.example.homework_2.domain.ImageProvider

// получение контекста
@SuppressLint("StaticFieldLeak")
object PassContextToProvider {
    lateinit var context: Context

    private val request by lazy { DescriptionGetRequest.create(context.getString(R.string.base_url))  }

    fun initialize(context: Context) {
        PassContextToProvider.context = context.applicationContext
    }

    fun provider(): ImageProvider {
        return ImageProvider(request)
    }
}