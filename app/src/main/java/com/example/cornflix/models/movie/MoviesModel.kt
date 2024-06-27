package com.example.cornflix.models.movie

import com.example.cornflix.models.MediaModel
import com.google.gson.annotations.SerializedName

data class MoviesModel(
    @SerializedName("id")
    var idMovie: String,
    @SerializedName("original_title")
    var nameMovie: String,
    @SerializedName("overview")
    var descriptionMovie: String,
    @SerializedName("poster_path")
    var posterMovie: String,
    @SerializedName("release_date")
    var releaseDateMovie: String,
    @SerializedName("vote_average")
    var voteAverageMovie: String,
)

/*
data class MoviesModel(
    @SerializedName("id")
    var idMovie: String,
    @SerializedName("original_title")
    var nameMovie: String,
    @SerializedName("overview")
    var descriptionMovie: String,
    @SerializedName("poster_path")
    var posterMovie: String,
    @SerializedName("release_date")
    var releaseDateMovie: String,
    @SerializedName("vote_average")
    var voteAverageMovie: String,
) : MediaModel by object : MediaModel {
    override val id: String
        get() = idMovie
    override val name: String
        get() = nameMovie
    override val description: String
        get() = descriptionMovie
    override val poster: String
        get() = posterMovie
    override val releaseDate: String
        get() = releaseDateMovie
    override val voteAverage: String
        get() = voteAverageMovie
}

 */