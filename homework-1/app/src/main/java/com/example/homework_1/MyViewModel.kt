package com.example.homework_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(state : SavedStateHandle) : ViewModel() {
    private val savedStateHandle: SavedStateHandle = state

    private val diesLiveData: MutableLiveData<ArrayList<Die>> = savedStateHandle.getLiveData("SAVED", arrayListOf())

    val list: LiveData<ArrayList<Die>> = diesLiveData

    fun addDie(redColor: Int, blueColor: Int) {
        val diesList = arrayListOf<Die>()
        for (i in 0..(diesLiveData.value?.size ?: 0)) {
            diesList.add(Die(if (diesList.size % 2 != 0) redColor else blueColor))
        }
        diesLiveData.value = diesList
    }
}