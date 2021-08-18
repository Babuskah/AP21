package com.example.ap21.repository

import com.example.ap21.models.MovieModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response

interface MovieAPI {
        @GET("movie/{movie_id}?api_key=2071f6a2d4e5b508890ea8eed040a1a6&append_to_response=watch/providers")
        suspend fun fetchMovie(@Path("movie_id") id: Int): Response<MovieModel>

        @GET("search/movie?api_key=2071f6a2d4e5b508890ea8eed040a1a6")
        suspend fun fetchSearch(@Query("movie_search") search: String): Response<MovieModel>

    }