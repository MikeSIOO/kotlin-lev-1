package com.example.homework_3.Recipe

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework_3.FullRecipe
import com.example.homework_3.R

class RecipeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: FullRecipe.RecipeElement.Step) {
        itemView.findViewById<TextView?>(R.id.name).text = "Шаг #${item.id}"
        itemView.findViewById<TextView?>(R.id.instruction).text = item.description

        val image: ImageView = itemView.findViewById(R.id.image)
        Glide.with(itemView.context).load(item.image).into(image)
    }
}