package com.example.tugas4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    private lateinit var tvDetailTitle: TextView
    private lateinit var tvDetailBody: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val postId = intent.getIntExtra("POST_ID", 1)

        tvDetailTitle = findViewById(R.id.tvDetailTitle)
        tvDetailBody = findViewById(R.id.tvDetailBody)

        RetrofitClient.instance.getPostById(postId).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    val post = response.body()!!
                    tvDetailTitle.text = post.title
                    tvDetailBody.text = post.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                tvDetailTitle.text = "Error"
                tvDetailBody.text = t.localizedMessage
            }
        })
    }
}