package com.example.homework_1

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkFragment : Fragment() {
    // TODO сделать добавление в память
//    private val NUM_OF_ELEMENTS = "NumOfElements"
//    private var counter: Int = 0
    private var dies: MutableList<Die> = mutableListOf()

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (savedInstanceState != null) {
//            dies = savedInstanceState.getParcelableArrayList(NUM_OF_ELEMENTS)!!
//            counter = savedInstanceState.getInt(NUM_OF_ELEMENTS)
        }
        val myView: View = inflater.inflate(R.layout.fragment_work, container, false)
        recyclerView = myView.findViewById(R.id.recyclerView)
        myAdapter = MyAdapter(dies)
        recyclerView.adapter = myAdapter
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(myView.context, 3)
        } else {
            recyclerView.layoutManager = GridLayoutManager(myView.context, 4)
        }
        return myView
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState.putParcelableArrayList(NUM_OF_ELEMENTS, dies)
//        outState.putInt(NUM_OF_ELEMENTS, counter)
    }

    fun createDie() {
        // TODO брать цвета из ресурсов
        dies.add(Die(if (dies.size % 2 != 0) Color.RED else Color.BLUE))
        myAdapter.notifyDataSetChanged()
    }
}
