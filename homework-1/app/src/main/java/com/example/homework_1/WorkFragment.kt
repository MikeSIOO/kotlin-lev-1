package com.example.homework_1

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkFragment : Fragment() {
    private val NUM_OF_ELEMENTS = "NumOfElements"
    private var counter: Int = 7
    private lateinit var recyclerView: RecyclerView
    lateinit var customRecyclerAdapter: CustomRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // TODO вертикальная ориентация
//            recyclerView.layoutManager = GridLayoutManager(requireView().context, 3)
        } else {
            // TODO горизонтальная ориентация
//            recyclerView.layoutManager = GridLayoutManager(requireView().context, 4)
        }
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        customRecyclerAdapter = CustomRecyclerAdapter(counter)
        recyclerView.adapter = customRecyclerAdapter
        recyclerView.layoutManager = GridLayoutManager(view.context, 3)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NUM_OF_ELEMENTS, counter)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(NUM_OF_ELEMENTS)
        }
    }

    class CustomRecyclerAdapter(private val counter: Int) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val textView: TextView = itemView.findViewById(R.id.textView)
            val die: ConstraintLayout = itemView.findViewById(R.id.die)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.die, parent, false)
            return MyViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textView.text = (position+1).toString()
            holder.die.setBackgroundColor(
                // TODO сделать загрузку цветов из ресурсов
                if (position % 2 != 0) Color.parseColor("#ff0000")
                else Color.parseColor("#0000ff"))
//                .setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            // TODO сделать плашки квадратными
//            holder.die.layoutParams.height = holder.die.width
//            holder.die.maxHeight = holder.die.width
        }

        override fun getItemCount(): Int {
            return counter
        }
    }

    fun createDie() {
        counter++
        // TODO сделать добавление плашек
//        customRecyclerAdapter.notifyDataSetChanged()
//        println(counter)
    }
}