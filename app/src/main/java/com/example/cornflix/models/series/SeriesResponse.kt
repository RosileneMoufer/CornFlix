package com.example.cornflix.models.series

import com.example.cornflix.models.movie.MoviesModel
import com.google.gson.annotations.SerializedName

data class SeriesResponse (
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<SeriesModel>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int,
)