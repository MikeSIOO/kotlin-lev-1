package com.example.homework_1

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private var dies: ArrayList<Die>?,
) : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.die, null)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.textView.text = (position + 1).toString()
        holder.background.setBackgroundColor(dies?.get(position)?.color ?: Color.BLACK)
    }

    override fun getItemCount(): Int {
        return dies?.size ?: 0
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val background: ConstraintLayout = itemView.findViewById(R.id.background)
    }

    fun addAll(items: ArrayList<Die>) {
        dies?.clear()
        if (dies.isNullOrEmpty()) dies = items else dies?.addAll(items)
    }
}