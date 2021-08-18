package com.example.ap21.viewmodels

import android.text.Html
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ap21.models.MovieModel
import com.example.ap21.repository.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private lateinit var job: Job
    @Volatile
    private var running = true
    private val movieService = ServiceBuilder().getMovieAPI()
    private val _movie = MutableLiveData<Response<MovieModel>>()
    val movie: LiveData<Response<MovieModel>>
        get() = _movie

        private val _title = MutableLiveData<String>()
        val title: LiveData<String>
            get() = _title

        private val _overview = MutableLiveData<String>()
        val overview: LiveData<String>
            get() = _overview

        private val _release = MutableLiveData<String>()
        val release: LiveData<String>
            get() = _release

        private val _average = MutableLiveData<String>()
        val average: LiveData<String>
            get() = _average


    val movieid = 157336


    override fun onCleared() {
        running = false
        super.onCleared()
        job.cancel()
    }


    init {
        updateMovie()

    }

    fun updateMovie() {
        viewModelScope.launch(Dispatchers.IO) {
            while(running) {
                val movie = movieService.fetchMovie(movieid)
                val movieRelease = Html.fromHtml(movie.body()!!.release_date!!).toString()
                val movieTitle = Html.fromHtml(movie.body()!!.title!!).toString()
                val movieOverview = Html.fromHtml(movie.body()!!.movie_overview!!).toString()
                val movieAverage = Html.fromHtml(movie.body()!!.vote_average!!.toString()).toString()

                _release.postValue(movieRelease)
                _title.postValue(movieTitle)
                _overview.postValue(movieOverview)
                _average.postValue(movieAverage)
                _movie.postValue(movie)
                delay(50)
            }
        }
    }
}

