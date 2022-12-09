package com.example.homework_2.presentation.viewmodel

import androidx.lifecycle.*
import com.example.homework_2.utils.PassContextToProvider
import com.example.homework_2.StatusLoad
import com.example.homework_2.presentation.model.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val itemsKey = "ITEMS"
    private val _items: MutableLiveData<ArrayList<Response.Item>> =
        state.getLiveData(itemsKey, arrayListOf())
    val items: LiveData<ArrayList<Response.Item>> = _items

    private val statusKey = "STATUS_LOADING"
    private var _status: MutableLiveData<StatusLoad> =
        state.getLiveData(statusKey, StatusLoad.LOADING)
    val status: LiveData<StatusLoad> = _status

    private val provider = PassContextToProvider.provider()

    init {
        getItems(0)
    }

    fun refreshItems(page: Int = 0) {
        getItems(page)
    }

    private fun getItems(page: Int) {
        viewModelScope.launch {
            _status.value = StatusLoad.LOADING
            try {
                val request = withContext(Dispatchers.IO) {
                    provider.getItems(page)
//                    cacheImageRepository.setCache(page)
                }
                _items.value = request.data
                _status.value = StatusLoad.SUCCESS
            } catch (error: Throwable) {
                _status.value = StatusLoad.ERROR
                error.printStackTrace()
            }
        }
    }
}