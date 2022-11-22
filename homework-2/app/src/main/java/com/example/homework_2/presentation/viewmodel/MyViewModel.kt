package com.example.homework_2.presentation.viewmodel

import androidx.lifecycle.*
import com.example.homework_2.utils.PassContextToProvider
import com.example.homework_2.R
import com.example.homework_2.presentation.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val itemsKey = "LIST_ITEMS"
    private val _items: MutableLiveData<ArrayList<Item>> =
        state.getLiveData(itemsKey, arrayListOf())
    val items: LiveData<ArrayList<Item>> = _items

    private val statusKey = "STATUS_LOADING"
    private var _status: MutableLiveData<Int> =
        state.getLiveData(statusKey, 0)
    val status: LiveData<Int> = _status

    private val provider = PassContextToProvider.provider()

    init {
        getItems(10, 0)
    }

    // TODO не надо только меня бить за R.integer.)
    fun getItems(limit: Int, offset: Int) {
        viewModelScope.launch {
            _status.value = R.integer.loading
            try {
                val request = withContext(Dispatchers.IO) {
//                val list = withContext(Dispatchers.IO) {
                    provider.getItems(limit, offset)
                }
                _status.value = R.integer.succsess
                _items.value = request.data
//                _items.value = list
            } catch (error: Throwable) {
                _status.value = R.integer.error
                error.printStackTrace()
            }
        }
    }
}