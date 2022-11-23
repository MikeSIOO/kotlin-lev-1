package com.example.homework_2.utils

import android.app.Application

// получение контекста приложения по необходимости
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        PassContextToProvider.initialize(this)
    }
}