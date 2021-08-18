package com.example.ap21.models

class PopularMovieModel (
    val page: Int,
    val results: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
)