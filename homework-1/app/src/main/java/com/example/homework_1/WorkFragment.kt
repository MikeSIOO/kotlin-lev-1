package com.example.homework_1

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkFragment : Fragment() {
    private lateinit var myViewModel: MyViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(requireActivity(), SavedStateViewModelFactory())[MyViewModel::class.java]

        recyclerView = view.findViewById(R.id.recyclerView)
        myAdapter = MyAdapter(myViewModel.list.value) // положил в адаптер
        recyclerView.adapter = myAdapter

        val nameObserver = Observer<ArrayList<Die>> { _ -> // отслеживаю изменения
            myAdapter = MyAdapter(myViewModel.list.value) // положил в адаптер
            recyclerView.adapter = myAdapter

            myAdapter.notifyDataSetChanged() // отрисовываю изменения
        }
        myViewModel.list.observe(viewLifecycleOwner, nameObserver)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(view.context, 3)
        } else {
            recyclerView.layoutManager = GridLayoutManager(view.context, 4)
        }
    }
}
