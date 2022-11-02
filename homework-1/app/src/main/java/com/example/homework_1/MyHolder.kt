package com.example.homework_1

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView: TextView = itemView.findViewById(R.id.textView)
    val background: View = itemView.findViewById(R.id.textView)
}