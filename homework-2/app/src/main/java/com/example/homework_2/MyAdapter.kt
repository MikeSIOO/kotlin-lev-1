package com.example.homework_2

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyHolder>() {
    private val images: ArrayList<Image> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.element_image, null)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
//        holder.imageView.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

    fun changeData(item: ArrayList<Image>) {
        images.clear()
        images.addAll(item)
    }
}