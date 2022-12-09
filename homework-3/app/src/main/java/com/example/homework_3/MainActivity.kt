package com.example.homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val button_product = findViewById<Button>(R.id.button_product)
        val button_search = findViewById<Button>(R.id.button_search)
        val button_profile = findViewById<Button>(R.id.button_profile)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragment_main, ProductFragment()).commit()
        }

        button_product.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_main, ProductFragment()).commit()
        }
        button_search.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_main, SearchFragment()).commit()
        }
        button_profile.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_main, ProfileFragment()).commit()
        }
    }
}