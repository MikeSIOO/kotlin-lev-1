package com.example.homework_2.domain

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.homework_2.presentation.model.Item

class MyPaginData constructor(private val provider: ItemProvider) {
    fun getItems(): LiveData<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                // TODO отредачить параметры
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                MyPaginSource(provider)
            },
            initialKey = 1
        ).liveData
    }
}