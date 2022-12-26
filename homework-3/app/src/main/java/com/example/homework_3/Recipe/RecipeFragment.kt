package com.example.homework_3.Recipe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework_3.R

class RecipeFragment : Fragment(R.layout.fragment_recipe) {
    private lateinit var backButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backButton = view.findViewById(R.id.backButton)

        backButton.setOnClickListener{
            findNavController().popBackStack()
        }
    }
}