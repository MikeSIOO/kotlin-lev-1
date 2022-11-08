package com.example.homework_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider

// Фрагмент для показа заглушки для подзагрузки данных
class PlugFragment : Fragment() {
    private lateinit var dataViewModel: DataViewModel
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_plug, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataViewModel = ViewModelProvider(requireActivity())[DataViewModel::class.java]

        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            dataViewModel.newPage()
        }
    }
}