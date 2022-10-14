package com.example.homework_1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val dies: List<Die>,
) : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.die, null)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.textView.text = (position+1).toString()
        holder.background.setBackgroundColor(
            // TODO сделать загрузку цветов из ресурсов
            if (position % 2 != 0) Color.RED else Color.BLUE)
//                .setBackgroundColor(ContextCompat.getColor(this, R.color.white))
    }

    override fun getItemCount(): Int {
        return dies.size
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val background: ConstraintLayout = itemView.findViewById(R.id.background)

        init {}
    }
}