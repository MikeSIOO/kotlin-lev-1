package com.example.homework_2.presentation.viewmodel

import androidx.lifecycle.*
import com.example.homework_2.utils.PassContextToProvider
import com.example.homework_2.R
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
    private var _status: MutableLiveData<Int> =
        state.getLiveData(statusKey, R.integer.loading)
    val status: LiveData<Int> = _status

    private val pageKey = "PAGE"
    private var _page: MutableLiveData<Int> =
        state.getLiveData(pageKey, 1)

    private val provider = PassContextToProvider.provider()

    init {
        if (false) { // есть кэш
            TODO("Get from cache")
        } else {
            getItems(_page.value!!)
            // TODO load to cache
        }
    }

    // TODO не надо только меня бить за R.integer.)
    private fun getItems(page: Int) {
        viewModelScope.launch {
            _status.value = R.integer.loading
            try {
                val request = withContext(Dispatchers.IO) {
                    provider.getItems(page)
                }
                _status.value = R.integer.succsess
                _items.value = request.data
            } catch (error: Throwable) {
                _status.value = R.integer.error
                error.printStackTrace()
            }
        }
    }
}