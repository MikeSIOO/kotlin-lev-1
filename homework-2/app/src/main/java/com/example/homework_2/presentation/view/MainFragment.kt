package com.example.homework_2.presentation.view

import android.os.Bundle
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
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.homework_2.presentation.viewmodel.MyViewModel
import com.example.homework_2.R
import com.example.homework_2.StatusLoad

class MainFragment : Fragment() {
    private lateinit var myViewModel: MyViewModel

    private lateinit var myAdapter: MyAdapter


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

        myAdapter = MyAdapter() {
            parentFragmentManager.beginTransaction().replace(R.id.container, ImageFragment.newInstance(it)).addToBackStack(null).commit()
        }

        val stub = view.findViewById<TextView>(R.id.stub)
        val load = view.findViewById<ProgressBar>(R.id.load)
        view.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = myAdapter
        }

        myViewModel.items.observe(viewLifecycleOwner) {
            myAdapter.refreshList(it)
            myAdapter.notifyDataSetChanged()
        }

        myViewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                StatusLoad.LOADING -> {
                    load.isVisible = true
                    stub.isVisible = false
                    stub.setOnClickListener(null)
                }
                StatusLoad.SUCCESS -> {
                    load.isVisible = false
                    stub.isVisible = false
                    stub.setOnClickListener(null)
                }
                StatusLoad.ERROR -> {
                    load.isVisible = false
                    stub.isVisible = true
                    stub.setOnClickListener {
                        myViewModel.refreshItems()
                    }
                }
            }
        }
    }
}