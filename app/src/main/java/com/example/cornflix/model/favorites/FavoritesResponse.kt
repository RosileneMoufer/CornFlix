package com.example.cornflix.model.favorites

import com.google.gson.annotations.SerializedName

data class FavoritesResponse(
    @SerializedName("status_code") val id: Int,
    @SerializedName("status_message") val name: String
)