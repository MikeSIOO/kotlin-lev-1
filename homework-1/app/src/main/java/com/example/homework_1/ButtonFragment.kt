package com.example.homework_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

interface OnButtonListener {
    fun onButton()
}

//class ButtonFragment : Fragment() {
class ButtonFragment : Fragment(), View.OnClickListener {
//    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener(this)
//        button = view.findViewById(R.id.button)
//        button.setOnClickListener()
    }

    override fun onClick(v: View?) {
        val listener = activity as OnButtonListener?
        listener?.onButton()
    }
}

//private fun Button.setOnClickListener() {
//    TODO("Not yet implemented")
//}
