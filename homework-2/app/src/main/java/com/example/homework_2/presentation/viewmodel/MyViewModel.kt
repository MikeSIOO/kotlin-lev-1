package com.example.homework_2.presentation.viewmodel

import androidx.lifecycle.*
import com.example.homework_2.utils.PassContextToProvider
import com.example.homework_2.StatusLoad
import com.example.homework_2.data.CacheImgManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val itemsKey = "ITEMS"
    private val _items: MutableLiveData<CacheImgManager> =
        state.getLiveData(itemsKey, CacheImgManager())
    val items: LiveData<CacheImgManager> = _items

    private val statusKey = "STATUS_LOADING"
    private var _status: MutableLiveData<StatusLoad> =
        state.getLiveData(statusKey, StatusLoad.LOADING)
    val status: LiveData<StatusLoad> = _status

    private val provider = PassContextToProvider.provider()

    fun getItems(page: Int) {
        val myCache = CacheImgManager()
        viewModelScope.launch {
            _status.value = StatusLoad.LOADING
            try {
                val request = withContext(Dispatchers.IO) {
                    provider.getItems(page)
                }
                request.data.forEach {
                    withContext(Dispatchers.IO) {
                        myCache.checkCache(it.id, it.images.fixed_width.url)
                    }
                }
                _items.value = myCache
                _status.value = StatusLoad.SUCCESS
            } catch (error: Throwable) {
                _status.value = StatusLoad.ERROR
                error.printStackTrace()
            }
        }
    }
}