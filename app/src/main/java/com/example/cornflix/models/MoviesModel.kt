package com.example.cornflix.models

import com.google.gson.annotations.SerializedName

data class MoviesModel(
    @SerializedName("id")
    var id: String,
    @SerializedName("original_title")
    var name: String,
    @SerializedName("overview")
    var description: String,
    @SerializedName("poster_path")
    var poster: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("vote_average")
    var voteAverage: String,
)