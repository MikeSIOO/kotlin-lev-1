package com.example.homework_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.data_fragment, DataFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.load_fragment, LoadFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.plug_fragment, PlugFragment()).commit()
    }
}