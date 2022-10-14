package com.example.homework_1

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkFragment : Fragment() {
    private val NUM_OF_ELEMENTS = "NumOfElements"
    private var counter: Int = 4

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

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
        myAdapter = MyAdapter(counter)
        recyclerView.adapter = myAdapter
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

    fun createDie() {
        counter++
        // TODO сделать добавление плашек
//        customRecyclerAdapter.notifyDataSetChanged()
    }
}