package com.example.homework_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnButtonListener {
    var counter : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButton() {
        counter++

        val fragmentManager = supportFragmentManager

        val workFragment = fragmentManager.findFragmentById(R.id.fragment_work) as WorkFragment?
        workFragment?.createDie(counter)
    }
}