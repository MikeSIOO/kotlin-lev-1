package com.example.homework_3.Profile

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework_3.ProfileData
import com.example.homework_3.R

class ProfileDataHolder(
    itemView: View,
    private val callback: (item: ProfileData.ProfileElement) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: ProfileData.ProfileElement) {
        itemView.findViewById<TextView?>(R.id.name).text = "${item.name}, ${item.time}"
        itemView.findViewById<TextView?>(R.id.tags).text = item.tags.joinToString("\n")

        val image: ImageView = itemView.findViewById(R.id.image)
        Glide.with(itemView.context).load(item.image).into(image)

        itemView.findViewById<CardView?>(R.id.card).setOnClickListener {
            callback(item)
        }
    }
}