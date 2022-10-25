package com.example.homework_1

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private var diesLiveData: MutableLiveData<ArrayList<Die>> = MutableLiveData()

    fun getDies(): LiveData<ArrayList<Die>> {
        return diesLiveData
    }

    fun addDie() {
        val diesList = arrayListOf<Die>()
        for (i in 0..(diesLiveData.value?.size ?: 0)) {
            diesList.add(
                Die(
                    if (diesList.size % 2 != 0) {
                        Color.RED
//                        ContextCompat.getColor(requireView().context, R.color.red)
                    } else {
                        Color.BLUE
//                        ContextCompat.getColor(requireView().context, R.color.blue)
                    }
                )
            )
        }
        diesLiveData = MutableLiveData(diesList)
    }
}