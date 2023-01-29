package com.example.myappcleanarchitecture.ui.movies.presenter

import com.example.myappcleanarchitecture.data.MoviesRepositoryImpl
import com.example.myappcleanarchitecture.domain.repository.MoviesRepository
import com.example.myappcleanarchitecture.ui.movies.MoviesView

class MoviesPresenterImpl(private var view: MoviesView?): MoviesPresenter {

    private val repository: MoviesRepository = MoviesRepositoryImpl()

    override fun getMovies() {
        val movieList = repository.getMovies()
        view?.showMovies(movieList)
    }

    override fun onClear() {
        view = null
    }
}