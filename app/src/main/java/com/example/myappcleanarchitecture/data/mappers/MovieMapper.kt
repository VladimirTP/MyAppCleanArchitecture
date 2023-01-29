package com.example.myappcleanarchitecture.data.mappers

import com.example.myappcleanarchitecture.data.models.MovieFeatures

class MovieMapper {
    operator fun invoke(feature: MovieFeatures) = with(feature) {
        MovieFeatures(
            imageStr = imageStr ?: "",
            name = name ?: "",
            isOscar = isOscar ?: false,
            rating = rating ?: 0.0
        )
    }
}