package com.example.myappcleanarchitecture.ui.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappcleanarchitecture.R
import com.example.myappcleanarchitecture.data.models.MovieFeatures
import com.example.myappcleanarchitecture.ui.MovieAdapter
import com.example.myappcleanarchitecture.ui.movies.presenter.MoviesPresenter
import com.example.myappcleanarchitecture.ui.movies.presenter.MoviesPresenterImpl
import com.example.myappcleanarchitecture.ui.unpopular_movies.UnpopularMoviesActivity

class MainActivity: AppCompatActivity(), MoviesView {

    private var adapter: MovieAdapter? = null
    private var presenter: MoviesPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.rv_movie_list)
        adapter = MovieAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        presenter = MoviesPresenterImpl(this)
        presenter?.getMovies()

        val buttonLowRating = findViewById<Button>(R.id.bt_low_rating)
        buttonLowRating.setOnClickListener {
            val intent = Intent(this, UnpopularMoviesActivity::class.java)
            startActivity(intent)
        }
    }

    override fun showMovies(movieList: List<MovieFeatures>) {
        adapter?.setItems(movieList)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onClear()
    }
}