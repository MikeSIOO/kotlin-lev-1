package com.example.homework_2.presentation.view

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework_2.R
import com.example.homework_2.presentation.model.Response

class MyHolder(view: View, private val callback: (item: Response.Item) -> Unit): RecyclerView.ViewHolder(view) {
    private val image by lazy { view.findViewById<ImageView>(R.id.image) }
    private val context by lazy { view.context }

    fun bind(item: Response.Item) {

        val params = image.layoutParams as ConstraintLayout.LayoutParams
        params.dimensionRatio = "${item.images.fixed_width.width}:${item.images.fixed_width.height}"
        image.layoutParams = params

        Glide
            .with(context)
            .load(item.images.fixed_width.url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.mipmap.ic_launcher_round)
            .into(image)

        image.setOnClickListener {
            callback(item)
        }
    }
}