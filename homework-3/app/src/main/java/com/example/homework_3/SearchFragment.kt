package com.example.homework_3

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var likeButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        likeButton = view.findViewById(R.id.likeButton)

        likeButton.setOnClickListener{
            findNavController().navigate(R.id.action_searchFragment_to_recipeFragment)
        }
    }
}