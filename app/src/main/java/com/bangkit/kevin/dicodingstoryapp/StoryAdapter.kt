package com.bangkit.kevin.dicodingstoryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide

class StoryAdapter(private val storyList: List<Story>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = storyList[position]
        holder.bind(story)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    inner class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_detail_name)
        private val photoImageView: ImageView = itemView.findViewById(R.id.iv_detail_photo)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.tv_detail_description)

        fun bind(story: Story) {
            nameTextView.text = story.userName
            descriptionTextView.text = story.description

            // Load image using Glide or any other image loading library
            Glide.with(itemView.context)
                .load(story.photoUrl)
                .into(photoImageView)
        }
    }
}
