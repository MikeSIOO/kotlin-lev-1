package com.example.homework_2

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object ServiceLocator {
    lateinit var context: Context

    private val accessor by lazy { IAccessor.create(context.getString(R.string.base_url))  }

    fun initialize(context: Context) {
        this.context = context.applicationContext
    }

    fun provider(): MyProvider {
        return MyProvider(accessor)
    }
}