package com.example.homework_1

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkFragment : Fragment() {
    private lateinit var diesViewModel: DiesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diesViewModel = ViewModelProvider(
            requireActivity(),
            SavedStateViewModelFactory()
        )[DiesViewModel::class.java]

        recyclerView = view.findViewById(R.id.recyclerView)
        myAdapter = MyAdapter() { die ->
            parentFragmentManager.beginTransaction().replace(R.id.container, NewFrag.newInstance(die)).addToBackStack(null).commit()
        }
        recyclerView.adapter = myAdapter

        diesViewModel.dies.observe(viewLifecycleOwner) { item ->
            myAdapter.changeData(item)
            myAdapter.notifyDataSetChanged()
        }

        val columnCount = resources.getInteger(R.integer.column_count)
        recyclerView.layoutManager = GridLayoutManager(view.context, columnCount)
//        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            recyclerView.layoutManager = GridLayoutManager(view.context, 3)
//        } else {
//            recyclerView.layoutManager = GridLayoutManager(view.context, 4)
//        }
    }
}
