package com.example.homework_2

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso

// TODO переделать пикассо
class MyHolder(view: View): RecyclerView.ViewHolder(view) {
    private val image by lazy { view.findViewById<ImageView>(R.id.image) }
    private val imageLoader by lazy { Picasso.get() }

    fun bind(item: Item) {
        // TODO string from res
        val url = "https://cataas.com/cat/${item.imageId()}"
        imageLoader.load(url).into(image)
    }
}