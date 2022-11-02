package com.example.homework_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class NewFrag : Fragment() {
    private lateinit var textView: TextView
    private lateinit var background: View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val die = requireArguments().getParcelable<Die>(MY_KEY)!!
        view.findViewById<TextView>(R.id.textView).apply {
            text = die.num.toString()
            setBackgroundColor(die.color)
        }
    }

    companion object {
        const val MY_KEY = "KEY"
        fun newInstance(die: Die) : NewFrag {
            val extras = Bundle().apply {
                putParcelable(MY_KEY, die)
            }

            val fragment = NewFrag().apply {
                arguments = extras
            }

            return fragment
        }
    }
}