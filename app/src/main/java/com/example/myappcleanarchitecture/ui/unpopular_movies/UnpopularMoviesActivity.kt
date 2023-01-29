package com.example.myappcleanarchitecture.ui.unpopular_movies

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappcleanarchitecture.R
import com.example.myappcleanarchitecture.data.models.MovieFeatures
import com.example.myappcleanarchitecture.ui.MovieAdapter
import com.example.myappcleanarchitecture.ui.unpopular_movies.presenter.UnpopularMoviesPresenter
import com.example.myappcleanarchitecture.ui.unpopular_movies.presenter.UnpopularMoviesPresenterImpl

class UnpopularMoviesActivity : AppCompatActivity(), UnpopularMoviesView {

    private var adapter: MovieAdapter? = null
    private var presenter: UnpopularMoviesPresenter? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unpopular_movies)

        val recycler = findViewById<RecyclerView>(R.id.rv_low_rating_movies)
        adapter = MovieAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        presenter = UnpopularMoviesPresenterImpl(this)
        presenter?.getUnpopularMovies()
    }

    override fun showUnpopularMovies(movies: List<MovieFeatures>) {
        adapter?.setItems(movies)
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter?.onClear()
    }
}