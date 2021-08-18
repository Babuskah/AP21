package com.example.ap21.views

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ap21.R
import com.example.ap21.viewmodels.MovieViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MovieViewModel by viewModels()

    private lateinit var releasedate: TextView
    private lateinit var title: TextView
    private lateinit var overview: TextView
    private lateinit var averageRate: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        releasedate = findViewById(R.id.release_date_tv)
        title = findViewById(R.id.title_tv)
        overview = findViewById(R.id.overview_tv)
        averageRate = findViewById(R.id.rating_tv)


        viewModel.release.observe(this, { movieString -> releasedate.post { releasedate.text =
            movieString.toString() }})

        viewModel.overview.observe(this, { movieString -> overview.post { overview.text =
            movieString.toString() }})

        viewModel.title.observe(this, { movieString -> title.post { title.text =
            movieString.toString() }})

        viewModel.average.observe(this, { movieString -> averageRate.post { averageRate.text =
            movieString.toString() }})



    }


}