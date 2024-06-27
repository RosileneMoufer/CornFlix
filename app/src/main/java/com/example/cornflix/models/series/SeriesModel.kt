package com.example.cornflix.models.series

import com.example.cornflix.models.MediaModel
import com.google.gson.annotations.SerializedName

data class SeriesModel(
    @SerializedName("id")
    val idSeries: String,
    @SerializedName("name")
    val nameSeries: String,
    @SerializedName("overview")
    val descriptionSeries: String,
    @SerializedName("poster_path")
    var posterSeries: String,
    @SerializedName("first_air_date")
    var releaseDateSeries: String,
    @SerializedName("vote_average")
    var voteAverageSeries: String,
) : MediaModel by object : MediaModel {
    override val id: String
        get() = idSeries
    override val name: String
        get() = nameSeries
    override val description: String
        get() = descriptionSeries
    override val poster: String
        get() = posterSeries
    override val releaseDate: String
        get() = releaseDateSeries
    override val voteAverage: String
        get() = voteAverageSeries
}