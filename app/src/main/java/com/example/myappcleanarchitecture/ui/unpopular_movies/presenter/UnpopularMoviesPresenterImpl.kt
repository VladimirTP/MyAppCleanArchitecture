package com.example.myappcleanarchitecture.ui.unpopular_movies.presenter

import com.example.myappcleanarchitecture.domain.GetUnpopularMoviesUseCase
import com.example.myappcleanarchitecture.ui.unpopular_movies.UnpopularMoviesView

class UnpopularMoviesPresenterImpl(private var view: UnpopularMoviesView?): UnpopularMoviesPresenter {

    private val useCase = GetUnpopularMoviesUseCase()

    override fun getUnpopularMovies() {
        view?.showUnpopularMovies(useCase())
    }

    override fun onClear() {
        view = null
    }
}