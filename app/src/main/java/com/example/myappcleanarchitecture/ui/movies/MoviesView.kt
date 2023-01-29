package com.example.myappcleanarchitecture.ui.movies

import com.example.myappcleanarchitecture.data.models.MovieFeatures

interface MoviesView {

    fun showMovies(movieList: List<MovieFeatures>)
}