package com.example.homework_3.Product

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_3.ProductCategories
import com.example.homework_3.R

class ProductCategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: ProductCategories.Category) {
        val name: TextView = itemView.findViewById(R.id.name)
        name.text = item.name
    }
}