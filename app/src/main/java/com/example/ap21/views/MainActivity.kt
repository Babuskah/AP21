package com.example.ap21.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.ap21.R
import com.example.ap21.viewmodels.MovieViewModel
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private val viewModel: MovieViewModel by viewModels()

    private lateinit var releasedate: TextView
    private lateinit var title: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        releasedate = findViewById(R.id.release_date_tv)
        title = findViewById(R.id.title_tv)

        viewModel.movie.observe(this, { movieString -> releasedate.post { releasedate.text =
            movieString.toString() }})

        title.let {viewModel.movie.observe(this, { titleString -> title.post { title.text =
            titleString.toString()}})}

    }


}