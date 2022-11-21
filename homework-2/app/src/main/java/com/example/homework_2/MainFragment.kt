package com.example.homework_2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {
    private lateinit var myViewModel: MyViewModel

    private val myAdapter = MyAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(
            requireActivity(),
            SavedStateViewModelFactory()
        )[MyViewModel::class.java]

        val stub = view.findViewById<TextView>(R.id.stub)
        val load = view.findViewById<ProgressBar>(R.id.load)
        view.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
        }

        myViewModel.items.observe(viewLifecycleOwner) { item ->
            myAdapter.refreshList(item)
            myAdapter.notifyDataSetChanged()
        }

        myViewModel.status.observe(viewLifecycleOwner) { item ->
            when (item) {
                R.integer.loading -> {
                    load.isVisible = true
                    stub.isVisible = false
                    stub.setOnClickListener(null)
                }
                R.integer.succsess -> {
                    load.isVisible = false
                    stub.isVisible = false
                    stub.setOnClickListener(null)
                }
                R.integer.error -> {
                    load.isVisible = false
                    stub.isVisible = true
                    stub.setOnClickListener { onViewCreated(view, savedInstanceState) }
                }
            }
        }

        // TODO pagination
//        val page = 1
//        myViewModel.getItems(resources.getInteger(R.integer.limit),
//            (page - 1) * resources.getInteger(R.integer.limit))
    }
}