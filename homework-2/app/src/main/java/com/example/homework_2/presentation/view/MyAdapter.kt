package com.example.homework_2.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.homework_2.R
import com.example.homework_2.presentation.model.Response

class MyAdapter: ListAdapter<Response.Item, MyHolder>(DifferentItemCallback()) {
    private val items: ArrayList<Response.Item> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun refreshList(item: List<Response.Item>) {
        items.clear()
        items.addAll(item)
    }
}