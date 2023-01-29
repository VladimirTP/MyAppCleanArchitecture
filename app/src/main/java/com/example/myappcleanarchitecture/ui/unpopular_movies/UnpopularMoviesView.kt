package com.example.myappcleanarchitecture.ui.unpopular_movies

import com.example.myappcleanarchitecture.data.models.MovieFeatures

interface UnpopularMoviesView {

    fun showUnpopularMovies(movies: List<MovieFeatures>)
}