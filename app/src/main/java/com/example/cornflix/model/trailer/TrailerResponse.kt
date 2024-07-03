package com.example.cornflix.model.trailer

import com.google.gson.annotations.SerializedName

data class TrailerResponse(
    @SerializedName("id") val id: String,
    @SerializedName("results") val results: List<Trailer>
)

data class Trailer(
    @SerializedName("key") val key: String,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String
)