package com.example.homework_3

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SearchFragment : Fragment(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.likeButton).setOnClickListener{
            findNavController().navigate(R.id.action_searchFragment_to_recipeFragment)
        }

        view.findViewById<Button>(R.id.filterButton).setOnClickListener{
            findNavController().navigate(R.id.action_searchFragment_to_filterFragment)
        }
    }
}