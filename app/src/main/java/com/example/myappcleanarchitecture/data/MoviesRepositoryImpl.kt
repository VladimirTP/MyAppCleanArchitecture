package com.example.myappcleanarchitecture.data

import com.example.myappcleanarchitecture.Server
import com.example.myappcleanarchitecture.data.mappers.MovieMapper
import com.example.myappcleanarchitecture.data.models.MovieFeatures
import com.example.myappcleanarchitecture.domain.repository.MoviesRepository

class MoviesRepositoryImpl: MoviesRepository {
    val mapper = MovieMapper()
    override fun getMovies(): List<MovieFeatures> = Server.getMovie().map { mapper(it) }
}