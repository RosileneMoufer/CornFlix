package com.example.cornflix.model.series

import com.example.cornflix.model.MediaModel
import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("id") override val id: String,
    @SerializedName("name") override val name: String,
    @SerializedName("overview") override val description: String,
    @SerializedName("poster_path") override var poster: String,
    @SerializedName("first_air_date") override var releaseDate: String,
    @SerializedName("vote_average") override var voteAverage: String,
) : MediaModel