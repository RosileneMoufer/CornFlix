package com.example.cornflix.model.movie

import com.example.cornflix.model.MediaModel
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") override val id: String,
    @SerializedName("original_title") override val name: String,
    @SerializedName("overview") override val description: String,
    @SerializedName("poster_path") override var poster: String,
    @SerializedName("release_date") override var releaseDate: String,
    @SerializedName("vote_average") override var voteAverage: String,
) : MediaModel