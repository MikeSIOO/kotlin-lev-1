package com.example.homework_1

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkFragment : Fragment() {
    private val ELEMENTS = "Elements"
    private var dies: ArrayList<Die> = ArrayList()

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (savedInstanceState != null) {
//            dies = savedInstanceState.getParcelableArrayList(ELEMENTS)!!
            dies = savedInstanceState.getSerializable(ELEMENTS) as ArrayList<Die>
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
//        outState.putParcelableArrayList(ELEMENTS, dies)
        outState.putSerializable(ELEMENTS, dies)
    }

    fun createDie() {
        dies.add(Die(
            if (dies.size % 2 != 0) {
                ContextCompat.getColor(requireView().context, R.color.red)
            } else {
                ContextCompat.getColor(requireView().context, R.color.blue)
            }))
        myAdapter.notifyDataSetChanged()
    }
}
