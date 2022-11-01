package com.example.homework_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider

class ButtonFragment : Fragment() {
    private lateinit var diesViewModel: DiesViewModel
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diesViewModel = ViewModelProvider(
            requireActivity(),
            SavedStateViewModelFactory()
        )[DiesViewModel::class.java]

        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            diesViewModel.addDie(
                ContextCompat.getColor(requireView().context, R.color.red),
                ContextCompat.getColor(requireView().context, R.color.blue)
            )
        }
    }
}
