package com.example.myappcleanarchitecture.domain

import com.example.myappcleanarchitecture.data.MoviesRepositoryImpl
import com.example.myappcleanarchitecture.data.models.MovieFeatures
import com.example.myappcleanarchitecture.domain.repository.MoviesRepository

class GetUnpopularMoviesUseCase {

    private val repository: MoviesRepository = MoviesRepositoryImpl()

    operator fun invoke(): List<MovieFeatures> = repository.getMovies()
        .filter { it.rating!! < UNPOPULAR_RATING }

    companion object {
        private const val UNPOPULAR_RATING = 7.5
    }
}