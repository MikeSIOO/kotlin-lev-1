package com.example.homework_2

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
}