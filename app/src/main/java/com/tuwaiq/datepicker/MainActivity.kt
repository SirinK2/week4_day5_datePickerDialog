package com.tuwaiq.datepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = DateFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container,fragment)
            .commit()
    }
}