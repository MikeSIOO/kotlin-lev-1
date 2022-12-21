package com.example.homework_3

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductFragment : Fragment(R.layout.fragment_product) {
    private lateinit var stub: TextView
    private lateinit var load: ProgressBar
    private lateinit var recycler: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stub = view.findViewById(R.id.stub)
        load = view.findViewById(R.id.load)
        recycler = view.findViewById(R.id.recycler)

        loadData()
    }

    private fun loadData() {
        lifecycleScope.launch {
            load.isVisible = true
            stub.isVisible = false
            recycler.isVisible = false
            try {
                val data = withContext(Dispatchers.IO) {
                    ProductCategories.getProducts()
                }
                load.isVisible = false
                stub.isVisible = false
                recycler.isVisible = true

                val myAdapter = MyAdapter(data)
                recycler.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = myAdapter
                }
            } catch (error: Throwable) {
                load.isVisible = false
                stub.isVisible = true
                recycler.isVisible = false
            }
        }
    }
}