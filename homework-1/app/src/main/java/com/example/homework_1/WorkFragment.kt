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
import androidx.recyclerview.widget.RecyclerView

class WorkFragment : Fragment() {
    private val NUM_OF_ELEMENTS = "NumOfElements"
    private var counter: Int = 1

    private lateinit var recyclerView: RecyclerView
    private lateinit var customRecyclerAdapter: CustomRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(NUM_OF_ELEMENTS)
        }
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        customRecyclerAdapter = CustomRecyclerAdapter(counter)
        recyclerView.adapter = customRecyclerAdapter
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(view.context, 3)
        } else {
            recyclerView.layoutManager = GridLayoutManager(view.context, 4)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NUM_OF_ELEMENTS, counter)
    }

    class CustomRecyclerAdapter(private val count: Int) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
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
                if (position % 2 != 0) Color.RED else Color.BLUE)
//                .setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        }

        override fun getItemCount(): Int {
            return count
        }
    }

    fun createDie() {
        counter++
        // TODO сделать добавление плашек
//        customRecyclerAdapter.notifyDataSetChanged()
    }
}