package com.bangkit.kevin.dicodingstoryapp

import android.content.Intent
import android.os.Bundle

class AddStoryActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)
    }

    override fun onNavigationHomeSelected() {
        // Handle Home item click
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onNavigationAddStorySelected() {
        // Already on Home screen

    }

    override fun onNavigationProfileSelected() {
        // Handle Profile item click
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }
}
