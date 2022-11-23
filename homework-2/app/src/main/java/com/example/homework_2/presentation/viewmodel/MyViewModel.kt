package com.example.homework_2.presentation.viewmodel

import androidx.lifecycle.*
import com.example.homework_2.utils.PassContextToProvider
import com.example.homework_2.StatusLoad
import com.example.homework_2.presentation.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val itemsKey = "ITEMS"
    private val _items: MutableLiveData<ArrayList<Item>> =
        state.getLiveData(itemsKey, arrayListOf())
    val items: LiveData<ArrayList<Item>> = _items

    private val statusKey = "STATUS_LOADING"
    private var _status: MutableLiveData<StatusLoad> =
        state.getLiveData(statusKey, StatusLoad.LOADING)
    val status: LiveData<StatusLoad> = _status

    private val pageKey = "PAGE"
    private var _page: MutableLiveData<Int> =
        state.getLiveData(pageKey, 1)

    private val provider = PassContextToProvider.provider()

    fun getItems(page: Int) {
        viewModelScope.launch {
            _status.value = StatusLoad.LOADING
            try {
                val request = withContext(Dispatchers.IO) {
                    provider.getItems(page)
                }
                _status.value = StatusLoad.SUCCESS
                _items.value = request.data
            } catch (error: Throwable) {
                _status.value = StatusLoad.ERROR
                error.printStackTrace()
            }
        }
    }
}