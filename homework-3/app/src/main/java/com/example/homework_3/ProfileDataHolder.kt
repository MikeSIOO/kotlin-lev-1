package com.example.homework_3

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProfileDataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: ProfileData.ProfileElement) {
        itemView.findViewById<TextView?>(R.id.name).text = "${item.name}, ${item.time}"
        itemView.findViewById<TextView?>(R.id.tags).text = item.tags.joinToString("\n")

        val image: ImageView = itemView.findViewById(R.id.image)
        Glide.with(itemView.context).load(item.image).into(image)
    }
}