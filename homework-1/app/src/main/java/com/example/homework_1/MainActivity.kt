package com.example.homework_1

import androidx.appcompat.app.AppCompatActivity

//class MainActivity : AppCompatActivity(R.layout.activity_main) {
class MainActivity : AppCompatActivity(R.layout.activity_main), OnButtonListener {
    override fun onButton() {
        val fragmentManager = supportFragmentManager
        var workFragment: WorkFragment? = fragmentManager.findFragmentById(R.id.fragment_work) as WorkFragment?
        workFragment?.createDie()
    }
}