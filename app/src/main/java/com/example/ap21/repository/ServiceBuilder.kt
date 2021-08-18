package com.example.ap21.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder {

    private val url = APICreds.BASE_URL
    private var retrofit: Retrofit = Retrofit.Builder().baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create()).build()

    private var movieAPI: MovieAPI = retrofit.create(MovieAPI::class.java)

    fun getMovieAPI(): MovieAPI {
        return movieAPI
    }

}