package com.bangkit.kevin.dicodingstoryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class ProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    override fun onNavigationHomeSelected() {
        // Handle Home item click
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onNavigationAddStorySelected() {
        // Handle Add to Story item click
        startActivity(Intent(this, AddStoryActivity::class.java))
        finish()
    }

    override fun onNavigationProfileSelected() {
        AlertDialog.Builder(this)
            .setTitle("Profile")
            .setMessage("You are already in the Profile screen.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}