package com.example.homework_1

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkFragment : Fragment() {
    private val myViewModel: MyViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView: View = inflater.inflate(R.layout.fragment_work, container, false)

        recyclerView = myView.findViewById(R.id.recyclerView)
        myAdapter = MyAdapter(myViewModel.list.value) // положил в адаптер
//        myAdapter = MyAdapter(myViewModel.getDies().value) // положил в адаптер
        recyclerView.adapter = myAdapter

        val nameObserver = Observer<ArrayList<Die>> { items -> // отслеживаю изменения
            myAdapter.addAll(items)
            myAdapter.notifyDataSetChanged() // отрисовываю изменения
        }
        myViewModel.list.observe(viewLifecycleOwner, nameObserver)
//        myViewModel.getDies().observe(viewLifecycleOwner, nameObserver)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(myView.context, 3)
        } else {
            recyclerView.layoutManager = GridLayoutManager(myView.context, 4)
        }

        return myView
    }
}
