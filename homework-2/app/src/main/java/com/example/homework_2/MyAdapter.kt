package com.example.homework_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private var images: ArrayList<MyImage>) : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.element_image, null)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.imageView.setImageResource(images[position].img)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    fun changeData(item: ArrayList<MyImage>) {
//        images.clear()
//        images.addAll(item)
        images = item
    }
}
