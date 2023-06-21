package com.bangkit.kevin.dicodingstoryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: StoryAdapter
//    private lateinit var storyApiService: StoryApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

//        // Create Retrofit instance
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://story-api.dicoding.dev/v1/")
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//            .build()
//
//        // Create API service
//        storyApiService = retrofit.create(StoryApiService::class.java)
//
//        // Fetch story list data
//        fetchStoryList()
    }

//    private fun fetchStoryList() {
//        val call = storyApiService.getStories()
//        call.enqueue(object : Callback<List<Story>> {
//            override fun onResponse(call: Call<List<Story>>, response: Response<List<Story>>) {
//                if (response.isSuccessful) {
//                    val storyList = response.body()
//                    storyList?.let {
//                        adapter = StoryAdapter(it)
//                        recyclerView.adapter = adapter
//                    }
//                } else {
//                    // Request failed
//                    // Handle error or display an appropriate message
//                }
//            }
//
//            override fun onFailure(call: Call<List<Story>>, t: Throwable) {
//                // Network request failed
//                // Handle error or display an appropriate message
//            }
//        })
//    }
}
