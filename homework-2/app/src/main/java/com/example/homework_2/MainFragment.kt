package com.example.homework_2

import MyViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment() {

    private val viewModel by viewModels<MyViewModel>()

    private val myAdapter = MyAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
        }

        val stub = view.findViewById<TextView>(R.id.stub)
        val load = view.findViewById<TextView>(R.id.load)


        viewLifecycleOwner.lifecycleScope.launch {
            load.isVisible = true
            stub.isVisible = false
            stub.setOnClickListener(null)

            try {
                val list = withContext(Dispatchers.IO) { viewModel.getItems() }
                myAdapter.submitList(list)

                load.isVisible = false
                stub.isVisible = false
                stub.setOnClickListener(null)
            } catch (error: Throwable) {
                load.isVisible = false
                stub.isVisible = true
                error.printStackTrace()
                stub.setOnClickListener {
                    // TODO reconnect
                }
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}