package com.example.homework_2.presentation.view

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework_2.R

class MyHolder(view: View): RecyclerView.ViewHolder(view) {
    private val image by lazy { view.findViewById<ImageView>(R.id.image) }
    private val context by lazy { view.context }

    fun bind(item: Pair<String, ByteArray>) {
        Glide
            .with(context)
            .load(item.second)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.mipmap.ic_launcher_round)
            .fitCenter()
            .into(image)
    }
}