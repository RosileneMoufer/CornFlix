package com.example.cornflix.model

import com.google.gson.annotations.SerializedName

// metadados do código
data class MediaResponse<T: MediaModel> (
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)