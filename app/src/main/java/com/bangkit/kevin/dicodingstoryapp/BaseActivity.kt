package com.bangkit.kevin.dicodingstoryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    onNavigationHomeSelected()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_addstory -> {
                    onNavigationAddStorySelected()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    onNavigationProfileSelected()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    abstract fun onNavigationHomeSelected()
    abstract fun onNavigationAddStorySelected()
    abstract fun onNavigationProfileSelected()
}
