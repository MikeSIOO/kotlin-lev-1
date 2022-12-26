package com.example.homework_3.Filter

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework_3.R

class FilterFragment : Fragment(R.layout.fragment_filter) {
    private lateinit var backButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backButton = view.findViewById(R.id.backButton)

        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}