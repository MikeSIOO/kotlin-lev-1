package com.example.homework_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyHolder>() {
    private val dies: ArrayList<Die> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.die, null)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.textView.text = (position + 1).toString()
        holder.background.setBackgroundColor(dies[position].color)
    }

    override fun getItemCount(): Int {
        return dies.size
    }

    fun changeData(item: ArrayList<Die>) {
        dies.clear()
        dies.addAll(item)
    }
}