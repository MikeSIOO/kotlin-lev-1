package com.example.homework_3.Profile

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_3.ProfileData
import com.example.homework_3.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment(R.layout.fragment_profile) {
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
                    ProfileData.getData()
                }
                load.isVisible = false
                stub.isVisible = false
                recycler.isVisible = true

                val myAdapter = ProfileDataAdapter(
                    data
                ) {
                    findNavController().navigate(R.id.action_profileFragment_to_recipeFragment)
                }
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