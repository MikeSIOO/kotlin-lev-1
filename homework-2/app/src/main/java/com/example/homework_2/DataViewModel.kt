package com.example.homework_2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private val mutableLiveData: MutableLiveData<ArrayList<MyImage>> = MutableLiveData()

    val images: LiveData<ArrayList<MyImage>> = mutableLiveData

    init {
        mutableLiveData.value = arrayListOf(
            MyImage(400, 400, R.drawable.ic_launcher_foreground),
            MyImage(400, 400, R.drawable.ic_launcher_background),
            MyImage(400, 400, R.drawable.ic_launcher_foreground),
        )
    }

    fun newPage() {
        mutableLiveData.value = arrayListOf(
            MyImage(400, 400, R.drawable.ic_launcher_background),
            MyImage(400, 400, R.drawable.ic_launcher_foreground),
            MyImage(400, 400, R.drawable.ic_launcher_background),
        )
    }
}