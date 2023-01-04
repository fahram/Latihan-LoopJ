package com.fahram.internetlibrarysampleloopj

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahram.internetlibrarysampleloopj.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url = "https://fahram.dev/api/v2/courses"
        val client = AsyncHttpClient()
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                val myString = String(responseBody)
                val response = JSONObject(myString)
                val data = response.getJSONArray("data")

                var courses = ArrayList<Course>()
                for (i in 0 until data.length()){
                    val crs = data.getJSONObject(i)
                    val title = crs.getString("title")
                    val path = crs.getString("path")
                    val image = crs.getString("image")
                    val course = Course(title,path,image)
                    courses.add(course)
                }

                binding.rvCourse.adapter = CourseAdapter(courses){
                    course ->  showDetail(course)
                }
                binding.rvCourse.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {

            }
        })
    }

    private fun showDetail(course: Course) {
        startActivity(
            Intent(this@MainActivity, DetailActivity::class.java).putExtra("COURSE", course)
        )
    }
}