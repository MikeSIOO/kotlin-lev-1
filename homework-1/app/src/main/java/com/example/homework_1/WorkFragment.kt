package com.example.homework_1

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager

class WorkFragment : Fragment() {
    private lateinit var textView: TextView
//    private lateinit var gridLayoutManager: GridLayoutManager

    private val COUNT = "NumOfElements"
    private var counter: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // TODO вертикальная ориентация
//            gridLayoutManager.setLayoutManager(GridLayoutManager(context,3))
        } else {
            // TODO горизонтальная ориентация
//            gridLayoutManager.setLayoutManager(GridLayoutManager(context, 4))
        }
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.textView)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT, counter)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNT)
        }
        textView.text = counter.toString()
    }

    fun createDie() {
        counter++
        textView.text = counter.toString() // TODO сделать добавление плашек
    }
}