package com.example.homework_2.presentation.view

import androidx.recyclerview.widget.DiffUtil
import com.example.homework_2.presentation.model.Item

// указать были ли изменения в элементах (для адаптера)
class DifferentItemCallback: DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
//        return oldItem.id == newItem.id
    }
}