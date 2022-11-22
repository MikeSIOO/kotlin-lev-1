package com.example.homework_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_2.presentation.view.MainFragment

// TODO Сделать КЭШ
// datastore 15
// sqllite 1.05
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.container, MainFragment()).commit()
        }
    }
}