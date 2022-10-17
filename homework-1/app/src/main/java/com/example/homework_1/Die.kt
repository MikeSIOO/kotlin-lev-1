package com.example.homework_1

import android.os.Parcel
import android.os.Parcelable

data class Die(val color: Int): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt(color)
    }

    companion object CREATOR : Parcelable.Creator<Die> {
        override fun createFromParcel(parcel: Parcel): Die {
            return Die(parcel)
        }

        override fun newArray(size: Int): Array<Die?> {
            return arrayOfNulls(size)
        }
    }
}
