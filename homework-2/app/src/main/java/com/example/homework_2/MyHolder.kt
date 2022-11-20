package com.example.homework_2

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.squareup.picasso.Picasso

class MyHolder(view: View): RecyclerView.ViewHolder(view) {
    private val image by lazy { view.findViewById<ImageView>(R.id.image) }
//    private val imageLoader by lazy { Picasso.get() }
    private val context by lazy { view.context }

    fun bind(item: Item) {
        val url = context.getString(R.string.base_url) + context.getString(R.string.image_url) + item.imageId()
//        imageLoader.load(url).into(image)

        Glide
            .with(context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.mipmap.ic_launcher_round)
//            .override(1000)
            .centerCrop()
            .into(image)
    }
}