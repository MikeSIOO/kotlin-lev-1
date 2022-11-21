package com.example.homework_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class MyAdapter: ListAdapter<Item, MyHolder>(DifferentItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

// TODO почему работает без него
//    override fun getItemCount(): Int {
//        return dies.size
//    }
}