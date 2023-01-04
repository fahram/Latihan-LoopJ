package com.fahram.internetlibrarysampleloopj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.fahram.internetlibrarysampleloopj.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val course = intent.getParcelableExtra<Course>("COURSE")
        binding.tvDetailTitle.text = course?.title
        binding.ivDetailFoto.load(course?.image)
    }
}