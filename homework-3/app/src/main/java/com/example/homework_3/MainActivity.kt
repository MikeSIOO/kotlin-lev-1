package com.example.homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.productFragment -> {
                    ProductFragment()
                }
                R.id.profileFragment -> {
                    ProfileFragment()
                }
                else -> {
                    SearchFragment()
                }
            }
            loadFragment(fragment)
        }

        if (savedInstanceState == null) {
            loadFragment(SearchFragment())
            bottomNav.selectedItemId = R.id.searchFragment
        }
    }

    private fun loadFragment(fragment: Fragment) : Boolean {
        // TODO бэкстэк
        supportFragmentManager.beginTransaction().replace(R.id.fragment_main, fragment).commit()
        return true
    }
}