package com.example.homework_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

class MainActivity : AppCompatActivity(), OnButtonListener {
    private val COUNT = "NumOfElements"
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val workFragment: WorkFragment? = fragmentManager.findFragmentById(R.id.fragment_work) as WorkFragment?
        workFragment?.changeOrientation(resources.configuration.orientation)
    }

    override fun onButton() {
        counter++
        val fragmentManager = supportFragmentManager
        var workFragment: WorkFragment? = fragmentManager.findFragmentById(R.id.fragment_work) as WorkFragment?
        workFragment?.createDie(counter)
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT, counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore count value
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(COUNT)
    }
}