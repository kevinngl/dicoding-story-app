package com.bangkit.kevin.dicodingstoryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class AddStoryActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)
    }

    override fun onNavigationHomeSelected() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onNavigationAddStorySelected() {
        AlertDialog.Builder(this)
            .setTitle("Add To Story")
            .setMessage("You are already in the Add To Story screen.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun onNavigationProfileSelected() {
        // Handle Profile item click
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }
}
