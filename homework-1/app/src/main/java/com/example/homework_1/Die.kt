package com.example.homework_1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Die(val num: Int, val color: Int) : Parcelable
