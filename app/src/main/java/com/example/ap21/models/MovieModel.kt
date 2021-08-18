package com.example.ap21.models

import com.google.gson.annotations.SerializedName

data class MovieModel (
    @SerializedName("vote_count")
    val vote_count: Int,
    @SerializedName("movie_overview")
    val movie_overview: String,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("title")
    val title: String
)