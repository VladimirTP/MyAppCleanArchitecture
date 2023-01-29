package com.example.myappcleanarchitecture.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myappcleanarchitecture.R
import com.example.myappcleanarchitecture.data.models.MovieFeatures

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun onBind(movie: MovieFeatures) {
        val poster = itemView.findViewById<ImageView>(R.id.iv_poster)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val oscar = itemView.findViewById<ImageView>(R.id.iv_is_oscar)
        val rating = itemView.findViewById<TextView>(R.id.tv_rating)

        name.text = movie.name
        oscar.isVisible = movie.isOscar == true
        rating.text = movie.rating.toString()

        Glide
            .with(itemView.context)
            .load(movie.imageStr)
            .into(poster)
    }
}