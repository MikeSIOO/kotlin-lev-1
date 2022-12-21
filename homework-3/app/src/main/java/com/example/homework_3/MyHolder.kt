package com.example.homework_3

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: ProductCategories.Category) {
        val name: TextView = itemView.findViewById(R.id.name)
        name.text = item.name
    }
}