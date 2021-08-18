package com.example.ap21.viewmodels

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
                _movie.postValue(movie)
                delay(10)
            }
        }
    }
}

