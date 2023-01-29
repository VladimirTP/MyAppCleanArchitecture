package com.example.myappcleanarchitecture.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappcleanarchitecture.R
import com.example.myappcleanarchitecture.data.models.MovieFeatures

class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    private val list: MutableList<MovieFeatures> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<MovieFeatures>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}