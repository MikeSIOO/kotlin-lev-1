package com.example.homework_2.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.homework_2.presentation.model.Item

class MyPaginSource(private val service: ItemProvider) : PagingSource<Int, Item>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        val pageNumber = params.key ?: 0

        return try {
            val response = service.getItems(pageNumber)
            val data = response.data

            LoadResult.Page(
                data = data,
                prevKey = if (pageNumber == 0) null else pageNumber - 1,
                nextKey = if (data.isEmpty()) null else pageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}