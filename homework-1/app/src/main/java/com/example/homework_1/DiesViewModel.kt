package com.example.homework_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class DiesViewModel(state: SavedStateHandle) : ViewModel() {
    private val SAVED = "SAVED"

    private val savedStateHandle: SavedStateHandle = state

    private val mutableLiveData: MutableLiveData<ArrayList<Die>> =
        savedStateHandle.getLiveData(SAVED, arrayListOf())

    val dies: LiveData<ArrayList<Die>> = mutableLiveData

    fun addDie(redColor: Int, blueColor: Int) {
        val _dies = arrayListOf<Die>()
        for (i in 0..(mutableLiveData.value?.size ?: 0)) {
            _dies.add(Die(i, if (_dies.size % 2 != 0) redColor else blueColor))
        }
        mutableLiveData.value = _dies
    }
}