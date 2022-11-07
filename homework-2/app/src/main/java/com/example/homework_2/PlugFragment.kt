package com.example.homework_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

// Фрагмент для показа заглушки для подзагрузки данных
class PlugFragment : Fragment() {
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

//        diesViewModel = ViewModelProvider(
//            requireActivity(),
//            SavedStateViewModelFactory()
//        )[DiesViewModel::class.java]

        button = view.findViewById(R.id.button)
        button.setOnClickListener {
//            diesViewModel.addDie(
//                ContextCompat.getColor(requireView().context, R.color.red),
//                ContextCompat.getColor(requireView().context, R.color.blue)
//            )
        }
    }
}