package com.example.myappcleanarchitecture.domain.repository

import com.example.myappcleanarchitecture.data.models.MovieFeatures

interface MoviesRepository {

    fun getMovies(): List<MovieFeatures>
}