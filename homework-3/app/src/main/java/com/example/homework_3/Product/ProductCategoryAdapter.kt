package com.example.homework_3.Product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_3.ProductCategories
import com.example.homework_3.R

class ProductCategoryAdapter(private val items: ArrayList<ProductCategories.Category>) : RecyclerView.Adapter<ProductCategoryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_category, parent, false)
        return ProductCategoryHolder(view)
    }

    override fun onBindViewHolder(holder: ProductCategoryHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}