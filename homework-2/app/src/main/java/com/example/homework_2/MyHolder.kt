package com.example.homework_2

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL

import com.squareup.picasso.Picasso

// TODO переделать пикассо
class MyHolder(view: View): RecyclerView.ViewHolder(view) {
    private val image by lazy { view.findViewById<ImageView>(R.id.image) }
//    private val imageLoader by lazy { Picasso.get() }
    private val context by lazy { view.context }

    fun bind(item: Item) {
        // TODO string from res
        val url = "https://cataas.com/cat/${item.imageId()}"
//        imageLoader.load(url).into(image)

        Glide
            .with(context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.mipmap.ic_launcher_round)
            .into(image)
    }
}