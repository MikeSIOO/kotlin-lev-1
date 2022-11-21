package com.example.homework_2

import android.annotation.SuppressLint
import android.content.Context

// получение контекста
@SuppressLint("StaticFieldLeak")
object ServiceLocator {
    lateinit var context: Context

    private val request by lazy { DescriptionRequest.create(context.getString(R.string.base_url))  }

    fun initialize(context: Context) {
        this.context = context.applicationContext
    }

    fun provider(): MyProvider {
        return MyProvider(request)
    }
}