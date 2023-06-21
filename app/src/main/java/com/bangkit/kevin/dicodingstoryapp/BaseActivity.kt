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
            // Handle bottom navigation item selection
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    // Handle Home item click
                    onNavigationHomeSelected()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_addstory -> {
                    // Handle Dashboard item click
                    onNavigationAddStorySelected()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    // Handle Profile item click
                    onNavigationProfileSelected()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    // Abstract methods to be implemented by child activities
    abstract fun onNavigationHomeSelected()
    abstract fun onNavigationAddStorySelected()
    abstract fun onNavigationProfileSelected()
}
