package com.fahram.internetlibrarysampleloopj

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.fahram.internetlibrarysampleloopj.databinding.ItemCourseBinding

class CourseAdapter(
    var courses : ArrayList<Course>,
    val onClickItem : (Course) -> Unit
) : RecyclerView.Adapter<CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.binding.tvTitle.text = courses[position].title
        holder.binding.tvPath.text = courses[position].path
        holder.binding.imageView.load(courses[position].image)
        holder.binding.root.setOnClickListener{
            onClickItem(courses[position])
        }
    }

    override fun getItemCount(): Int = courses.size

}