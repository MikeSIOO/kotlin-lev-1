package com.example.homework_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Фрагмент для показа данных
class DataFragment :Fragment() {
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var myAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        recyclerView = view.findViewById(R.id.recyclerView)
//        myAdapter = MyAdapter { die ->
//            parentFragmentManager.beginTransaction().replace(R.id.container, NewFrag.newInstance(die)).addToBackStack(null).commit()
//        }
//        recyclerView.adapter = myAdapter

//        diesViewModel.dies.observe(viewLifecycleOwner) { item ->
//            myAdapter.changeData(item)
//            myAdapter.notifyDataSetChanged()
//        }

//        recyclerView.layoutManager = LinearLayoutManager(view.context)
    }
}