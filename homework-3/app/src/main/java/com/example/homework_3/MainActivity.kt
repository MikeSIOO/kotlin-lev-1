package com.example.homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val buttonProduct = findViewById<Button>(R.id.button_product)
        val buttonSearch = findViewById<Button>(R.id.button_search)
        val buttonProfile = findViewById<Button>(R.id.button_profile)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragment_main, ProductFragment())
                .commit()
        }

        buttonProduct.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_main, ProductFragment())
                .commit()
        }
        buttonSearch.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_main, SearchFragment())
                .commit()
        }
        buttonProfile.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_main, ProfileFragment())
                .commit()
        }
    }
}