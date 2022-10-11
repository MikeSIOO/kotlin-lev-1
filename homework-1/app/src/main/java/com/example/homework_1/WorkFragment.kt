package com.example.homework_1

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class WorkFragment : Fragment() {
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.text)
    }

    fun createDie(counter: Int) {
        textView.text = counter.toString()
        // TODO сделать добавление плашек
    }

    fun changeOrientation(orient: Int) {
        textView.text = if (orient == Configuration.ORIENTATION_PORTRAIT) "Port" else "Land"
    }
}