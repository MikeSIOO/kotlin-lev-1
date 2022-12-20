package com.example.homework_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        navController = Navigation.findNavController(this, R.id.navHostFragment)
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener {
            navController.navigate(it.itemId)
            true
        }

        if (savedInstanceState == null) {
            navController.navigate(R.id.productFragment)
            // TODO не отрабатывает бэкстэк меню
            bottomNav.selectedItemId = R.id.searchFragment
        }
    }
}