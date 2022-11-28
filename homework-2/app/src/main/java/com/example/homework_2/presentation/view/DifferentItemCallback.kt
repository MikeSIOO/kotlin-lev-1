package com.example.homework_2.presentation.view

import androidx.recyclerview.widget.DiffUtil
import com.example.homework_2.presentation.model.Response

// указать были ли изменения в элементах (для адаптера)
class DifferentItemCallback: DiffUtil.ItemCallback<Response.Item>() {
    override fun areItemsTheSame(oldItem: Response.Item, newItem: Response.Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Response.Item, newItem: Response.Item): Boolean {
        return oldItem == newItem
    }
}