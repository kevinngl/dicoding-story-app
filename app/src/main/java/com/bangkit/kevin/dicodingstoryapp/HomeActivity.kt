package com.bangkit.kevin.dicodingstoryapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : BaseActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StoryAdapter
    private lateinit var storyApiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Fetch story list data
        fetchStoryList()
    }

    override fun onNavigationHomeSelected() {
        // Display alert indicating already in Home screen
        AlertDialog.Builder(this)
            .setTitle("Home")
            .setMessage("You are already in the Home screen.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun onNavigationAddStorySelected() {
        // Start AddStoryActivity
        startActivity(Intent(this, AddStoryActivity::class.java))
    }

    override fun onNavigationProfileSelected() {
        // Start ProfileActivity
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }
    private fun retrieveTokenFromPreferences(): String? {
        val sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("userToken", null)
    }
    private fun fetchStoryList() {
        // Retrieve the token from shared preferences or other storage mechanism
        val token = retrieveTokenFromPreferences()

        // Initialize ApiService
        storyApiService = ApiClient.apiService

        val call = storyApiService.getAllStories("Bearer $token", null, null, null)

        call.enqueue(object : Callback<List<Story>> {
            override fun onResponse(call: Call<List<Story>>, response: Response<List<Story>>) {
                if (response.isSuccessful) {
                    val storyList = response.body()
                    storyList?.let {
                        adapter = StoryAdapter(it)
                        recyclerView.adapter = adapter
                    }
                } else {
                    // Request failed
                    // Handle error or display an appropriate message
                    Toast.makeText(this@HomeActivity, "Failed to fetch story list", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Story>>, t: Throwable) {
                // Network request failed
                // Handle error or display an appropriate message
                Toast.makeText(this@HomeActivity, "Network request failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

