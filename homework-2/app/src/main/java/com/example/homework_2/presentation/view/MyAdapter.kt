package com.example.homework_2.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.homework_2.R
import com.example.homework_2.presentation.model.Item

class MyAdapter: ListAdapter<Item, MyHolder>(DifferentItemCallback()) {
    private val items: MutableMap<String, ByteArray> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = items.toList()[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun refreshList(item: MutableMap<String, ByteArray>) {
        items.clear()
        items.putAll(item)
    }
}