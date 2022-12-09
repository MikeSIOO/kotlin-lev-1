package com.example.homework_2

import android.app.Application
import com.example.homework_2.utils.PassContextToProvider

// получение контекста приложения по необходимости
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        PassContextToProvider.initialize(this)
    }
}