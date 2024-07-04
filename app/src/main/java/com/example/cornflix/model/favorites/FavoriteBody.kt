package com.example.cornflix.model.favorites

import com.google.gson.annotations.SerializedName

data class FavoriteBody(
    //@SerializedName("favorite")
    val favorite: Boolean,
    @SerializedName("media_id")
    val mediaId: String,
    @SerializedName("media_type")
    val mediaType: String
)